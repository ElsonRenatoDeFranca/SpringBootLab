package com.company.employeedepartment.controller;

import com.company.employeedepartment.entity.Employee;
import com.company.employeedepartment.exception.AlreadyRegisteredEmployeeException;
import com.company.employeedepartment.exception.EmployeeNotFoundException;
import com.company.employeedepartment.service.IEmployeeService;
import com.company.employeedepartment.vo.EmployeeVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    private final IEmployeeService employeeService;

    @Autowired
    public EmployeeController(IEmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping(method= RequestMethod.GET, value = "api/employees")
    @ApiOperation(value="Get all employees", notes="Get all employees in the system", nickname="getAllEmployees")
    public ResponseEntity<List<EmployeeVO>> findAll(){
        return new ResponseEntity<>(employeeService.findAll(), HttpStatus.OK);
    }


    @RequestMapping(method=RequestMethod.GET,value="/api/employees/{employeeId}")
    @ApiOperation(value="Get employee by employeeId", notes="Get the employeeId", nickname="getByEmployeeId")
    public ResponseEntity<EmployeeVO> findByEmployeeId(@PathVariable String employeeId){
        try {
            EmployeeVO employeeVO = employeeService.findByEmployeeId(employeeId);
            return new ResponseEntity<>(employeeVO, HttpStatus.OK);

        }catch(EmployeeNotFoundException employeeNotFoundEx){
            return new ResponseEntity<> (HttpStatus.NOT_FOUND);
        }

    }

    @RequestMapping(method=RequestMethod.POST, value="api/employees")
    @ApiOperation(value="Create a new employee", notes="Create a new employee", nickname="saveEmployee")
    public ResponseEntity<EmployeeVO> saveEmployee(@RequestBody Employee employee) {
        EmployeeVO employeeVO = new EmployeeVO();
        try {
            employeeVO = employeeService.saveEmployee(employee);
            return new ResponseEntity<>(employeeVO, HttpStatus.OK);

        } catch (AlreadyRegisteredEmployeeException e) {
            return new ResponseEntity<> (employeeVO, HttpStatus.ALREADY_REPORTED);
        }
    }


}
