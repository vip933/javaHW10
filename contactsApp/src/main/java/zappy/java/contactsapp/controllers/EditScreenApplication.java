package zappy.java.contactsapp.controllers;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import zappy.java.contactsapp.models.Person;
import zappy.java.contactsapp.views.MutableInfoView;
import zappy.java.contactsapp.views.PersonInfoView;

import java.util.Objects;

public class EditScreenApplication extends Application {
    private Stage stage;
    private final MutableInfoView firstNameView = new MutableInfoView("First Name:");
    private final MutableInfoView lastNameView = new MutableInfoView("Last Name:");
    private final MutableInfoView streetView = new MutableInfoView("Street:");
    private final MutableInfoView cityView = new MutableInfoView("City");
    private final MutableInfoView postalCodeView = new MutableInfoView("Postal Code:");
    private final MutableInfoView birthDateView = new MutableInfoView("Birth Date:");

    private final Button okButton = new Button("Ok");
    private final Button cancelButton = new Button("Cancel");

    private Person person;
    private TableView<Person> table;
    private PersonInfoView info;
    private ObservableList<Person> people;

    @Override
    public void start(Stage stage) {
        this.stage = stage;
        stage.setMinHeight(430);
        stage.setMinWidth(400);
        BorderPane root = new BorderPane();
        VBox info = new VBox(20);
        info.getChildren().addAll(
                firstNameView,
                lastNameView,
                streetView,
                cityView,
                postalCodeView,
                birthDateView
        );
        FlowPane buttons = new FlowPane();
        buttons.getChildren().addAll(
                okButton,
                cancelButton
        );
        root.setTop(info);
        root.setBottom(buttons);
        buttons.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root);
        setupButtons();
        stage.setScene(scene);
        stage.show();
    }

    public void setPerson(Person person) {
        this.person = person;
        firstNameView.getTextField().setText(person.getFirstName());
        lastNameView.getTextField().setText(person.getLastName());
        streetView.getTextField().setText(person.getStreet());
        cityView.getTextField().setText(person.getCity());
        postalCodeView.getTextField().setText(person.getPostalCode());
        birthDateView.getTextField().setText(person.getBirthDate());
    }

    public void setTable(TableView<Person> table) {
        this.table = table;
    }

    public void setInfo(PersonInfoView info) {
        this.info = info;
    }

    public void setPeople(ObservableList<Person> people) {
        this.people = people;
    }

    private void setupButtons() {
        okButton.setOnAction(
                action -> {
                    if (Objects.isNull(person)) {
                        person = new Person();
                        people.add(person);
                    }
                    person.setFirstName(firstNameView.getTextField().getText());
                    person.setLastName(lastNameView.getTextField().getText());
                    person.setStreet(streetView.getTextField().getText());
                    person.setCity(cityView.getTextField().getText());
                    person.setPostalCode(postalCodeView.getTextField().getText());
                    person.setBirthDate(birthDateView.getTextField().getText());
                    stage.close();
                    table.refresh();
                    info.configure(person);
                }
        );

        cancelButton.setOnAction(
                action -> stage.close()
        );
    }
}
