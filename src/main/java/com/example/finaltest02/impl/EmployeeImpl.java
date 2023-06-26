package com.example.finaltest02.impl;/*Welcome to my show !

@author: NgKhanh
Date: 6/14/2023
Time: 7:55 PM

ProjectName: jpa_sem4*/

import com.example.finaltest02.entity.Employee;

import java.util.List;

public class EmployeeImpl extends JpaExecuterImpl<Employee>{
    public EmployeeImpl() {
        super(Employee.class);
    }

    public Object getAll() {
        return findall();
    }
    public Employee getById(String id) {return super.getById(id);}
}
