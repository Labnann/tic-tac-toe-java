package maingame.theme;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class ClassicTheme implements Theme {


    private Text text;

    public void setSquarePane(Pane squarePane) {
        squarePane.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
        squarePane.setPrefSize(100, 100);
    }

    public void setBoardPane(Pane boardPane) {
        boardPane.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
    }

    public void setRootPane(Pane rootPane){
        rootPane.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
    }


    public void setMark(Text text) {
        manageInnerText(text);
    }

    @Override
    public Paint getLineColor() {
        return Color.BLACK;
    }

    private void manageInnerText(Text text) {
        text.toFront();
        Font textFont = new Font("Arial Black Bold", 60);
        text.setOpacity(1);
        text.relocate(25, 5);
        text.setFont(textFont);
    }

    @Override
    public void setAIMark(Pane squarePane) {
        squarePane.getChildren().clear();
        Text text = new Text("O");
        manageInnerText(text);
        manageInnerText(text);
        squarePane.getChildren().add(text);
    }

    @Override
    public void setHumanMark(Pane squarePane) {
        squarePane.getChildren().clear();
        Text text = new Text("X");
        manageInnerText(text);
        manageInnerText(text);
        squarePane.getChildren().add(text);
    }

}
