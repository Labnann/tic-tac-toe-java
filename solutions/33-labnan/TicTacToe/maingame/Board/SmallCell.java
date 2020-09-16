package maingame.Board;

import maingame.PlayerMark.PlayerMark;

import java.util.ArrayList;

public class SmallCell {
    private ArrayList<SmallCellChangeListener> smallCellChangeListeners = new ArrayList<>();
    private PlayerMark playerMark;
    private boolean isTriggered = false;

    public PlayerMark getPlayerMark() {
        return playerMark;
    }

    public void setPlayerMark(PlayerMark playerMark) {
        if (this.playerMark == null)
            this.playerMark = playerMark;
        doOnTypeChange();
    }

    public void setTriggered(boolean triggered) {
        isTriggered = triggered;
    }

    public void triggerSquareAs(PlayerMark playerMark){
        if(this.isNotTriggered()){
            this.setPlayerMark(playerMark);
            this.setTriggered(true);
        }
    }

    public boolean isNotTriggered() {
        return !isTriggered;
    }

    private void doOnTypeChange() {
        for (SmallCellChangeListener i : smallCellChangeListeners) {
            if (i == null) break;
            else i.doOnCellChange();
        }
    }

    public void addOnSmallCellTrigger(SmallCellChangeListener smallCellChangeListener) {
        this.smallCellChangeListeners.add(smallCellChangeListener);
    }

    public interface SmallCellChangeListener {
        void doOnCellChange();
    }
}