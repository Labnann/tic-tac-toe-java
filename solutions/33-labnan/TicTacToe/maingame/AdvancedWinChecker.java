package maingame;

public class AdvancedWinChecker implements WinChecker{

    GameStatus gameStatus;

    AdvancedWinChecker(GameStatus gameStatus){
        this.gameStatus = gameStatus;

    }

    @Override
    public boolean isGameEnded() {

        return false;
    }



    @Override
    public void checkWin() {

    }

    @Override
    public SmallCell.Type getWinner() {
        return null;
    }

    @Override
    public void setOnGameEnd(GameEndListener gameEndListener) {

    }
}
