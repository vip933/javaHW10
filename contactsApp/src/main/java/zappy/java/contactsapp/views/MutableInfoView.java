package zappy.java.contactsapp.views;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class MutableInfoView extends VBox {
    private final Label nameLabel;
    private final TextField textField = new TextField();

    public MutableInfoView(String name) {
        this.nameLabel = new Label(name);
        this.nameLabel.setMinWidth(100);

        BorderPane rootPane = new BorderPane();
        rootPane.setLeft(nameLabel);
        rootPane.setCenter(textField);
        rootPane.setPadding(new Insets(10));

        getChildren().add(rootPane);
    }

    public TextField getTextField() {
        return textField;
    }
}
