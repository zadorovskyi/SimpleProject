package com.softserv.todolist.service;

import com.softserv.todolist.entity.UserDTO;

import javax.servlet.http.HttpSession;


public enum LogingUserIntoSession {

    INSTANCE;

    public static void saveUserToSession(HttpSession session, UserDTO loginedUser) {
        session.setAttribute("loginedUser", loginedUser);
    }

    public static UserDTO getUserFromSessin(HttpSession session) {
        return (UserDTO) session.getAttribute("loginedUser");
    }

    public void signOutUser(HttpSession session) {
        if (session == null || session.getAttribute("loginedUser") == null) {
            getUserFromSessin(session).setIsAuthorized(0);

            session.removeAttribute("loginedUser");
        }
    }
}
