package maingame.gamestatus;

import maingame.PlayerMark;

import java.util.ArrayList;

public class CheckerLine {
    private int count = 0;
    private PlayerMark playerMark;
    private boolean winnable = true;
    private LineType LINE_TYPE;
    CheckerLine(LineType LINE_TYPE){
        this.LINE_TYPE = LINE_TYPE;
    }

    public LineType getLINE_TYPE() {
        return LINE_TYPE;
    }

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

    public void addDoOnWinnerFound(WinnerFoundListener winnerFoundListener){
        winnerFoundListeners.add(winnerFoundListener);
    }

    private void doOnWinnerFound(){
        for(WinnerFoundListener winnerFoundListener: winnerFoundListeners){
            if(winnerFoundListener == null) return;
            winnerFoundListener.doOnWinnerFound();
        }
    }


   enum LineType{
       ROW, COLUMN, ANTI_DIAGONAL, DIAGONAL
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
