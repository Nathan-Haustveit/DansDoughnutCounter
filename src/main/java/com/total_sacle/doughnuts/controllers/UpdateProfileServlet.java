package com.total_sacle.doughnuts.controllers;

import com.total_sacle.doughnuts.dao.DaoFactory;
import com.total_sacle.doughnuts.models.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

    @WebServlet("/profileupdate")
    public class UpdateProfileServlet extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            if (request.getSession().getAttribute("employee") == null) {
                response.sendRedirect("/login");
                return;
            }
            request.getRequestDispatcher("/WEB-INF/updateProfile.jsp")
                    .forward(request, response);
            request.setAttribute("employee", DaoFactory.getEmployeesDao().all());
        }

        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
            Employee employee = (Employee) request.getSession().getAttribute("employee");

            Employee employees = new Employee(
                    employee.getId(),
                    request.getParameter("name"),
                    request.getParameter("username"),
                    request.getParameter("password")
            );

            DaoFactory.getEmployeesDao().update(employees);
            response.sendRedirect("/profile");
        }
    }
