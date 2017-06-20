package com.softserv.todolist.dao;

import com.softserv.todolist.entity.Reminder;
import com.softserv.todolist.entity.User;
import com.softserv.todolist.service.TwoPasswordsIdentityChecker;

import javax.servlet.http.HttpServletRequest;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public enum UserDao {
    INSTANCE;

    public void saveUser(User user) {
        PreparedStatement preparedStatement = null;
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "Insert into user (name, surname, phoneNumber, password, login) values (" +
                "?, ?, ?, ?, ?)";
        {
            try {
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, user.getName());
                preparedStatement.setString(2, user.getSurname());
                preparedStatement.setString(3, user.getPhoneNumber());
                preparedStatement.setString(4, user.getPassword());
                preparedStatement.setString(5, user.getLogin());
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public User getUserById(int id) {
        User user = null;
        PreparedStatement preparedStatement = null;
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "Select * from User where User.userId=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            user = getUserByResultSet(preparedStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public List<Reminder> getAllRemindersByUserId(int userId) {
        List<Reminder> listOfReminders = new ArrayList<>();
        Statement statement = null;
        ResultSet resultSet = null;
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "Select * from Reminder where userId=" + userId;
        try {
            resultSet = connection.createStatement().executeQuery(sql);
            while (resultSet.next()) {
                Reminder reminder = new Reminder();
                reminder.setStatus(resultSet.getInt("state"));
                reminder.setText(resultSet.getString("text"));
                reminder.setReminderId(resultSet.getInt("reminderId"));
                listOfReminders.add(reminder);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listOfReminders;
    }

    public User getUserByLoginAndPassword(String login, String password) {
        User user = null;
        PreparedStatement preparedStatement = null;
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "Select * from User WHERE login = ? and password = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            user = getUserByResultSet(preparedStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    private User getUserByResultSet(PreparedStatement preparedStatement) {
        User user = new User();
        ResultSet resultSet;
        try {
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user.setUserId(resultSet.getInt("userId"));
                user.setName(resultSet.getString("name"));
                user.setSurname(resultSet.getString("surname"));
                user.setPhoneNumber(resultSet.getString("phoneNumber"));
                user.setPassword(resultSet.getString("password"));
                user.setLogin(resultSet.getString("login"));
                //user.addReminder(getAllRemindersByUserId(user.getUserId()));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean userValidate(String login, String password) {
        User user = getUserByLoginAndPassword(login, password);
        if (user == null) {
            return false;
        } else {
            return true;
        }
    }


}