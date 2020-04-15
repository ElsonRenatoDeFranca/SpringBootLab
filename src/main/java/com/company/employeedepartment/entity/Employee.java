package com.company.employeedepartment.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity(name="Employee")
public class Employee {
    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(name ="EMPLOYEE_ID", length = 15)
    private String employeeId;

    @Column(name ="FIRST_NAME", length = 30)
    private String firstName;

    @Column(name ="LAST_NAME", length = 30)
    private String lastName;

    @Column(name ="EMAIL", length = 40)
    private String email;
}
