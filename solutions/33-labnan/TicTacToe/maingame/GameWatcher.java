package maingame;

public class GameWatcher {

    CheckerLine[] rowLine = new CheckerLine[3];
    CheckerLine[] columnLine = new CheckerLine[3];
    CheckerLine leadingDiagonalLine;
    CheckerLine antiDiagonalLine;


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
    int count = 1;
    LogicBasedBox.Type type;
    boolean status = true;

    public void addType(LogicBasedBox.Type type) {
        if (this.type == null) {
            this.type = type;
        } else if (this.type == type) {
            count++;
        } else status = false;
    }

}