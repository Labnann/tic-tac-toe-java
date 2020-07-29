package maingame;

public class WinChecker {
    private BoardSquare[][] boardSquare;
    private Board board;
    private boolean gameEnded = false;
    GameEndListener gameEndListener;
    private BoardSquare.PlaceValue winner = null;


    WinChecker(Board board) {
        this.board = board;
        boardSquare = board.getBoardSquares();
    }

    public boolean isGameEnded() {
        return gameEnded;
    }

    public BoardSquare[][] getBoardSquare() {
        return boardSquare;
    }

    public void startChecking() {
        board.setBoardChangeListener(() -> {
            checkWinAtColumns();
            checkAllRows();
            if (gameEnded) {
                doOnGameEnd();
            }
        });
    }

    private void checkAllRows() {
        for (int i = 0; i < 3; i++)
            checkWinAtRow(i);
    }

    private void checkWinAtColumns() {
        for (int i = 0; i < 3; i++) {
            checkWinAtColumns(i);
        }
    }

    void doOnGameEnd() {
        System.out.println("Game Ended, Winner: " + getWinner());
        if (gameEndListener != null)
            gameEndListener.doOnGameEnd();
    }

    public BoardSquare.PlaceValue getWinner() {
        return winner;
    }

    protected void checkWinAtColumns(final int column) {
        BoardSquare.PlaceValue possibleWinner = boardSquare[column][0].getPlaceValue();
        for (int row = 1; row < 3; row++) {
            if (isElementOnSameLineEqual(row, possibleWinner, column)) return;
        }
        gameEnded = true;
        winner = possibleWinner;
    }

    protected void checkWinAtRow(final int row) {
        BoardSquare.PlaceValue possibleWinner = boardSquare[0][row].getPlaceValue();
        for (int column = 1; column < 3; column++) {
            if (isElementOnSameLineEqual(row, possibleWinner, column)) return;
        }
        gameEnded = true;
        winner = possibleWinner;
    }

    private boolean isElementOnSameLineEqual(int staticIndex, BoardSquare.PlaceValue possibleWinner, int changingIndex) {
        if (boardSquare[changingIndex][staticIndex].isNotTriggered()) {
            return true;
        } else return possibleWinner != boardSquare[changingIndex][staticIndex].getPlaceValue();
    }


    public void setOnGameEnd(GameEndListener gameEndListener) {
        this.gameEndListener = gameEndListener;
    }

    interface GameEndListener {
        void doOnGameEnd();
    }
}

