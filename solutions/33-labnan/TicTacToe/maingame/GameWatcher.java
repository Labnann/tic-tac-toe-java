package maingame;

public class GameWatcher {

    private CheckerLine[] rowLine;
    private CheckerLine[] columnLine;
    private CheckerLine leadingDiagonalLine;
    private CheckerLine antiDiagonalLine;
    private CheckerLine[] allLines;

    GameWatcher(SmallCell[][] smallCells) {
        this.smallCells = smallCells;
        initializeLines();
        readyBoxesItemsForChecking();

    }

    public CheckerLine[] getAllLines() {
        return allLines;
    }

    void initializeLines() {
        rowLine = new CheckerLine[3];
        columnLine = new CheckerLine[3];
        allLines = new CheckerLine[8];
        makeReferenceToAllLines();
    }

    public void makeReferenceToAllLines() {
        for (int i = 0; i < 3; i++) {
            columnLine[i] = new CheckerLine();
            rowLine[i] = new CheckerLine();
            this.allLines[i] = rowLine[i];
            this.allLines[i + rowLine.length] = columnLine[i];
        }
        leadingDiagonalLine = new CheckerLine();
        antiDiagonalLine = new CheckerLine();
        this.allLines[rowLine.length + columnLine.length] = leadingDiagonalLine;
        this.allLines[columnLine.length + rowLine.length + 1] = antiDiagonalLine;
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

    SmallCell[][] smallCells;


    private void readyBoxesItemsForChecking() {
        for (int j = 0; j < 3; j++) {
            for (int i = 0; i < 3; i++) {
                addChecker(j, i, i, j);
            }
        }

    }

    private void addChecker(int j, int i, int finalI, int finalJ) {
        addCheckerAtColumn(smallCells[finalI][finalJ], finalJ);
        addCheckerAtRow(finalJ, smallCells[finalJ][finalI], rowLine);
        addCheckerOnDiagonalLine(j, i, smallCells[finalI][finalI]);
        addCheckerOnAntiDiagonalLine(i, j);
    }

    private void addCheckerOnAntiDiagonalLine(int i, int j) {
        if (i == 2 - j) {
            smallCells[i][j].addOnSmallCellTrigger(() -> antiDiagonalLine.addType(smallCells[i][j].getTurnType()));
        }
    }

    private void addCheckerOnDiagonalLine(int j, int i, SmallCell smallCell) {
        if (i == j) {
            smallCell.addOnSmallCellTrigger(() -> leadingDiagonalLine.addType(smallCell.getTurnType()));
        }
    }

    private void addCheckerAtRow(int finalJ, SmallCell smallCell, CheckerLine[] rowLine) {
        smallCell.addOnSmallCellTrigger(() -> rowLine[finalJ].addType(smallCell.getTurnType()));
    }

    private void addCheckerAtColumn(SmallCell smallCell, int finalJ) {
        addCheckerAtRow(finalJ, smallCell, columnLine); //Transposed the matrix
    }


}

class CheckerLine {
    private int count = 0;
    private SmallCell.Type type;
    private boolean winnable = true;

    public void addType(SmallCell.Type type) {
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

    public SmallCell.Type getType() {
        return type;
    }

    public int getCount() {
        return count;
    }
}