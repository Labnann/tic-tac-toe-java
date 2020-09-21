package maingame.theme;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class ForestTheme implements Theme {



    public void modifySquarePane(Pane squarePane) {
        squarePane.setBackground(new Background(new BackgroundFill(Color.LIGHTGREEN, null, null)));
        squarePane.setPrefSize(100, 100);
    }

    public void modifyBoardPane(Pane boardPane) {
        boardPane.setBackground(new Background(new BackgroundFill(Color.DARKGREEN, null, null)));
    }


    @Override
    public void modifyRootPane(Pane rootPane) {
        rootPane.setBackground(new Background(new BackgroundFill(Color.LIGHTGREEN, null, null)));

    }


    private void manageInnerText(Text text) {
        text.toFront();
        Font textFont = new Font("Arial Black Bold", 60);
        text.setOpacity(1);
        text.relocate(25, 5);
        text.setFont(textFont);
    }

    @Override
    public void modifyZeroMark(Pane squarePane) {
        squarePane.getChildren().clear();
        Text text = new Text("🍊");
        manageInnerText(text);
        manageInnerText(text);
        squarePane.getChildren().add(text);
    }

    @Override
    public void modifyCrossMark(Pane squarePane) {
        squarePane.getChildren().clear();
        Text text = new Text("🌸");
        manageInnerText(text);
        manageInnerText(text);
        squarePane.getChildren().add(text);
    }


    @Override
    public Paint getLineColor() {
        return Color.DARKGREEN;
    }

}
