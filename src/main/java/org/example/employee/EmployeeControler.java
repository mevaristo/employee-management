package org.example.employee;

import lombok.NonNull;

import java.util.List;
import java.util.Optional;

public class EmployeeControler {
    private final EmployeeService employeeService;

    public EmployeeControler() {
        employeeService = new EmployeeService();
    }

    public void addEmployee(@NonNull Employee employee) {
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

    public void deleteEmployee(@NonNull Long id) {
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
