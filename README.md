# Simple employee management Java API

## Tools and dependencies

This project was made using Java 17 and the following tools and libraries:
- Maven 3.8, as the dependency manager and build tool;
- JUnit Jupiter 5, as the testing framework;
- Maven Surefire Plugin 3.1, to easily integrate JUnit tests with Maven;
- Project Lombok, to reduce boilerplate code.

## API

The API is exposed and should be accessed by an EmployeeController instance, which has in-memory storage of Employee 
objects.
It provides simple CRUD (create, read, update and delete) endpoints to manage employees.

## Testing and building

First of all, be sure Maven is installed on your machine, running
```sh
mvn --version
```

Then, to perform tests and build the project, run
```sh
mvn clean package
```

This will generate a Jar file as `target/employee_management-1.0-SNAPSHOT.jar`, which can be imported as a Java module.
