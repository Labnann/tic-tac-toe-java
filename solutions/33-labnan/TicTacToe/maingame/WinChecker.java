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
            checkWinAtColumn(0);
            if (gameEnded) {
                doOnGameEnd();
            }
        });
    }

    void doOnGameEnd() {
        System.out.println("Game Ended");
        if (gameEndListener != null)
            gameEndListener.doOnGameEnd();
    }

    public BoardSquare.PlaceValue getWinner() {
        return winner;
    }

    protected void checkWinAtColumn(final int column) {
        BoardSquare.PlaceValue possibleWinner = boardSquare[column][0].getPlaceValue();
        for (int i = 1; i < 3; i++) {
            if (boardSquare[column][i].isNotTriggered()) {
                winner = possibleWinner;
            } else if (possibleWinner != boardSquare[column][i].getPlaceValue()) {
                return;
            }
        }
        gameEnded = true;
        winner = possibleWinner;
    }

    protected void checkWinAtRow(final int row) {
        BoardSquare.PlaceValue possibleWinner = boardSquare[0][row].getPlaceValue();
        for (int i = 1; i < 3; i++) {
            if (boardSquare[i][row].isNotTriggered()) {
                winner = possibleWinner;
            } else if (possibleWinner != boardSquare[i][row].getPlaceValue()) {
                return;
            }
        }
        gameEnded = true;
        winner = possibleWinner;
    }


    public void setOnGameEnd(GameEndListener gameEndListener) {
        this.gameEndListener = gameEndListener;
    }

    interface GameEndListener {
        void doOnGameEnd();
    }
}

