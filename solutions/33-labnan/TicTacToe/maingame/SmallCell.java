package maingame;

import java.util.ArrayList;

class SmallCell {
    ArrayList<BoxChangeListener> boxChangeListeners = new ArrayList<>();
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
        for (BoxChangeListener i : boxChangeListeners) {
            if (i == null) break;
            else i.doOnBoxChange();
        }
    }

    public void addOnBoxChange(BoxChangeListener boxChangeListener) {
        this.boxChangeListeners.add(boxChangeListener);
    }

    enum Type {
        ZERO, CROSS
    }

    interface BoxChangeListener {
        void doOnBoxChange();
    }
}