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
        board.onChange(() -> {
            checkWin();
            if (gameEnded) {
                doOnGameEnd();
            }
        });
    }

    private void checkWin() {
        checkWinAtColumn();
        checkWinAtAllRows();
        checkWinAtAllDiagonals();
    }

    void checkWinAtAllDiagonals() {
        checkWinAtLeadingDiagonal();
        checkWinAtAntiDiagonal();

    }

    private void checkWinAtLeadingDiagonal() {
        BoardSquare.PlaceValue possibleWinner = boardSquare[0][0].getPlaceValue();
        if (!gameEnded) {
            for (int i = 1; i < 3; i++) {
                if (boardSquare[i][i].getPlaceValue() != possibleWinner || boardSquare[i][i].isNotTriggered()) {
                    return;
                }
            }
            gameEnded = true;
            winner = possibleWinner;
            System.out.println("Winner Found at Leading Diagonal");
        }

    }

    private void checkWinAtAntiDiagonal() {
        // i = 0; j = 2
        // i = 2; j = 0
        // m = (2-0)/(0-2) = -1
        // j = mi + c; j = -1i + 2; j = 2-1*i  =  2 - i;
        BoardSquare.PlaceValue possibleWinner = boardSquare[0][0].getPlaceValue();
        if (!gameEnded) {
            for (int i = 1; i < 3; i++) {
                if (boardSquare[i][2 - i].getPlaceValue() != possibleWinner || boardSquare[i][2 - i].isNotTriggered()) {
                    return;
                }
            }
            gameEnded = true;
            winner = possibleWinner;
            System.out.println("Winner Found at AntiDiagonal");
        }
    }

    private void checkWinAtAllRows() {
        for (int i = 0; i < 3; i++)
            checkWinAtRow(i);
    }

    private void checkWinAtColumn() {

        for (int i = 0; i < 3; i++) {
            checkWinAtColumn(i);
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

    protected void checkWinAtColumn(final int column) {
        if (!isGameEnded()) {
            BoardSquare.PlaceValue possibleWinner = boardSquare[column][0].getPlaceValue();
            for (int row = 1; row < 3; row++) {
                if (isElementOnSameLineEqual(row, possibleWinner, column)) return;
            }
            gameEnded = true;
            winner = possibleWinner;
        }
    }

    protected void checkWinAtRow(final int row) {
        if (!isGameEnded()) {
            BoardSquare.PlaceValue possibleWinner = boardSquare[0][row].getPlaceValue();
            for (int column = 1; column < 3; column++) {
                if (isElementOnSameLineEqual(row, possibleWinner, column)) return;
            }
            gameEnded = true;
            winner = possibleWinner;
        }
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

