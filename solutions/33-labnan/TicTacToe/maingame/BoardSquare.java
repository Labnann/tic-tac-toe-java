package maingame;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import theme.ForestTheme;
import theme.Theme;


public class BoardSquare {

    Theme theme;
    Text text;
    private Pane squarePane;
    boolean isTriggered = false;
    private LogicBasedBox logicBasedBox = new LogicBasedBox();
    private Rectangle rectangle;

    public LogicBasedBox.Type getTurnType() {
        return logicBasedBox.getTurnType();
    }

    public BoardSquare(int xAxisIndex, int yAxisIndex) {
        adjustWithTheme(xAxisIndex, yAxisIndex);
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    private void adjustWithTheme(int xAxisIndex, int yAxisIndex) {
        this.theme = new ForestTheme();
        this.text = theme.getText();
        this.squarePane = theme.getSquarePane();
        this.rectangle = theme.getBoardRectangle();
        squarePane.relocate((xAxisIndex * 110), (yAxisIndex * 110));
        squarePane.getChildren().addAll(rectangle, text);
    }

    public boolean isNotTriggered() {
        return !isTriggered;
    }


    public void triggerSquareAs(LogicBasedBox.Type turnType) {
        if (this.isNotTriggered()) {
            logicBasedBox.setTurnType(turnType);
            isTriggered = true;
        }
        setText();
    }

    public void setText() {
        if (logicBasedBox.getTurnType() == LogicBasedBox.Type.CROSS)
            text.setText(theme.getCross());
        else text.setText(theme.getZero());
    }

    public Pane getSquarePane() {
        return squarePane;
    }

    public LogicBasedBox getLogicBasedBox() {
        return logicBasedBox;
    }
}


