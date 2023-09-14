package org.example.employee;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeService {
    private final EmployeeStore store;

    public EmployeeService() {
        store = new EmployeeStore();
    }

    public Employee getEmployee(Long id) {
        return store.get(id);
    }

    public void addEmployee(Employee employee) {
        store.put(employee.getId(), employee);
    }

    public void editEmployee(Employee changedEmployee) {
        store.put(changedEmployee.getId(), changedEmployee);
    }

    public void deleteEmployee(Long id) {
        store.remove(id);
    }

    public List<Employee> listEmployees() {
        return new ArrayList<>(store.values());
    }
}
