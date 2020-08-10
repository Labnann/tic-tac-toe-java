package maingame;

import java.util.ArrayList;

class SmallCell {
    ArrayList<SmallCellChangeListener> smallCellChangeListeners = new ArrayList<>();
    private Type turnType = null;
    private boolean isTriggered = false;

    public Type getTurnType() {
        return turnType;
    }

    public void setTurnType(Type turnType) {
        if (this.turnType == null)
            this.turnType = turnType;
        doOnTypeChange();
    }

    public void setTriggered(boolean triggered) {
        isTriggered = triggered;
    }

    public void triggerSquareAs(Type turnType){
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
            else i.doOnBoxChange();
        }
    }

    public void addOnSmallCellTrigger(SmallCellChangeListener smallCellChangeListener) {
        this.smallCellChangeListeners.add(smallCellChangeListener);
    }

    enum Type {
        ZERO, CROSS
    }

    interface SmallCellChangeListener {
        void doOnBoxChange();
    }
}