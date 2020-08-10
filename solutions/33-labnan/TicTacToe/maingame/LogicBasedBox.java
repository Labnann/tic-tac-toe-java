package maingame;

import java.util.ArrayList;

class LogicBasedBox {
    ArrayList<BoxChangeListener> boxChangeListeners = new ArrayList<>();
    private Type turnType = null;

    public Type getTurnType() {
        return turnType;
    }

    public void setTurnType(Type turnType) {
        if (this.turnType == null)
            this.turnType = turnType;
        doOnTypeChange();
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