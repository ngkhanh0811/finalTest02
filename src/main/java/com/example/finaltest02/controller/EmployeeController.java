package com.example.finaltest02.controller;/*Welcome to my show !

@author: NgKhanh
Date: 6/26/2023
Time: 7:20 PM

ProjectName: finalTest02*/

import com.example.finaltest02.entity.Employee;
import com.example.finaltest02.impl.EmployeeImpl;
import com.example.finaltest02.impl.JpaExecuterImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name="employeeservlet", value = "/employee")
public class EmployeeController extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        String id = request.getParameter("id");
        if (id == null){
            RequestDispatcher view = request.getRequestDispatcher("/pages/list.jsp");

            EmployeeImpl employee = new EmployeeImpl();

            List<Employee> employeesList = employee.findall();
            request.setAttribute("employees", employeesList);
            view.forward(request, response);
        } else {
            RequestDispatcher details = request.getRequestDispatcher("/pages/details.jsp");
            EmployeeImpl employee = new EmployeeImpl();
            Employee item = employee.getById(id);
            request.setAttribute("item", item);
            details.forward(request, response);
        }
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter("id");
        EmployeeImpl employee = new EmployeeImpl();
        employee.deleteById(id);
        response.sendRedirect(request.getContextPath() + "/employee");
    }
}
