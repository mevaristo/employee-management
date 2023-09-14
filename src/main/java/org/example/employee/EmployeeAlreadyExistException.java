package org.example.employee;

class EmployeeAlreadyExistException extends RuntimeException {
    public EmployeeAlreadyExistException(Long id) {
        super("Could not create employee with id " + id + ", because it already exists");
    }
}
