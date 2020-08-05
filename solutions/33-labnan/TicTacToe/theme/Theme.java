package theme;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public interface Theme {
    String getCross();

    String getZero();

    Text getText();

    Pane getSquarePane();

    Rectangle getBoardRectangle();

    Pane getBoardPane();

}

