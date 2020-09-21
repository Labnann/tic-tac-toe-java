package maingame.theme;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;

public interface Theme {
    void modifyCrossMark(Pane smallSquare);

    void modifyZeroMark(Pane smallSquare);

    void modifySquarePane(Pane squarePane);

    void modifyBoardPane(Pane boardPane);

    void modifyRootPane(Pane rootPane);

    Paint getLineColor();

}
