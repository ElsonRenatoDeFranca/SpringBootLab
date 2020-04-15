package com.company.employeedepartment.converter;

import com.company.employeedepartment.entity.Employee;
import com.company.employeedepartment.vo.EmployeeVO;
import org.springframework.stereotype.Component;

@Component
public class EmployeeConverter {

    public EmployeeVO convertEntityToVO(Employee employee){
        EmployeeVO employeeVO = new EmployeeVO();

        if(employee != null){
            employeeVO.setEmployeeId(employee.getEmployeeId());
            employeeVO.setFirstName(employee.getFirstName());
            employeeVO.setLastName(employee.getLastName());
            employeeVO.setEmail(employee.getEmail());
        }

        return employeeVO;

    }


    public Employee convertVOToEntity(EmployeeVO employeeVO){
        Employee employee = new Employee();

        if(employeeVO != null){
            employee.setEmployeeId(employeeVO.getEmployeeId());
            employee.setFirstName(employeeVO.getFirstName());
            employee.setLastName(employeeVO.getFirstName());
            employee.setEmail(employeeVO.getEmail());
        }
        return employee;
    }
}
