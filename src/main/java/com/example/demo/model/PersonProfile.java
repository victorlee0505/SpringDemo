package com.example.demo.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PersonProfile {
    private String name;
    private int age;
    private String email;
    private Address address; // Nested Address object
    private List<PhoneNumber> phoneNumbers; // List of PhoneNumber objects
}
