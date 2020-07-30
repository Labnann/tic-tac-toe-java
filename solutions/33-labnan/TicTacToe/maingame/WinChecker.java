package maingame;

public class WinChecker {
    private BoardSquare[][] boardSquare;
    private Board board;
    private boolean gameEnded = false;
    GameEndListener gameEndListener;
    private Turn winner = null;
    private short remainingMoveCount = 9;


    WinChecker(Board board) {
        this.board = board;
        boardSquare = board.getBoardSquares();
    }

    public boolean isGameEnded() {
        return gameEnded;
    }
    
    public void startChecking() {
        board.onChange(this::doOnBoardChange);
    }

    private void doOnBoardChange() {
        if (--remainingMoveCount == 0) {
            gameEnded = true;
        }
        checkWin();
        if (gameEnded) {
            doOnGameEnd();
        }
    }

    public void checkWin() {
        checkWinAtColumn();
        checkWinAtAllRows();
        checkWinAtAllDiagonals();
    }

    private void checkWinAtAllDiagonals() {
        if (!gameEnded) checkWinAtLeadingDiagonal();
        if (!gameEnded) checkWinAtAntiDiagonal();
    }

    private void checkWinAtLeadingDiagonal() {
        Turn possibleWinner = boardSquare[0][0].getTurn();
        if (!gameEnded) {
            for (int i = 1; i < 3; i++) {
                if (isNotTheSameAsAtIndex(i, i, possibleWinner)) {
                    return;
                }
            }
            declareWinner(possibleWinner);
        }
    }


    private boolean isNotTheSameAsAtIndex(int column, int row, Turn possibleWinner) {
        return boardSquare[row][column].getTurn() != possibleWinner || boardSquare[row][column].isNotTriggered();
    }


    // i = 0; j = 2
    // i = 2; j = 0
    // m = (2-0)/(0-2) = -1
    // j = mi + c; j = -1i + 2; j = 2-1*i  =  2 - i;
    private void checkWinAtAntiDiagonal() {
        Turn possibleWinner = boardSquare[0][2].getTurn();
        if (!gameEnded) {
            for (int i = 1; i < 3; i++) {
                if (isNotTheSameAsAtIndex(2 - i, i, possibleWinner)) {
                    return;
                }
            }
            declareWinner(possibleWinner);
        }
    }

    private void declareWinner(Turn possibleWinner) {
        gameEnded = true;
        winner = possibleWinner;
    }

    private void checkWinAtAllRows() {
        for (int i = 0; i < 3; i++)
            if (!isGameEnded())
                checkWinAtRow(i);
    }

    private void checkWinAtColumn() {

        for (int i = 0; i < 3; i++) {
            if (!gameEnded)
                checkWinAtColumn(i);
        }
    }

    void doOnGameEnd() {
        System.out.println("Game Ended, Winner: " + getWinner());
        if (gameEndListener != null)
            gameEndListener.doOnGameEnd();
    }

    public Turn getWinner() {
        return winner;
    }

    private void checkWinAtColumn(final int column) {
        Turn possibleWinner = boardSquare[column][0].getTurn();
            for (int row = 1; row < 3; row++) {
                if (isElementOnSameLineEqual(row, possibleWinner, column)) return;
            }
            declareWinner(possibleWinner);
        }

    private void checkWinAtRow(final int row) {
        Turn possibleWinner = boardSquare[0][row].getTurn();
            for (int column = 1; column < 3; column++) {
                if (isElementOnSameLineEqual(row, possibleWinner, column)) return;
            }
            declareWinner(possibleWinner);
    }

    private boolean isElementOnSameLineEqual(int staticIndex, Turn possibleWinner, int changingIndex) {
        if (boardSquare[changingIndex][staticIndex].isNotTriggered()) {
            return true;
        } else return possibleWinner != boardSquare[changingIndex][staticIndex].getTurn();
    }


    public void setOnGameEnd(GameEndListener gameEndListener) {
        this.gameEndListener = gameEndListener;
    }

    interface GameEndListener {
        void doOnGameEnd();
    }
}

