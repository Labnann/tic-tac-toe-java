package maingame;

public class GameWatcher {

    private CheckerLine[] rowLine;
    private CheckerLine[] columnLine;
    private CheckerLine leadingDiagonalLine;
    private CheckerLine antiDiagonalLine;
    private CheckerLine[] allLines;

    GameWatcher(LogicBasedBox[][] logicBasedBoxes) {
        this.logicBasedBoxes = logicBasedBoxes;
        initializeLines();
        readyBoxesItemsForChecking();

    }

    void initializeLines() {
        rowLine = new CheckerLine[3];
        columnLine = new CheckerLine[3];
        leadingDiagonalLine = new CheckerLine();
        antiDiagonalLine = new CheckerLine();
        allLines = new CheckerLine[9];
        makeReferenceToAllLines();
    }

    public void makeReferenceToAllLines() {
        for (int i = 0; i < 3; i++) {
            this.allLines[i] = rowLine[i];
            this.allLines[i + rowLine.length] = columnLine[i];
        }
        this.allLines[rowLine.length + columnLine.length + 1] = leadingDiagonalLine;
        this.allLines[columnLine.length + rowLine.length + 2] = antiDiagonalLine;
    }

    public boolean isDraw() {
        for (CheckerLine i : allLines) {
            if (i.isWinnable()) return false;
        }
        return true;
    }


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


    private void readyBoxesItemsForChecking() {
        for (int j = 0; j < 3; j++) {
            columnLine[j] = new CheckerLine();
            rowLine[j] = new CheckerLine();
            for (int i = 0; i < 3; i++) {
                addChecker(j, i, i, j);
            }
        }

    }

    private void addChecker(int j, int i, int finalI, int finalJ) {
        addCheckerAtColumn(logicBasedBoxes[finalI][finalJ], finalJ);
        addCheckerAtRow(finalJ, logicBasedBoxes[finalJ][finalI], rowLine);
        addCheckerOnDiagonalLine(j, i, logicBasedBoxes[finalI][finalI]);
        addCheckerOnAntiDiagonalLine(i, j);
    }

    private void addCheckerOnAntiDiagonalLine(int i, int j) {
        if (i == 2 - j) {
            logicBasedBoxes[i][j].addOnBoxChange(() -> antiDiagonalLine.addType(logicBasedBoxes[i][j].getTurnType()));
        }
    }

    private void addCheckerOnDiagonalLine(int j, int i, LogicBasedBox logicBasedBox) {
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
    private boolean winnable = true;

    public void addType(LogicBasedBox.Type type) {
        if (!winnable || count == 3) return;
        if (this.type == null) {
            this.type = type;
            count++;
        } else if (this.type == type) {
            count++;
        } else winnable = false;
    }

    public boolean isWinnable() {
        return winnable;
    }

    public int getCount() {
        return count;
    }
}