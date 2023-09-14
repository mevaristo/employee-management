package org.example.employee;

import lombok.NonNull;

import java.util.List;

public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController() {
        employeeService = new EmployeeService();
    }

    public void addEmployee(@NonNull Employee employee) throws EmployeeAlreadyExistException {
        Employee e = employeeService.getEmployee(employee.getId());
        if(e != null)
            throw new EmployeeAlreadyExistException(employee.getId());
        employeeService.addEmployee(employee);
    }

    public Employee getEmployee(@NonNull Long id) throws EmployeeNotFoundException {
        Employee e = employeeService.getEmployee(id);
        if(e != null)
            return e;
        throw new EmployeeNotFoundException(id);
    }

    public void editEmployee(@NonNull Employee editedEmployee) throws EmployeeNotFoundException {
        Employee old = employeeService.getEmployee(editedEmployee.getId());
        if(old != null)
            employeeService.addEmployee(editedEmployee);
        throw new EmployeeNotFoundException(editedEmployee.getId());
    }

    public void deleteEmployee(@NonNull Long id) throws EmployeeNotFoundException {
        Employee toDelete = employeeService.getEmployee(id);
        if(toDelete != null) {
            employeeService.deleteEmployee(id);
        }
        throw new EmployeeNotFoundException(id);
    }

    public List<Employee> listEmployees() {
        return employeeService.listEmployees();
    }
}
