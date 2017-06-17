package com.softserv.todolist.controllet;

import com.softserv.todolist.dao.UserDao;
import com.softserv.todolist.entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by jarki on 6/17/2017.
 */
@WebServlet(urlPatterns = "/signup")
public class SignUpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/signup.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String message;
        String name = req.getParameter("name");
        int age = 0;
        try {
            age = Integer.parseInt(req.getParameter("age"));
        }catch (NumberFormatException e){
            e.printStackTrace();
        }

        String address = req.getParameter("address");
        String password = req.getParameter("password");
        String login = req.getParameter("login");

        System.out.println(password);
        if (name == "" || address == "" || password == "" || login == "") {
            message = "Data is incorrect";
        } else {
            if(UserDao.INSTANCE.userValidate(login, password)){
                message = "User exist";
            }else {
                User user = new User(name, age, address, password, login);
                UserDao.INSTANCE.saveUser(user);
                message = "Success!";
            }
        }
        req.setAttribute("message", message);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/signup.jsp");
        dispatcher.forward(req, resp);



    }
}
