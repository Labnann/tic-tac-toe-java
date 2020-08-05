package maingame;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;


public class BoardSquare {
    Theme theme = new Theme();
    Text text = theme.getText();
    private Pane squarePane = theme.getSquarePane();
    boolean isTriggered = false;
    private LogicBasedBox logicBasedBox = new LogicBasedBox();
    private Rectangle rectangle = theme.getRectangle();

    public LogicBasedBox.Type getTurnType() {
        return logicBasedBox.getTurnType();
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    public BoardSquare(int xAxisIndex, int yAxisIndex) {
        squarePane.relocate((xAxisIndex * 110), (yAxisIndex * 110));
        squarePane.getChildren().addAll(rectangle, text);
    }

    public boolean isNotTriggered() {
        return !isTriggered;
    }


    public void triggerSquareAs(LogicBasedBox.Type turnType) {
        if (this.isNotTriggered()) {
            logicBasedBox.setTurnType(turnType);
            if (turnType == LogicBasedBox.Type.CROSS)
                setText(theme.getCross());
            else setText(theme.getZero());
            isTriggered = true;
        }
    }

    public void setText(String text) {
        this.text.setText(text);
    }

    public Pane getSquarePane() {
        return squarePane;
    }

    public LogicBasedBox getLogicBasedBox() {
        return logicBasedBox;
    }
}


