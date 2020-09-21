package maingame.UI.MarkUI;

import javafx.scene.layout.Pane;
import maingame.theme.Theme;

public class ZeroMarkUI implements MarkUI {
    Theme theme;
    Pane squarePane;

    public ZeroMarkUI(Theme theme, Pane squarePane) {
        this.theme = theme;
        this.squarePane = squarePane;
    }

    public void putMark() {
        theme.setZeroMark(squarePane);
    }

}
