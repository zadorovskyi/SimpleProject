package com.softserv.todolist.entity;


public class UserDTO {
    private int isAuthorized;
    private int userId;
    private String name;
    private String phoneNumber;
    private String surname;

    public UserDTO() {
    }

    public UserDTO(String name, String surname, String phoneNumber, int userId, int isAuthorized) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.userId = userId;
        this.isAuthorized = isAuthorized;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getIsAuthorized() {
        return isAuthorized;
    }

    public void setIsAuthorized(int isAuthorized) {
        this.isAuthorized = isAuthorized;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "isAuthorized=" + isAuthorized +
                ", userId=" + userId +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }

    public void setAuthorisedStatus(int authorisedStatus) {
        this.isAuthorized = authorisedStatus;
    }
}