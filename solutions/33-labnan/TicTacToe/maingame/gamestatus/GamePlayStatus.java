package maingame.gamestatus;


import maingame.Board.Board;
import maingame.LineType;
import maingame.Board.SmallCell;
import maingame.Position;

public class GamePlayStatus implements GameStatus {

    private CheckerLine[] columnLines;
    private CheckerLine[] rowLines;
    private CheckerLine leadingDiagonalLine;
    private CheckerLine antiDiagonalLine;
    private int turnCount;
    Board board;


    public GamePlayStatus(Board board) {
        this.board= board;
        initializeLines();
        readyPositionsForChecking();
    }

    @Override
    public int getTurnCount() {
        return turnCount/2;      //turnCount is doubled so we divide by two, may fix later..
    }

    private void initializeLines() {
        columnLines = new CheckerLine[3];
        rowLines = new CheckerLine[3];
        for (int i = 0; i < 3; i++) {
            rowLines[i] = new CheckerLine(LineType.ROW,i);
            columnLines[i] = new CheckerLine(LineType.COLUMN,i);
        }
        leadingDiagonalLine = new CheckerLine(LineType.DIAGONAL,0);
        antiDiagonalLine = new CheckerLine(LineType.ANTI_DIAGONAL,0);
    }


    @Override
    public CheckerLine getAntiDiagonalChecker() {
        return antiDiagonalLine;
    }

    @Override
    public CheckerLine[] getColumnChecker() {
        return columnLines;
    }

    @Override
    public CheckerLine[] getRowChecker() {
        return rowLines;
    }

    @Override
    public CheckerLine getDiagonalChecker() {
        return leadingDiagonalLine;
    }




    private void readyPositionsForChecking() {
        for (int column = 0; column < 3; column++) {
            for (int row = 0; row < 3; row++) {
                addCheckerAtPosition(new Position(row,column));
            }
        }

    }

    private void addCheckerAtPosition(Position position) {
        addCheckersToNonDiagonals(position);
        addCheckerOnDiagonalLine(position);
        addCheckerOnAntiDiagonalLine(position);
    }

    private void addCheckersToNonDiagonals(Position position) {
        addCheckerAtLineOnPosition(position, rowLines[position.getColumnNum()]); //selecting row according to position
        addCheckerAtLineOnPosition(position, columnLines[position.getRowNum()]); //selecting column according to position
    }

    private void addCheckerOnAntiDiagonalLine(Position position) {
        SmallCell smallCell = board.getSmallCellAt(position);
        if (positionIsOnAntiDiagonal(position)) {
            smallCell.addOnSmallCellTrigger(() -> antiDiagonalLine.mark(smallCell.getTurnType()));
        }
    }

    private boolean positionIsOnAntiDiagonal(Position position) {
        return position.getRowNum()== 2 -position.getColumnNum();
    }

    private void addCheckerOnDiagonalLine(Position position) {
        SmallCell smallCell = board.getSmallCellAt(position);
        if (positionIsOnLeadingDiagonal(position)) {
            smallCell.addOnSmallCellTrigger(() -> leadingDiagonalLine.mark(smallCell.getTurnType()));
        }
    }

    private boolean positionIsOnLeadingDiagonal(Position position) {
        return position.getColumnNum() == position.getRowNum();
    }

    private void addCheckerAtLineOnPosition(Position position, CheckerLine line) {
        SmallCell smallCell = board.getSmallCellAt(position);
        smallCell.addOnSmallCellTrigger(() -> {
           line.mark(smallCell.getTurnType());
            turnCount++;
        });
    }

}



