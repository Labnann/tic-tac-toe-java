package maingame;

import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import theme.ForestTheme;
import theme.Theme;


public class SmallCellUI {

    private Theme theme = new ForestTheme();// = new ForestTheme();
    private Text text = new Text();
    boolean isTriggered = false;
    private SmallCell smallCell = new SmallCell();
    private Pane squarePane = new Pane();

    public SmallCell.Type getTurnType() {
        return smallCell.getTurnType();
    }

    public SmallCellUI(int xAxisIndex, int yAxisIndex) {
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


    public void triggerSquareAs(SmallCell.Type turnType) {
        if (this.isNotTriggered()) {
            smallCell.setTurnType(turnType);
            isTriggered = true;
        }
        setText();
    }

    public void setText() {
        if (smallCell.getTurnType() == SmallCell.Type.CROSS)
            text.setText
                    (theme.getCross());
        else if (smallCell.getTurnType() == SmallCell.Type.ZERO) text.setText(theme.getZero());
    }

    public Pane getSquarePane() {
        return squarePane;
    }

    public SmallCell getSmallCell() {
        return smallCell;
    }
}

