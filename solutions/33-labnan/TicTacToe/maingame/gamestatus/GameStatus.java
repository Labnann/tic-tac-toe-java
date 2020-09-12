package maingame.gamestatus;

public interface GameStatus {
    int getTurnCount();

    CheckerLine getAntiDiagonalChecker();

    CheckerLine[] getColumnChecker();

    CheckerLine[] getRowChecker();

    CheckerLine getDiagonalChecker();
}
