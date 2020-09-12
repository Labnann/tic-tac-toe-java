package maingame.gamestatus;

import maingame.PlayerMark;

import java.util.ArrayList;

public class CheckerLine {
    private int count = 0;
    private PlayerMark playerMark;
    private boolean winnable = true;

    ArrayList<WinnerFoundListener> winnerFoundListeners = new ArrayList<>();



    public void addType(PlayerMark type) {
        if ( count == 3){
            return;}
        if (this.playerMark == null || this.playerMark == type) {
            this.playerMark = type;
            count++;
            if(count == 3){doOnWinnerFound();}
        }  else winnable = false;
    }

    public void addWinnerFoundListener(WinnerFoundListener winnerFoundListener){
        winnerFoundListeners.add(winnerFoundListener);
    }

    private void doOnWinnerFound(){
        for(WinnerFoundListener winnerFoundListener: winnerFoundListeners){
            if(winnerFoundListener == null) return;
            winnerFoundListener.doOnWinnerFound();
        }
    }





    public boolean isWinnable() {
        return winnable;
    }

    public PlayerMark getPlayerMark() {
        return playerMark;
    }

    public int getCount() {
        return count;
    }

    public interface WinnerFoundListener{
        void doOnWinnerFound();
    }
}
