package zappy.java.contactsapp.views;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class InfoTextView extends VBox {
    private final Label labelName;
    private final Label labelValue;

    public InfoTextView(String labelName) {
        this.labelName = new Label(labelName);
        this.labelName.setMinWidth(100);
        this.labelValue = new Label("-");
        labelValue.setAlignment(Pos.TOP_CENTER);
        labelValue.setMinWidth(500);

        BorderPane rootPane = new BorderPane();
        rootPane.setLeft(this.labelName);
        rootPane.setCenter(this.labelValue);

        getChildren().add(rootPane);
    }

    public Label getLabelValue() {
        return labelValue;
    }
}
