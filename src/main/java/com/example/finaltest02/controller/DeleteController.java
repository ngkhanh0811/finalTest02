package com.example.finaltest02.controller;/*Welcome to my show !

@author: NgKhanh
Date: 6/26/2023
Time: 8:15 PM

ProjectName: finalTest02*/


import com.example.finaltest02.impl.EmployeeImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="deleteservlet", value = "/delete")
public class DeleteController extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter("id");
        EmployeeImpl employee = new EmployeeImpl();
        employee.deleteById(id);
        response.sendRedirect(request.getContextPath() + "/employee");
    }
}
