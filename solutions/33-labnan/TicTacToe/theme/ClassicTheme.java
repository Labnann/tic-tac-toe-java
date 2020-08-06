package theme;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class ClassicTheme implements Theme {

    ForestTheme forestTheme = new ForestTheme();

    public void setBoardRectangle(Rectangle boardRectangle) {
        forestTheme.setBoardRectangle(boardRectangle);
    }

    public void setSquarePane(Pane squarePane) {
        forestTheme.setSquarePane(squarePane);
    }

    public void setBoardPane(Pane boardPane) {
        forestTheme.setBoardPane(boardPane);
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
