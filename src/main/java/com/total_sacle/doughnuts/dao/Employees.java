package com.total_sacle.doughnuts.dao;

import com.total_sacle.doughnuts.models.Employee;

import java.util.List;

public interface Employees {

    List<Employee> all();

    Employee findByUsername(String username);

    Long insert(Employee employee);

    void update(Employee employee);

    Employee findEmployeeById(long id);
}
