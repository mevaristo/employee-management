package org.example.employee;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeControllerTest {
    EmployeeController employeeController;
    final Long ID = 1L;
    final String NAME = "Alice";
    final String DESIGNATION = "Analyst";
    final Float WAGE = 1f;
    final String PHONE_NUMBER = "11-232-343";
    final String ADDRESS = "FINAL STREET, 1";
    final Employee EMPLOYEE = new Employee(
            ID,
            NAME,
            DESIGNATION,
            WAGE,
            PHONE_NUMBER,
            ADDRESS
    );

    @BeforeEach
    void setUp() {
        employeeController = new EmployeeController();
    }

    @Test
    @DisplayName("Employee should exist after saving")
    void saveTest() {
        employeeController.addEmployee(EMPLOYEE);

        assertNotNull(employeeController.getEmployee(ID));
    }

    @Test
    @DisplayName("Employee should not be added if it already exists")
    void saveCollisionTest() {
        employeeController.addEmployee(EMPLOYEE);

        assertThrows(EmployeeAlreadyExistException.class, () -> {
            employeeController.addEmployee(EMPLOYEE);
        });
    }

    @Test
    @DisplayName("Employee should be deleted")
    void deleteTest() {
        employeeController.addEmployee(EMPLOYEE);
        employeeController.deleteEmployee(EMPLOYEE.getId());

        assertThrows(EmployeeNotFoundException.class, () -> {
           employeeController.getEmployee(EMPLOYEE.getId());
        });
    }

    @Test
    @DisplayName("Employee should be edited if it exists")
    void editTest() {
        employeeController.addEmployee(EMPLOYEE);
        String newAddress = "INITIAL STREET, 0";

        Employee edited = new Employee(
                EMPLOYEE.getId(),
                EMPLOYEE.getName(),
                EMPLOYEE.getDesignation(),
                EMPLOYEE.getWage(),
                EMPLOYEE.getPhoneNumber(),
                newAddress
        );

        employeeController.editEmployee(edited);
        Employee retrieved = employeeController.getEmployee(EMPLOYEE.getId());

        assertEquals(newAddress, retrieved.getAddress());
    }

    @Test
    @DisplayName("Should throw exception when trying to edit a non existent employee")
    void editNonExistentTest() {
        assertThrows(EmployeeNotFoundException.class, () -> {
            employeeController.editEmployee(EMPLOYEE);
        });
    }

    @Test
    @DisplayName("Should consistently list all saved employees")
    void saveMultiple() {
        List<Long> ids = Arrays.asList(0L, 1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L);
        int expectedSize = 10;

        ids.forEach(id -> {
            employeeController.addEmployee(new Employee(
                    id,
                    EMPLOYEE.getName(),
                    EMPLOYEE.getDesignation(),
                    EMPLOYEE.getWage(),
                    EMPLOYEE.getPhoneNumber(),
                    EMPLOYEE.getAddress()
            ));
        });

        List<Employee> allEmployees = employeeController.listEmployees();

        assertEquals(expectedSize, allEmployees.size());
    }
}