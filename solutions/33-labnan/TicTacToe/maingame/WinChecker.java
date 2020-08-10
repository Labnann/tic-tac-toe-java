package maingame;

public class WinChecker {
    private BoardUI boardUi;
    private boolean gameEnded = false;
    GameEndListener gameEndListener;
    private SmallCell.Type winner = null;
    private short remainingMoveCount = 9;


    WinChecker(BoardUI boardUi) {
        this.boardUi = boardUi;
    }

    public boolean isGameEnded() {
        return gameEnded;
    }

    public void startChecking() {
        boardUi.onChange(this::doOnBoardChange);
    }

    public void checkWin() {
        checkWinAtColumn();
        checkWinAtAllRows();
        checkWinAtAllDiagonals();
    }

    public SmallCell.Type getWinner() {
        return winner;
    }

    public void setOnGameEnd(GameEndListener gameEndListener) {
        this.gameEndListener = gameEndListener;
    }


    private void doOnBoardChange() {
        checkWin();
        if (--remainingMoveCount == 0) {
            gameEnded = true;
        }
        if (gameEnded) {
            doOnGameEnd();
        }
    }

    private void checkWinAtAllDiagonals() {
        if (!gameEnded) checkWinAtLeadingDiagonal();
        if (!gameEnded) checkWinAtAntiDiagonal();
    }

    private void checkWinAtLeadingDiagonal() {
        SmallCell.Type possibleWinner = findMarkAt(0, 0);
        if (!gameEnded) {
            for (int i = 1; i < 3; i++) {
                if (isNotTheSameAsAtIndex(i, i, possibleWinner)) {
                    return;
                }
            }
            declareWinner(possibleWinner);
        }
    }

    private SmallCell.Type findMarkAt(int i, int j) {
        return boardUi.getSmallCells()[i][j].getTurnType();
    }

    private boolean isNotTheSameAsAtIndex(int column, int row, SmallCell.Type possibleWinner) {
        return findMarkAt(row, column) != possibleWinner || findMarkAt(row, column) == null;
    }

    // i = 0; j = 2
    // i = 2; j = 0
    // m = (2-0)/(0-2) = -1
    // j = mi + c; j = -1i + 2; j = 2-1*i  =  2 - i;
    private void checkWinAtAntiDiagonal() {
        SmallCell.Type possibleWinner = findMarkAt(0, 2);
        if (!gameEnded) {
            for (int i = 1; i < 3; i++) {
                if (isNotTheSameAsAtIndex(2 - i, i, possibleWinner)) {
                    return;
                }
            }
            declareWinner(possibleWinner);
        }
    }

    private void declareWinner(SmallCell.Type possibleWinner) {
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

    private void doOnGameEnd() {
        System.out.println("Game Ended, Winner: " + getWinner());
        if (gameEndListener != null)
            gameEndListener.doOnGameEnd();
    }

    private void checkWinAtColumn(final int column) {
        SmallCell.Type possibleWinner = findMarkAt(column, 0);
        for (int row = 1; row < 3; row++) {
            if (isElementOnSameLineEqual(row, possibleWinner, column)) return;
        }
        declareWinner(possibleWinner);
    }

    private void checkWinAtRow(final int row) {
        SmallCell.Type possibleWinner = findMarkAt(0, row);
        for (int column = 1; column < 3; column++) {
            if (isElementOnSameLineEqual(row, possibleWinner, column)) return;
        }
        declareWinner(possibleWinner);
    }

    private boolean isElementOnSameLineEqual(int staticIndex, SmallCell.Type possibleWinner, int changingIndex) {
        if (findMarkAt(changingIndex, staticIndex) == null) {
            return true;
        } else return possibleWinner != findMarkAt(changingIndex, staticIndex);
    }


    interface GameEndListener {
        void doOnGameEnd();
    }
}

