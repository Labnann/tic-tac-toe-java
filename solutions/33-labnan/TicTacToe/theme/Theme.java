package theme;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public interface Theme {
    String getCross();

    String getZero();

    void setBoardRectangle(Rectangle boardRectangle);

    void setSquarePane(Pane squarePane);

    void setBoardPane(Pane boardPane);

    void setText(Text text);

}
