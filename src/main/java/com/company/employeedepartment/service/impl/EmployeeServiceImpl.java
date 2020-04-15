package com.company.employeedepartment.service.impl;

import com.company.employeedepartment.converter.EmployeeConverter;
import com.company.employeedepartment.dao.IEmployeeDAO;
import com.company.employeedepartment.entity.Employee;
import com.company.employeedepartment.exception.AlreadyRegisteredEmployeeException;
import com.company.employeedepartment.exception.EmployeeNotFoundException;
import com.company.employeedepartment.service.IEmployeeService;
import com.company.employeedepartment.vo.EmployeeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    private final IEmployeeDAO employeeDAO;

    private final EmployeeConverter employeeConverter;

    @Autowired
    public EmployeeServiceImpl(EmployeeConverter employeeConverter, IEmployeeDAO employeeDAO) {
        this.employeeConverter = employeeConverter;
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<EmployeeVO> findAll() {
       return employeeDAO.findAll().stream().
                map(employeeConverter :: convertEntityToVO).collect(Collectors.toList());
    }

    @Override
    public EmployeeVO findByEmployeeId(String employeeId) throws EmployeeNotFoundException {
        return employeeDAO.findByEmployeeId(employeeId).map(
                employeeConverter::convertEntityToVO).orElseThrow(() -> new EmployeeNotFoundException("Employee Not found exception"));
    }

    @Override
    public EmployeeVO saveEmployee(Employee providedEmployee) throws AlreadyRegisteredEmployeeException {
        EmployeeVO alreadyRegisteredEmployee = employeeDAO.findByEmployeeId(providedEmployee.getEmployeeId()).map(
                employeeConverter::convertEntityToVO).get();

        if(!alreadyRegisteredEmployee.getEmployeeId().equals(providedEmployee.getEmployeeId())){
            return employeeConverter.convertEntityToVO(employeeDAO.saveAndFlush(providedEmployee));
        }else{
            throw new AlreadyRegisteredEmployeeException("Employee already registered");
        }

    }


}
