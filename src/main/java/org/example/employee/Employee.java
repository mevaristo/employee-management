package org.example.employee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Employee {
    private Long id;
    private String name;
    private String designation;
    private Float wage;
    private String phoneNumber;
    private String address;

    public String toString() {
        return "ID: " + id +
                "\nName: " + name +
                "\nDesignation: " + designation +
                "\nWage: " + wage +
                "\nPhone number: " + phoneNumber +
                "\nAddress: " + address;
    }
}
