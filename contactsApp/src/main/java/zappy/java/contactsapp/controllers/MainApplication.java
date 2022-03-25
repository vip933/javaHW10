package zappy.java.contactsapp.controllers;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import zappy.java.contactsapp.models.Person;
import zappy.java.contactsapp.views.ButtonsView;
import zappy.java.contactsapp.views.PersonInfoView;

public class MainApplication extends Application {

    private TableView<Person> table;
    private PersonInfoView infoView;
    private ButtonsView buttons;

    private final ObservableList<Person> people = FXCollections.observableArrayList();

    @Override
    public void start(Stage stage) {
        stage.setMinWidth(1000);
        stage.setMinHeight(400);
        stage.setTitle("Contacts book");
        stage.setFullScreen(false);

        setupTable();
        setupInfoView();
        setupButtons();

        BorderPane rightPane = new BorderPane();
        rightPane.setTop(this.infoView);
        rightPane.setBottom(buttons);
        BorderPane rootPane = new BorderPane();
        rootPane.setLeft(this.table);
        rootPane.setCenter(rightPane);
        rightPane.setPadding(new Insets(5));

        Scene scene = new Scene(rootPane);
        stage.setScene(scene);
        stage.show();
    }

    private void setupButtons() {
        this.buttons = new ButtonsView();
        buttons.setPadding(new Insets(20));

        buttons.getDeleteButton().setOnAction(
                event -> {
                    int index = table.getSelectionModel().getSelectedIndex();
                    if (index == -1) {
                        return;
                    }
                    table.getItems().remove(index);
                }
        );

        buttons.getEditButton().setOnAction(
                event -> {
                    if (table.getSelectionModel().getSelectedIndex() == -1) {
                        return;
                    }
                    EditScreenApplication appl = new EditScreenApplication();
                    appl.setPerson(table.getSelectionModel().getSelectedItem());
                    appl.setTable(table);
                    appl.setInfo(infoView);
                    appl.start(new Stage());
                }
        );

        buttons.getNewButton().setOnAction(
                event -> {
                    EditScreenApplication appl = new EditScreenApplication();
                    appl.setTable(table);
                    appl.setInfo(infoView);
                    appl.setPeople(people);
                    appl.start(new Stage());
                }
        );
    }

    private void setupInfoView() {
        this.infoView = new PersonInfoView();
    }

    private void setupTable() {
        TableColumn<Person, String> nameColumn = new TableColumn<>("First Name");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));

        TableColumn<Person, String> surnameColumn = new TableColumn<>("Last Name");
        surnameColumn.setMinWidth(200);
        surnameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        table = new TableView<>();
        addExamples();
        table.setItems(people);
        table.getColumns().addAll(nameColumn, surnameColumn);

        table.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> infoView.configure(newValue)
        );
    }

    private void addExamples() {
        for (int i = 0; i < 15; ++i) {
            people.add(new Person(
                    "Maksim",
                    "Leypunskiy",
                    "Pokrovskiy bd, 11",
                    "Moscow",
                    "-",
                    "30.07.2002"
            ));
            people.add(new Person(
                    "Aleksander",
                    "Kychuk",
                    "idk 228",
                    "Yekaterinburg",
                    "123456",
                    "10.10.1930"
            ));
        }
    }

    public static void main(String[] args) {
        launch();
    }
}