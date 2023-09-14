package org.example;

import org.example.employee.Employee;
import org.example.employee.EmployeeController;

public class Main {
    public static void main(String[] args) {
        // Uncomment the line below to visualize the example in a terminal.
        // usageExample();
    }

    public static void usageExample() {
        EmployeeController employeeController = new EmployeeController();

        Employee alice = new Employee(
                1L,
                "Alice G.",
                "Engineer",
                6667.77f,
                "11-22-33",
                "5th Avenue, 22");
        Employee bob = new Employee(
                2L,
                "Bob H.",
                "Architect",
                6667.77f,
                "11-12-21",
                "6th Avenue, 11");
        Employee carl = new Employee(
                3L,
                "Carl I.",
                "Designer",
                6667.77f,
                "11-23-32",
                "7th Avenue, 99");

        employeeController.addEmployee(alice);
        employeeController.addEmployee(bob);
        employeeController.addEmployee(carl);

        System.out.println("Employees:");
        employeeController.listEmployees().forEach(employee -> {
            System.out.println("---\t---\t---");
            System.out.println(employee.toString());
        });

        System.out.println("---\t---\t---");
        System.out.println("---\t---\t---");
        System.out.println("Bob retired, so we hired Dani");

        employeeController.deleteEmployee(2L);

        Employee dani = new Employee(
                4L,
                "Dani J.",
                "Architect",
                6667.77f,
                "12-12-12",
                "8th Avenue, 1101");

        employeeController.addEmployee(dani);

        System.out.println("Employees:");
        employeeController.listEmployees().forEach(employee -> {
            System.out.println("---\t---\t---");
            System.out.println(employee.toString());
        });

        System.out.println("---\t---\t---");
        System.out.println("---\t---\t---");
        System.out.println("Carl changed address");

        Employee editedCarl = new Employee(
                carl.getId(),
                carl.getName(),
                carl.getDesignation(),
                carl.getWage(),
                carl.getPhoneNumber(),
                "9th Avenue, 13"
        );

        employeeController.editEmployee(editedCarl);

        System.out.println("Employees:");
        employeeController.listEmployees().forEach(employee -> {
            System.out.println("---\t---\t---");
            System.out.println(employee.toString());
        });
    }
}
