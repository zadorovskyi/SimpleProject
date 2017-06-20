package com.softserv.todolist.entity;


import java.util.ArrayList;
import java.util.List;

public class User {
    private int userId;
    private String name;
    private String surname;
    private String phoneNumber;
    private String login;
    private String password;
    private int authorisedStatus;
    private List<Reminder> reminders;
    private UserDTO userDTO;

    public User() {
        authorisedStatus = 0;
    }

    public User(String name, String surname, String phoneNumber, String login, String password) {
        authorisedStatus = 0;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.login = login;
        this.password = password;
    }

    public User(List<Reminder> reminders) {
        this.reminders = new ArrayList<Reminder>();
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int isAuthorisedStatus() {
        return authorisedStatus;
    }

    public void setAuthorisedStatus(int authorisedStatus) {
        this.authorisedStatus = authorisedStatus;
    }

    public List<Reminder> getReminders() {
        return reminders;
    }

    public void addReminder(Reminder reminder) {
        reminders.add(reminder);
    }

    public void addReminder(List<Reminder> reminders) {
        this.reminders = reminders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (userId != user.userId) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (surname != null ? !surname.equals(user.surname) : user.surname != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(user.phoneNumber) : user.phoneNumber != null) return false;
        if (login != null ? !login.equals(user.login) : user.login != null) return false;
        return password != null ? password.equals(user.password) : user.password == null;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", authorisedStatus=" + authorisedStatus +
                ", reminders=" + reminders +
                '}';
    }

    public UserDTO getUserDTO() {
        if (userDTO == null) {
            return userDTO = new UserDTO(name, surname, phoneNumber, userId, authorisedStatus);
        }
        return userDTO;
    }
}