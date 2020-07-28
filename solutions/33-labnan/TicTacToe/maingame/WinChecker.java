package maingame;

public class WinChecker {
    private BoardSquare[][] boardSquare;
    private Board board;
    private boolean gameEnded = false;

    WinChecker(Board board) {
        this.board = board;
        boardSquare = board.getBoardSquares();
    }

    public boolean isGameEnded() {
        return gameEnded;
    }

    public BoardSquare[][] getBoardSquare() {
        return boardSquare;
    }

    public void startChecking() {
        board.setBoardChangeListener(() -> {
            checkFirstRow();
            if (gameEnded) {
                doOnGameEnd();
            }
        });
    }

    void doOnGameEnd() {
        System.out.println("Game Ended");
    }

    protected BoardSquare.PlaceValue checkFirstRow() {
        BoardSquare.PlaceValue temp = boardSquare[0][0].getPlaceValue();
        for (int i = 1; i < 3; i++) {
            if (boardSquare[0][i].isNotTriggered()) {
                return boardSquare[0][i].getPlaceValue();
            } else if (temp != boardSquare[0][i].getPlaceValue()) {
                return null;
            }
        }
        gameEnded = true;
        return temp;
    }
}

