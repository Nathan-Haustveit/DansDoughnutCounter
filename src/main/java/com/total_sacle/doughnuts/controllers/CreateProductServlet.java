package com.total_sacle.doughnuts.controllers;

import com.total_sacle.doughnuts.dao.DaoFactory;
import com.total_sacle.doughnuts.models.Employee;
import com.total_sacle.doughnuts.models.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/product/create")
public class CreateProductServlet extends HttpServlet{
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            if (request.getSession().getAttribute("employee") == null) {
                response.sendRedirect("/login");
                return;
            }
            request.getRequestDispatcher("/WEB-INF/products/create.jsp")
                    .forward(request, response);
        }

        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
            Employee employee = (Employee) request.getSession().getAttribute("employee");

            Product product = new Product(
                    employee.getId(),
                    Long.parseLong(request.getParameter("type")),
                    Integer.parseInt(request.getParameter("amount")),
                    request.getParameter("production_date")

            );
            DaoFactory.getProductionsDao().insert(product);
            response.sendRedirect("/product");
        }
    }

