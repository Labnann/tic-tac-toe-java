package maingame;


public class GameWatcher {

    private CheckerLine[] columnLine;
    private CheckerLine[] rowLine;
    private CheckerLine leadingDiagonalLine;
    private CheckerLine antiDiagonalLine;
    private SmallCell[][] smallCells;






    GameWatcher(SmallCell[][] smallCells) {
        this.smallCells = smallCells;
        initializeLines();
        readyBoxesItemsForChecking();

    }



    private void initializeLines() {
        columnLine = new CheckerLine[3];
        rowLine = new CheckerLine[3];
        for (int i = 0; i < 3; i++) {
            rowLine[i] = new CheckerLine();
            columnLine[i] = new CheckerLine();
        }
        leadingDiagonalLine = new CheckerLine();
        antiDiagonalLine = new CheckerLine();
    }




    private void readyBoxesItemsForChecking() {
        for (int j = 0; j < 3; j++) {
            for (int i = 0; i < 3; i++) {
                addChecker(i,j);
            }
        }

    }

    private void addChecker(int i, int j) {

        addCheckerAtColumn(smallCells[i][j], j);
        addCheckerAtRow(j, smallCells[j][i], columnLine);
        addCheckerOnDiagonalLine(j, i, smallCells[i][i]);
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
        addCheckerAtRow(finalJ, smallCell, rowLine); //Transposed the matrix
    }

    public Status status(){
        return new Status(rowLine,columnLine,leadingDiagonalLine,antiDiagonalLine);
    }

    class Status{
        CheckerLine[] rowChecker;
        CheckerLine[] columnChecker;
        CheckerLine diagonalChecker;
        CheckerLine antiDiagonalChecker;

        public Status(CheckerLine[] rowChecker, CheckerLine[] columnChecker, CheckerLine diagonalChecker, CheckerLine antiDiagonalChecker) {
            this.rowChecker = rowChecker;
            this.columnChecker = columnChecker;
            this.diagonalChecker = diagonalChecker;
            this.antiDiagonalChecker = antiDiagonalChecker;
        }

        public CheckerLine getAntiDiagonalChecker() {
            return antiDiagonalChecker;
        }

        public CheckerLine[] getColumnChecker() {
            return columnChecker;
        }

        public CheckerLine[] getRowChecker() {
            return rowChecker;
        }

        public CheckerLine getDiagonalChecker() {
            return diagonalChecker;
        }
    }



}

class CheckerLine {
    private int count = 0;
    private SmallCell.Type type;
    private boolean winnable = true;

    public void addType(SmallCell.Type type) {
        if ( count == 3) return;
        if (this.type == null || this.type == type) {
            this.type = type;
            count++;
        }  else winnable = false;
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



