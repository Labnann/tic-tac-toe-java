package maingame.UI;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Button {
    Pane pane = new Pane();
    Text text = new Text();
    Rectangle rectangle = new Rectangle(220, 30);

    Button(String buttonText) {
        configText(buttonText);
        pane.getChildren().addAll(rectangle, text);
    }

    private void configText(String buttonText) {
        text.setFont(new Font("Arial", 20));
        text.setText(buttonText);
        text.setFill(Color.WHITE);
        text.relocate(5, 5);
    }

    public Pane getPane() {
        return pane;
    }


}
