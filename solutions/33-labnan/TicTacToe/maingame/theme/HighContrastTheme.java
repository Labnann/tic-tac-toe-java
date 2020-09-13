package maingame.theme;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class HighContrastTheme implements Theme {

    private Text text;

    public void setSquarePane(Pane squarePane) {
        squarePane.setBackground(new Background(new BackgroundFill(Color.DARKGRAY, null, null)));
        squarePane.setPrefSize(100, 100);
    }

    public void setBoardPane(Pane boardPane) {
        boardPane.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, null, null)));
    }

    public void setRootPane(Pane rootPane){
        rootPane.setBackground(new Background(new BackgroundFill(Color.DARKGRAY, null, null)));
    }

    @Override
    public Paint getLineColor() {
        return Color.LIGHTGRAY;
    }

    public void setMark(Text text) {
        this.text = text;
        manageInnerText();
    }

    private void manageInnerText() {
        text.toFront();
        Font textFont = new Font("Arial Black Bold", 60);
        text.relocate(25, 5);
        text.setFont(textFont);
    }

    @Override
    public String getZero() {
        return "O";
    }

    @Override
    public String getCross() {
        return "X";
    }

}
