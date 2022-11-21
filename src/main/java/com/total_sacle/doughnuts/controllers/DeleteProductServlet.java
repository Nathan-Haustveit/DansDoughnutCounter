package com.total_sacle.doughnuts.controllers;

import com.total_sacle.doughnuts.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete")
public class DeleteProductServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        long product_id = (Long.parseLong(req.getParameter("delete")));

        DaoFactory.getProductionsDao().delete(product_id);

        resp.sendRedirect("/profile");
    }
}
