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
        squarePane.setBackground(createBackground(Color.DARKGRAY));
        squarePane.setPrefSize(100, 100);
    }

    public void setBoardPane(Pane boardPane) {
        boardPane.setBackground(createBackground(Color.LIGHTGRAY));
    }

    public void setRootPane(Pane rootPane){
        rootPane.setBackground(createBackground(Color.DARKGRAY));
    }

    @Override
    public Paint getLineColor() {
        return Color.LIGHTGRAY;
    }

    public void setMark(Text text) {
        manageInnerText(text);
    }

    private void manageInnerText(Text text) {
        text.toFront();
        Font textFont = new Font("Arial Black Bold", 60);
        text.setOpacity(0);
        text.relocate(25, 5);
        text.setFont(textFont);
    }

    @Override
    public void setAIMark(Pane squarePane) {
        //AI will be white
        squarePane.setBackground(createBackground(Color.WHITE));

    }

    @Override
    public void setHumanMark(Pane squarePane) {
        //Human will be black
        squarePane.setBackground(createBackground(Color.BLACK));

    }

    private Background createBackground(Color color) {
        return new Background(new BackgroundFill(color, null, null));
    }

}
