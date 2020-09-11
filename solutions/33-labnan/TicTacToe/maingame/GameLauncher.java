package maingame;

import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import theme.ClassicTheme;
import theme.Theme;


public class GameLauncher {
    private Stage gameRootStage;
    UICreator uiCreator;
    Pane boardPane  = new Pane();
    private SmallCell[][] smallCells = new SmallCell[3][3];
    Theme theme = new ClassicTheme();

    Board board;
    BoardUI boardUI;


    public void setGameRootStage(Stage gameRootStage) {
        this.gameRootStage = gameRootStage;

    }

    void startGame() {
        smallCells = new SmallCell[3][3];
        initializeSmallCells();
        board = new Board(smallCells);
        boardUI = new BoardUI(board,createBoardUI(),boardPane,theme);
        if(uiCreator!=null)
        theme = uiCreator.getTheme();
        uiCreator = new UICreator(gameRootStage,boardUI,theme);
        uiCreator.createUI();
        addButtonFunctions();
        new WinChecker(board).startChecking();
    }

    private void initializeSmallCells() {
        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                smallCells[i][j] = new SmallCell();
            }
        }
    }

    private SmallCellUI[][] createBoardUI() {
        SmallCellUI[][] smallCellUIs = new SmallCellUI[3][3];
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                smallCellUIs[i][j] = createBoardSquare(i, j);
            }
        boardPane.relocate(70, 70);
        return smallCellUIs;
    }

    private SmallCellUI createBoardSquare(int i, int j) {
        SmallCellUI smallCellUI = new SmallCellUI(i, j,smallCells[i][j]);
        boardPane.getChildren().add(smallCellUI.getSquarePane());
        smallCellUI.getSquarePane().setOnMouseClicked(event -> board.triggerSquare(smallCells[i][j]));
        return smallCellUI;
    }

    void addButtonFunctions() {
        uiCreator.getStartButton().setOnMouseClicked(event -> startGame());
    }

}



