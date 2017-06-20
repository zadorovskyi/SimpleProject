package com.softserv.todolist.filter;

import com.softserv.todolist.entity.UserDTO;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebFilter("/user")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        HttpSession session = req.getSession(false);
        if (session != null) {
            UserDTO logedUser = (UserDTO) session.getAttribute("loginedUser");
            if (logedUser != null) {
                if (logedUser.getIsAuthorized() == 1) {
                    filterChain.doFilter(req, resp);
                }
            } else {
                resp.sendRedirect("/login");
                resp.setHeader("authorizedError","You are not authorized");

            }
        }
    }

    @Override
    public void destroy() {

    }
}
