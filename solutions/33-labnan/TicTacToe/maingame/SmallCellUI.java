package maingame;

import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import theme.ForestTheme;
import theme.Theme;


public class SmallCellUI {

    private Theme theme = new ForestTheme();// = new ForestTheme();
    private Text text = new Text();
    private SmallCell smallCell;
    private Pane squarePane = new Pane();

    public SmallCellUI(int xAxisIndex, int yAxisIndex, SmallCell smallCell) {
        squarePane.relocate((xAxisIndex * 110), (yAxisIndex * 110));
        squarePane.getChildren().addAll(text);
        this.smallCell = smallCell;
        smallCell.addOnSmallCellTrigger(this::syncWithTheCell);
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
        adjustWithTheme();
    }


    private void adjustWithTheme() {
        syncWithTheCell();
        theme.setSquarePane(squarePane);
        theme.setText(text);
    }

    private void syncWithTheCell() {
        if (smallCell.getTurnType() == SmallCell.Type.CROSS)
            text.setText(theme.getCross());
        else if (smallCell.getTurnType() == SmallCell.Type.ZERO) text.setText(theme.getZero());
    }

    public Pane getSquarePane() {
        return squarePane;
    }
}




