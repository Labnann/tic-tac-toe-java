package maingame.UI.MarkUI;

import javafx.scene.layout.Pane;
import maingame.theme.Theme;

public class CrossMarkUI implements MarkUI {
    Theme theme;
    Pane squarePane;

    public CrossMarkUI(Theme theme, Pane squarePane) {
        this.theme = theme;
        this.squarePane = squarePane;
    }

    public void putMark() {
        theme.modifyCrossMark(squarePane);
    }
}
