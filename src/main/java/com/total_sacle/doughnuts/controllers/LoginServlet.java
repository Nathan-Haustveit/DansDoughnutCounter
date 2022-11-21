package com.total_sacle.doughnuts.controllers;

import com.total_sacle.doughnuts.dao.DaoFactory;
import com.total_sacle.doughnuts.models.Employee;
import com.total_sacle.doughnuts.util.Password;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") != null) {
            response.sendRedirect("/profile");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Employee employee = DaoFactory.getEmployeesDao().findByUsername(username);

        if (employee == null) {
            response.sendRedirect("/login");
            return;
        }

        boolean validAttempt = Password.check(password, employee.getPassword());

        if (validAttempt) {
            request.getSession().setAttribute("employee", employee);
            response.sendRedirect("/profile");
        } else {
            response.sendRedirect("/login");
        }
    }
}
