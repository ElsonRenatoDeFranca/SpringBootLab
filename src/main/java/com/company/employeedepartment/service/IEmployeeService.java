package com.company.employeedepartment.service;

import com.company.employeedepartment.entity.Employee;
import com.company.employeedepartment.exception.AlreadyRegisteredEmployeeException;
import com.company.employeedepartment.exception.EmployeeNotFoundException;
import com.company.employeedepartment.vo.EmployeeVO;

import java.util.List;

public interface IEmployeeService {

     List<EmployeeVO> findAll();

     EmployeeVO findByEmployeeId(String id) throws EmployeeNotFoundException;

     EmployeeVO saveEmployee(Employee employee) throws AlreadyRegisteredEmployeeException;
}
