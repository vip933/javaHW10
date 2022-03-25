package zappy.java.contactsapp.views;

import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

public class ButtonsView extends VBox {
    private final Button newButton = new Button("New...");
    private final Button editButton = new Button("Edit...");
    private final Button deleteButton = new Button("Delete");

    public ButtonsView() {
        FlowPane flowPane = new FlowPane();
        flowPane.setHgap(30);
        flowPane.setOrientation(Orientation.HORIZONTAL);
        flowPane.setAlignment(Pos.BOTTOM_RIGHT);
        flowPane.getChildren().addAll(newButton, editButton, deleteButton);
        getChildren().add(flowPane);
    }

    public Button getNewButton() {
        return newButton;
    }

    public Button getEditButton() {
        return editButton;
    }

    public Button getDeleteButton() {
        return deleteButton;
    }
}
