package com.softserv.todolist.dao;

import com.softserv.todolist.entity.Reminder;
import com.softserv.todolist.entity.UserDTO;

import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public enum ReminderDao {
    INSTANCE;

    public void saveNewReminder(String text, UserDTO user) {
        PreparedStatement preparedStatement = null;
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "Insert into reminder (text, userId, state) values ( ?, ?, ?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, text);
            preparedStatement.setInt(2, user.getUserId());
            preparedStatement.setInt(3, 0);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteReminer(int id) {
        Reminder reminder = null;
        PreparedStatement preparedStatement = null;
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "DELETE from reminder where reminder.reminderId=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateReminder(Reminder reminder) {

        PreparedStatement preparedStatement = null;
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "UPDATE reminder SET text=?, state=? WHERE reminderId=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, reminder.getText());
            preparedStatement.setInt(2, reminder.getStatus());
            preparedStatement.setInt(3, reminder.getReminderId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}


