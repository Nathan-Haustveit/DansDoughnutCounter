package com.total_sacle.doughnuts.controllers;

import com.total_sacle.doughnuts.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.ProductIndexServlet", urlPatterns = "/product")
public class ProductIndexServlet extends HttpServlet{
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("products", DaoFactory.getProductionsDao().all());
        request.getRequestDispatcher("WEB-INF/products/index.jsp").forward(request, response);
    }

}