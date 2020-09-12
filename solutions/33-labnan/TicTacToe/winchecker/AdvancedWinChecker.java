package winchecker;

import maingame.CheckerLine;
import maingame.GameStatus;
import maingame.PlayerMark;

import java.util.ArrayList;

public class AdvancedWinChecker implements WinChecker{

    GameStatus gameStatus;
    PlayerMark playerMark;
    ArrayList<GameEndListener> gameEndListeners = new ArrayList<>();



    public AdvancedWinChecker(GameStatus gameStatus){
        this.gameStatus = gameStatus;
        addListenersToCheckers();

    }

    private void addListenersToCheckers() {

        addListenerToVectors();
        addListenerToDiagonals();

    }

    private void addListenerToDiagonals() {
        addListenerToLineChecker(gameStatus.getDiagonalChecker());
        addListenerToLineChecker(gameStatus.getAntiDiagonalChecker());
    }

    private void addListenerToVectors() {
        for(int i = 0; i<3; i++){
            addListenerToLineChecker(gameStatus.getColumnChecker()[i]);
            addListenerToLineChecker(gameStatus.getRowChecker()[i]);
        }
    }

    private void addListenerToLineChecker(CheckerLine checkerLine) {
       checkerLine.addWinnerFoundListener(() -> {
           setWinner(checkerLine);
           doOnGameEnd();
       });
    }

    private void doOnGameEnd() {
        System.out.println("Winner :"+ getWinner());
        for (GameEndListener gameEndListener: gameEndListeners){
            if (gameEndListener == null) {
               return;
            }
            gameEndListener.doOnGameEnd();
        }
    }

    private void setWinner(CheckerLine checkerLine) {

        if(playerMark ==null)
        playerMark = checkerLine.getPlayerMark();
    }

    @Override
    public boolean isGameEnded() {
        return (getWinner()!=null || gameStatus.getTurnCount()==9);
    }

    @Override
    public PlayerMark getWinner() {
        return playerMark;
    }

    @Override
    public void addOnGameEnd(GameEndListener gameEndListener) {
        gameEndListeners.add(gameEndListener);
    }
}
