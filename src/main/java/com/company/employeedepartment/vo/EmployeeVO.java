package com.company.employeedepartment.vo;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class EmployeeVO {
    private String employeeId;
    private String firstName;
    private String lastName;
    private String email;
}