package maingame;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import theme.Theme;


public class BoardSquare {

    Rectangle rectangle;
    private Theme theme;// = new ForestTheme();
    private Text text = new Text();
    boolean isTriggered = false;
    private LogicBasedBox logicBasedBox = new LogicBasedBox();
    private Pane squarePane = new Pane();

    public LogicBasedBox.Type getTurnType() {
        return logicBasedBox.getTurnType();
    }

    public BoardSquare(int xAxisIndex, int yAxisIndex) {
        squarePane.relocate((xAxisIndex * 110), (yAxisIndex * 110));
        squarePane.getChildren().addAll(text);
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
        adjustWithTheme();
    }


    private void adjustWithTheme() {
        setText();
        theme.setSquarePane(squarePane);
        // theme.setBoardRectangle(rectangle);
        theme.setText(text);


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
        else if (logicBasedBox.getTurnType() == LogicBasedBox.Type.ZERO) text.setText(theme.getZero());
    }

    public Pane getSquarePane() {
        return squarePane;
    }

    public LogicBasedBox getLogicBasedBox() {
        return logicBasedBox;
    }
}


