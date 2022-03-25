package zappy.java.contactsapp.models;

import java.util.Objects;

public class Person {

    private String firstName;
    private String lastName;
    private String street;
    private String city;
    private String postalCode;
    private String birthDate;

    public Person() {
        this.firstName = "-";
        this.lastName = "-";
        this.street = "-";
        this.city = "-";
        this.postalCode = "-";
        this.birthDate = "-";
    }

    public Person(String firstName, String lastName, String street, String city, String postalCode, String birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
        this.birthDate = birthDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setFirstName(String firstName) {
        if (Objects.isNull(firstName)) {
            this.firstName = "-";
        } else {
            this.firstName = firstName;
        }
    }

    public void setLastName(String lastName) {
        if (Objects.isNull(lastName)) {
            this.lastName = "-";
        } else {
            this.lastName = lastName;
        }
    }

    public void setStreet(String street) {
        if (Objects.isNull(street)) {
            this.street = "-";
        } else {
            this.street = street;
        }
    }

    public void setCity(String city) {
        if (Objects.isNull(city)) {
            this.city = "-";
        } else {
            this.city = city;
        }
    }

    public void setPostalCode(String postalCode) {
        if (Objects.isNull(postalCode)) {
            this.postalCode = "-";
        } else {
            this.postalCode = postalCode;
        }
    }

    public void setBirthDate(String birthDate) {
        if (Objects.isNull(birthDate)) {
            this.birthDate = "-";
        } else {
            this.birthDate = birthDate;
        }
    }
}

