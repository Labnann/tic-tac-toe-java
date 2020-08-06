package theme;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class ClassicTheme implements Theme {

    ForestTheme forestTheme = new ForestTheme();


    public void setSquarePane(Pane squarePane) {
        squarePane.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
        squarePane.setPrefSize(100, 100);
    }

    public void setBoardPane(Pane boardPane) {
        boardPane.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
    }


    public void setText(Text text) {
        forestTheme.setText(text);
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
