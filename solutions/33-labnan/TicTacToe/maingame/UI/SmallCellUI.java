package maingame.UI;

import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import maingame.Board.SmallCell;
import maingame.PlayerMarkEnum;
import maingame.Position;
import maingame.theme.ForestTheme;
import maingame.theme.Theme;


public class SmallCellUI {

    private Theme theme = new ForestTheme();
    private Text text = new Text();
    private SmallCell smallCell;
    private Pane squarePane = new Pane();


    public SmallCellUI(Position position, SmallCell smallCell) {
        squarePane.relocate((position.getRowNum()* 110), (position.getColumnNum()* 110));
        squarePane.getChildren().addAll(text);
        this.smallCell = smallCell;
        smallCell.addOnSmallCellTrigger(this::syncWithTheCell);
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
        adjustWithTheme();
    }


    private void adjustWithTheme() {
        text.setText("");
        theme.setSquarePane(squarePane);
        syncWithTheCell();
    }

    MarkUI markUI;

    private void syncWithTheCell() {
        createMarkUI();
        if(markUI!=null)
        markUI.putMark();
        }

    private void createMarkUI() {
        if (smallCell.getMark() == PlayerMarkEnum.HUMAN) {
           markUI = new CrossMarkUI(theme,squarePane);
        } else if (smallCell.getMark() == PlayerMarkEnum.AI) {
            markUI = new ZeroMarkUI(theme,squarePane);
        }
    }


    public Pane getSquarePane() {
        return squarePane;
    }
}

interface MarkUI{
    void putMark();
}

class CrossMarkUI implements MarkUI {
    Theme theme;
    Pane squarePane;
    CrossMarkUI(Theme theme, Pane squarePane){
        this.theme = theme;
        this.squarePane = squarePane;
    }
    public void putMark() {
        theme.setCrossMark(squarePane);
    }
}

class ZeroMarkUI implements MarkUI {
    Theme theme;
    Pane squarePane;
    ZeroMarkUI(Theme theme, Pane squarePane){
        this.theme = theme;
        this.squarePane = squarePane;
    }

    public void putMark() {
        theme.setZeroMark(squarePane);
    }

}






