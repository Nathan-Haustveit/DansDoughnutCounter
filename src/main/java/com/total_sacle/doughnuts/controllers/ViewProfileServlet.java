package com.total_sacle.doughnuts.controllers;

import com.total_sacle.doughnuts.dao.DaoFactory;
import com.total_sacle.doughnuts.models.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.ViewProfileServlet", urlPatterns = "/profile")
public class ViewProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Employee employee = (Employee) request.getSession().getAttribute("employee");

        if (request.getSession().getAttribute("employee") == null) {
            response.sendRedirect("/login");
            return;
        }
        request.setAttribute("products", DaoFactory.getProductionsDao().filterByUsername(employee.getId()));
        request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
    }
}
