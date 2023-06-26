package com.example.finaltest02.controller;/*Welcome to my show !

@author: NgKhanh
Date: 6/26/2023
Time: 7:20 PM

ProjectName: finalTest02*/

import com.example.finaltest02.impl.EmployeeImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name="createservlet", value = "/create")
public class CreateController extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        RequestDispatcher view = req.getRequestDispatcher("/pages/createForm.jsp");
        view.forward(req, res);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
        String fullname = req.getParameter("fullName");
        String address = req.getParameter("address");
        String position = req.getParameter("position");
        String birthDate = req.getParameter("birthDate");
        String department = req.getParameter("department");

        EmployeeImpl employee = new EmployeeImpl();
        try {
            employee.createNew(fullname, address, position, birthDate, department);
            System.out.println();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        res.sendRedirect(req.getContextPath() + "/employee");
    }
}
