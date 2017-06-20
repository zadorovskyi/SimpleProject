package com.softserv.todolist.controllet;


import com.mysql.cj.api.Session;
import com.softserv.todolist.dao.ReminderDao;
import com.softserv.todolist.entity.Reminder;
import com.softserv.todolist.entity.UserDTO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/addReminder")
public class AddReminderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("welcome.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDTO user = (UserDTO) req.getSession().getAttribute("loginedUser");
        String text = req.getParameter("text");
        ReminderDao.INSTANCE.saveNewReminder(text, user);
        resp.sendRedirect("/user");



    }

}


