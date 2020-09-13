package maingame.theme;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;

public interface Theme {
    String getCross();

    String getZero();

    void setSquarePane(Pane squarePane);

    void setBoardPane(Pane boardPane);

    void setMark(Text text);

    void setRootPane(Pane rootPane);

    Paint getLineColor();

}
