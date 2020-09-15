package maingame.gamestatus;

import maingame.LineType;
import maingame.PlayerMark;

import java.util.ArrayList;

public class CheckerLine {
    private int count = 0;
    private PlayerMark playerMark;
    private boolean winnable = true;
    private LineType LINE_TYPE;
    private int checkerAt;

    CheckerLine(LineType LINE_TYPE, int checkerAt){
        this.LINE_TYPE = LINE_TYPE;
        this.checkerAt = checkerAt;
    }

    public int getCheckerAt() {
        return checkerAt;
    }

    public LineType getLINE_TYPE() {
        return LINE_TYPE;
    }

    ArrayList<WinnerFoundListener> winnerFoundListeners = new ArrayList<>();



    public void mark(PlayerMark type) {
        if ( count == 3){
            return;
        }

        if (this.playerMark == null || this.playerMark == type) {
            this.playerMark = type;
            count++;
            if(count == 3){doOnWinnerFound();}
        }  else winnable = false;
    }

    public void addDoOnWinnerFound(WinnerFoundListener winnerFoundListener){
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
