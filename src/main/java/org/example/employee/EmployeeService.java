package org.example.employee;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeService {
    private final EmployeeStore store;

    protected EmployeeService() {
        store = new EmployeeStore();
    }

    protected Employee getEmployee(Long id) {
        return store.get(id);
    }

    protected void addEmployee(Employee employee) {
        store.put(employee.getId(), employee);
    }

    protected void deleteEmployee(Long id) {
        store.remove(id);
    }

    protected List<Employee> listEmployees() {
        return new ArrayList<>(store.values());
    }
}
