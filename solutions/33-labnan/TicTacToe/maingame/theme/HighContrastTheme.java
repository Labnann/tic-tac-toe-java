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

    public void modifySquarePane(Pane squarePane) {
        squarePane.setBackground(createBackground(Color.DARKGREY));
        squarePane.setPrefSize(100, 100);
    }

    public void modifyBoardPane(Pane boardPane) {
        boardPane.setBackground(createBackground(Color.LIGHTGREY));
    }

    public void modifyRootPane(Pane rootPane) {
        rootPane.setBackground(createBackground(Color.DARKGREY));
    }

    @Override
    public Paint getLineColor() {
        return Color.LIGHTGREY;
    }

    private void manageInnerText(Text text) {
        text.toFront();
        Font textFont = new Font("Arial Black Bold", 60);
        text.setOpacity(0);
        text.relocate(25, 5);
        text.setFont(textFont);
    }

    @Override
    public void modifyZeroMark(Pane squarePane) {
        squarePane.getChildren().clear();
        squarePane.setBackground(createBackground(Color.WHITE));

    }

    @Override
    public void modifyCrossMark(Pane squarePane) {
        squarePane.getChildren().clear();
        squarePane.setBackground(createBackground(Color.BLACK));

    }

    private Background createBackground(Color color) {
        return new Background(new BackgroundFill(color, null, null));
    }

}
