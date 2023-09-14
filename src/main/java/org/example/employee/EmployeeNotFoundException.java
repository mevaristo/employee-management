package org.example.employee;

class EmployeeNotFoundException extends RuntimeException {
    protected EmployeeNotFoundException(Long id) {
        super("No employee with id " + id);
    }
}
