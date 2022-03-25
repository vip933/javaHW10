package zappy.java.contactsapp.views;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import zappy.java.contactsapp.models.Person;

import java.util.Objects;

public class PersonInfoView extends VBox {
    private final Label viewNameLabel = new Label("Person details:");

    private final InfoTextView firstNameView = new InfoTextView("First name:");
    private final InfoTextView lastNameView = new InfoTextView("Last name:");
    private final InfoTextView streetView = new InfoTextView("Street:");
    private final InfoTextView cityView = new InfoTextView("City:");
    private final InfoTextView postalCodeView = new InfoTextView("Postal code:");
    private final InfoTextView birthDateView = new InfoTextView("Birth date:");

    public PersonInfoView() {
        setupUI();
    }

    private void setupUI() {
        setSpacing(30);
        getChildren().addAll(
                viewNameLabel,
                firstNameView,
                lastNameView,
                streetView,
                cityView,
                postalCodeView,
                birthDateView
        );
    }

    public void configure(Person person) {
        if (Objects.isNull(person)) {
            firstNameView.getLabelValue().setText("-");
            lastNameView.getLabelValue().setText("-");
            streetView.getLabelValue().setText("-");
            cityView.getLabelValue().setText("-");
            postalCodeView.getLabelValue().setText("-");
            birthDateView.getLabelValue().setText("-");
            return;
        }
        firstNameView.getLabelValue().setText(Objects.isNull(person.getFirstName()) ? "-" : person.getFirstName());
        lastNameView.getLabelValue().setText(Objects.isNull(person.getLastName()) ? "-" : person.getLastName());
        streetView.getLabelValue().setText(Objects.isNull(person.getStreet()) ? "-" : person.getStreet());
        cityView.getLabelValue().setText(Objects.isNull(person.getCity()) ? "-" : person.getCity());
        postalCodeView.getLabelValue().setText(Objects.isNull(person.getPostalCode()) ? "-" : person.getPostalCode());
        birthDateView.getLabelValue().setText(Objects.isNull(person.getBirthDate()) ? "-" : person.getBirthDate());
    }
}
