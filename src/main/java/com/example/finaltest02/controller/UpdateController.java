package com.example.finaltest02.controller;/*Welcome to my show !

@author: NgKhanh
Date: 6/26/2023
Time: 8:24 PM

ProjectName: finalTest02*/

import com.example.finaltest02.entity.Employee;
import com.example.finaltest02.impl.EmployeeImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name="updateservlet", value = "/update")
public class UpdateController extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String id = req.getParameter("id");
        RequestDispatcher view = req.getRequestDispatcher("/pages/updateForm.jsp");
        EmployeeImpl employee = new EmployeeImpl();
        Employee item = employee.getById(id);
        req.setAttribute("item", item);
        view.forward(req, res);
    }
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String id = req.getParameter("id");
        String fullname = req.getParameter("fullName");
        String address = req.getParameter("address");
        String position = req.getParameter("position");
        String birthDate = req.getParameter("birthDate");
        String department = req.getParameter("department");

        EmployeeImpl employee = new EmployeeImpl();
        employee.updateId(id, fullname, address, position, birthDate, department);
        res.sendRedirect(req.getContextPath() + "/employee");
    }
}
