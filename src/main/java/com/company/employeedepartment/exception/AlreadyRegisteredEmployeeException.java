package com.company.employeedepartment.exception;

public class AlreadyRegisteredEmployeeException extends Exception {

    private static final long serialVersionUID = 7997828512143245128L;

    public AlreadyRegisteredEmployeeException(String message) {
        super(message);
    }
}


