package maingame;

public class GameWatcher {

    private CheckerLine[] rowLine = new CheckerLine[3];
    private CheckerLine[] columnLine = new CheckerLine[3];
    private CheckerLine leadingDiagonalLine;
    private CheckerLine antiDiagonalLine;

    public CheckerLine[] getRowLine() {
        return rowLine;
    }

    public CheckerLine[] getColumnLine() {
        return columnLine;
    }

    public CheckerLine getAntiDiagonalLine() {
        return antiDiagonalLine;
    }

    public CheckerLine getLeadingDiagonalLine() {
        return leadingDiagonalLine;
    }

    LogicBasedBox[][] logicBasedBoxes;

    GameWatcher(LogicBasedBox[][] logicBasedBoxes) {
        this.logicBasedBoxes = logicBasedBoxes;
        readyBoxesItemsForChecking();
    }

    private void readyBoxesItemsForChecking() {
        for (int j = 0; j < 3; j++) {
            for (int i = 0; i < 3; i++) {
                addChecker(j, i, i, j);
            }
        }

    }

    private void addChecker(int j, int i, int finalI, int finalJ) {
        addCheckerAtColumn(logicBasedBoxes[finalI][finalJ], finalJ);
        addCheckerAtRow(finalJ, logicBasedBoxes[finalJ][finalI], rowLine);
        addCheckerOnDiagonalLocatedAt(j, i, logicBasedBoxes[finalI][finalI], leadingDiagonalLine);
        addCheckerOnDiagonalLocatedAt(2 - i, j, logicBasedBoxes[finalI][finalJ], antiDiagonalLine);
    }

    private void addCheckerOnDiagonalLocatedAt(int j, int i, LogicBasedBox logicBasedBox, CheckerLine leadingDiagonalLine) {
        if (i == j) {
            logicBasedBox.addOnBoxChange(() -> leadingDiagonalLine.addType(logicBasedBox.getTurnType()));
        }
    }

    private void addCheckerAtRow(int finalJ, LogicBasedBox logicBasedBox, CheckerLine[] rowLine) {
        logicBasedBox.addOnBoxChange(() -> rowLine[finalJ].addType(logicBasedBox.getTurnType()));
    }

    private void addCheckerAtColumn(LogicBasedBox logicBasedBox, int finalJ) {
        addCheckerAtRow(finalJ, logicBasedBox, columnLine); //Transposed the matrix
    }


}

class CheckerLine {
    private int count = 0;
    private LogicBasedBox.Type type;
    private boolean updatable = true;

    public void addType(LogicBasedBox.Type type) {
        if (!updatable || count == 3) return;
        if (this.type == null) {
            this.type = type;
            count++;
        } else if (this.type == type) {
            count++;
        } else updatable = false;
    }

    public int getCount() {
        return count;
    }
}