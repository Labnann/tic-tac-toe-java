package maingame.winchecker;

import maingame.PlayerMark.PlayerMark;
import maingame.gamestatus.CheckerLine;
import maingame.gamestatus.GameStatus;
import maingame.PlayerMark.PlayerMarkEnum;

import java.util.ArrayList;

public class AdvancedWinChecker implements WinChecker{

    private GameStatus gameStatus;
    private PlayerMarkEnum playerMarkEnum;
    private int checkingAt;
    private WinResult winResult;

    public WinResult getWinResult() {
        return winResult;
    }

    ArrayList<GameEndListener> gameEndListeners = new ArrayList<>();

    public AdvancedWinChecker(GameStatus gameStatus){
        this.gameStatus = gameStatus;
    }

    @Override
    public void startChecking(){
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
       checkerLine.addDoOnWinnerFound(() -> {
           winResult = new WinResult(checkerLine.getCheckerAt(),checkerLine.getLineType(),checkerLine.getPlayerMark());
           doOnGameEnd(); });
    }

    private void doOnGameEnd() {
        for (GameEndListener gameEndListener: gameEndListeners){
            if (gameEndListener == null) {
               return;
            }
            gameEndListener.doOnGameEnd();
        }
        gameEndListeners.clear();
    }


    @Override
    public boolean isGameEnded() {
        return (getWinner()!=null || gameStatus.getTurnCount()==9);
    }

    @Override
    public PlayerMark getWinner() {
        if(winResult==null) return null;
        return winResult.getWinner();
    }


    @Override
    public void addOnGameEnd(GameEndListener gameEndListener) {
        gameEndListeners.add(gameEndListener);
    }
}

