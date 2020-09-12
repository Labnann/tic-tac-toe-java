package maingame;

import java.util.ArrayList;

public class SmallCell {
    private ArrayList<SmallCellChangeListener> smallCellChangeListeners = new ArrayList<>();
    private PlayerMark turnType = null;
    private boolean isTriggered = false;

    public PlayerMark getTurnType() {
        return turnType;
    }

    public void setTurnType(PlayerMark turnType) {
        if (this.turnType == null)
            this.turnType = turnType;
        doOnTypeChange();
    }

    public void setTriggered(boolean triggered) {
        isTriggered = triggered;
    }

    public void triggerSquareAs(PlayerMark turnType){
        if(this.isNotTriggered()){
            this.setTurnType(turnType);
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