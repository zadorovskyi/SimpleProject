package com.softserv.todolist.controllet;

import com.softserv.todolist.dao.ReminderDao;
import com.softserv.todolist.dao.UserDao;
import com.softserv.todolist.entity.Reminder;
import com.softserv.todolist.entity.UserDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


@WebServlet("/user")
public class UserServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/user.jsp").forward(req, resp);

    }

}
