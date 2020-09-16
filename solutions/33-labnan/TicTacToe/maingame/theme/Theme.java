package maingame.theme;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;

public interface Theme {
    void setCrossMark(Pane smallSquare);

    void setZeroMark(Pane smallSquare);

    void setSquarePane(Pane squarePane);

    void setBoardPane(Pane boardPane);

    void setMark(Text text);

    void setRootPane(Pane rootPane);

    Paint getLineColor();

}
