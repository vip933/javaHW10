module zappy.java.contactsapp {
    requires javafx.controls;

    exports zappy.java.contactsapp.controllers;
    opens zappy.java.contactsapp.controllers to javafx.fxml;
    exports zappy.java.contactsapp.views;
    opens zappy.java.contactsapp.views to javafx.fxml;
    exports zappy.java.contactsapp.models;
    opens zappy.java.contactsapp.models to javafx.fxml;
}