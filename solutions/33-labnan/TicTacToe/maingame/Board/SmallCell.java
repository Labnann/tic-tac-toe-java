package maingame.Board;

import maingame.PlayerMarkEnum;

import java.util.ArrayList;

public class SmallCell {
    private ArrayList<SmallCellChangeListener> smallCellChangeListeners = new ArrayList<>();
    private PlayerMarkEnum mark = null;
    private boolean isTriggered = false;

    public PlayerMarkEnum getMark() {
        return mark;
    }

    public void setMark(PlayerMarkEnum mark) {
        if (this.mark == null)
            this.mark = mark;
        doOnTypeChange();
    }

    public void setTriggered(boolean triggered) {
        isTriggered = triggered;
    }

    public void triggerSquareAs(PlayerMarkEnum turnType){
        if(this.isNotTriggered()){
            this.setMark(turnType);
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