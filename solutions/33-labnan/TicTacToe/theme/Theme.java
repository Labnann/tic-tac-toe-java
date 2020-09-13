package theme;

import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public interface Theme {
    String getCross();

    String getZero();

    void setSquarePane(Pane squarePane);

    void setPane(Pane boardPane);

    void setText(Text text);

}
