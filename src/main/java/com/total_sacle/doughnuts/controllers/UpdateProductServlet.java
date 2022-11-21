package com.total_sacle.doughnuts.controllers;

import com.total_sacle.doughnuts.dao.DaoFactory;
import com.total_sacle.doughnuts.models.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/update")
public class UpdateProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("employee") == null) {
            response.sendRedirect("/login");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/products/create.jsp")
                .forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Product product = new Product(

                Long.parseLong(request.getParameter("type")),
                Integer.parseInt(request.getParameter("amount")),
                request.getParameter("production_date"),
                Long.parseLong(request.getParameter("update"))

        );

        DaoFactory.getProductionsDao().update(product);
        response.sendRedirect("/profile");
    }
}
