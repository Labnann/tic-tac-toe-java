package maingame;

public class WinChecker {
    private BoardSquare[][] boardSquare;
    private Board board;
    private boolean gameEnded = false;
    GameEndListener gameEndListener;
    private BoardSquare.PlaceValue winner = null;


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
            checkWinAtColumn(0);
            if (gameEnded) {
                doOnGameEnd();
            }
        });
    }

    void doOnGameEnd() {
        System.out.println("Game Ended");
        if (gameEndListener != null)
            gameEndListener.doOnGameEnd();
    }

    protected BoardSquare.PlaceValue checkWinAtColumn(final int column) {
        BoardSquare.PlaceValue temp = boardSquare[column][0].getPlaceValue();
        for (int i = 1; i < 3; i++) {
            if (boardSquare[column][i].isNotTriggered()) {
                return boardSquare[column][i].getPlaceValue();
            } else if (temp != boardSquare[column][i].getPlaceValue()) {
                return null;
            }
        }
        gameEnded = true;
        return temp;
    }


    public void setOnGameEnd(GameEndListener gameEndListener) {
        this.gameEndListener = gameEndListener;
    }

    interface GameEndListener {
        void doOnGameEnd();
    }
}

