package com.softserv.todolist.controllet;

import com.softserv.todolist.dao.UserDao;
import com.softserv.todolist.entity.Reminder;
import com.softserv.todolist.entity.User;
import com.softserv.todolist.entity.UserDTO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/login.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String message;
        String login = req.getParameter("login");
        String password = req.getParameter("password");


        if (login.length() != 0 || password.length() != 0) {
            User user = UserDao.INSTANCE.getUserByLoginAndPassword(login, password);
            if (user == null) {
                message = "You passed incorrect data. Please try again or Sign up.";
                req.setAttribute("message", message);
                req.getRequestDispatcher("login.jsp").forward(req, resp);

            } else {
                HttpSession session = req.getSession();
                UserDTO userDTO = user.getUserDTO();
                userDTO.setAuthorisedStatus(1);
                System.out.println(userDTO.getIsAuthorized());
                session.setAttribute("loginedUser", userDTO);
                List<Reminder> reminders = UserDao.INSTANCE.getAllRemindersByUserId(userDTO.getUserId());
                req.setAttribute("ListOfReminders", reminders);
                req.getRequestDispatcher("/user.jsp").forward(req,resp);
            }
        } else {
            message = "Data is incorrect";
            req.setAttribute("message", message);
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }
}
