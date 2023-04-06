package org.jd_bootcamp.project.user;

import java.util.Objects;
import java.util.UUID;

public class User {
    // region fields
    private String id;
    private String name;
    private String surname;
    private String userName;
    private String password;
    private String email;
    //endregion

    //region Getter&Setter

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    //endregion
    public User() {
    }

    public User(String name, String surname, String userName, String password, String email) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.surname = surname;
        this.userName = userName;
        this.password = password;
        this.email = email;
    }


    @Override
    public String toString() {
        return "\n\t\tId = " + id +
                "\n\t\tName = '" + name + '\'' +
                "\n\t\tSurname = '" + surname + '\'' +
                "\n\t\tUserName='" + userName + '\'' +
                "\n\t\tPassword='" + password + '\'' +
                "\n\t\tEmail='" + email + '\'' + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userName, user.userName) && Objects.equals(password, user.password);
    }
}
