package maingame;


import java.util.ArrayList;

public class GameStatus {

    private CheckerLine[] columnLine;
    private CheckerLine[] rowLine;
    private CheckerLine leadingDiagonalLine;
    private CheckerLine antiDiagonalLine;
    private SmallCell[][] smallCells;
    private int turnCount;




    GameStatus(SmallCell[][] smallCells) {
        this.smallCells = smallCells;
        initializeLines();
        readyBoxesItemsForChecking();

    }

    public int getTurnCount() {
        return turnCount/2;      //turnCount is doubled so we divide by two, may fix later..
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


    public CheckerLine getAntiDiagonalChecker() {
        return antiDiagonalLine;
    }

    public CheckerLine[] getColumnChecker() {
        return columnLine;
    }

    public CheckerLine[] getRowChecker() {
        return rowLine;
    }

    public CheckerLine getDiagonalChecker() {
        return leadingDiagonalLine;
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
        addCheckerAtAVector(j, smallCells[j][i], columnLine);
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

    private void addCheckerAtAVector(int finalJ, SmallCell smallCell, CheckerLine[] rowLine) {
        smallCell.addOnSmallCellTrigger(() -> {
            rowLine[finalJ].addType(smallCell.getTurnType());
            turnCount++;
        });
    }

    private void addCheckerAtColumn(SmallCell smallCell, int finalJ) {
        addCheckerAtAVector(finalJ, smallCell, rowLine); //Transposed the matrix
    }



}



