package maingame;

import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import maingame.Board.SmallCell;
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

        theme.setSquarePane(squarePane);
        syncWithTheCell();
    }

    private void syncWithTheCell() {
        if(smallCell!=null){
        if (smallCell.getTurnType() == PlayerMark.HUMAN)
           theme.setHumanMark(squarePane);
        else if (smallCell.getTurnType() == PlayerMark.AI) theme.setAIMark(squarePane);
        else text.setText("");
        }

    }

    public Pane getSquarePane() {
        return squarePane;
    }
}




