package com.softserv.todolist.controllet;

import com.softserv.todolist.dao.UserDao;
import com.softserv.todolist.entity.User;
import com.softserv.todolist.service.TwoPasswordsIdentityChecker;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = "/registration")
public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/registration.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            String message;
            String name = req.getParameter("name");
            String surname = req.getParameter("surname");
            String phoneNumber = req.getParameter("phoneNumber");
            String password = req.getParameter("password");
            String login = req.getParameter("login");
            if (TwoPasswordsIdentityChecker.passChecker(password, req.getParameter("reppassword"))) {
                if ((name != "" || surname != "" || password != "" || login != "")
                        && !UserDao.INSTANCE.userValidate(login, password)) {
                    User user = new User(name, surname, phoneNumber, login, password);
                    UserDao.INSTANCE.saveUser(user);
                    message = "Success!";
                } else {
                    message = "Data is incorrect";
                }
                req.setAttribute("message", message);
                req.getRequestDispatcher("/login.jsp").forward(req, resp);
            } else {
                req.setAttribute("message", "Passwords did't match");
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            resp.sendError(400, "Data is incorrect");
        }

    }
}