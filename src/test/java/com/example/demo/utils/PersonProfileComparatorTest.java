package com.example.demo.utils;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.example.demo.model.Address;
import com.example.demo.model.PersonProfile;
import com.example.demo.model.PhoneNumber;

public class PersonProfileComparatorTest {
    
    @Test
    public void testUtils() {

        // ======= Create an existing profile
        PersonProfile existingProfile = new PersonProfile();
        existingProfile.setName("John Doe");
        existingProfile.setAge(30);
        existingProfile.setEmail("demo@demo.com");
        // Create an Address object
        Address existingAddress = new Address();
        existingAddress.setStreet("123 Main St");
        // existingAddress.setCity("Anytown");
        existingAddress.setState("NY");
        existingAddress.setZipCode("12345");
        existingProfile.setAddress(existingAddress);
        // Create a list of PhoneNumber objects
        // Create a PhoneNumber object
        PhoneNumber existingPhoneNumber1 = new PhoneNumber();
        existingPhoneNumber1.setType("Home");
        existingPhoneNumber1.setNumber("123-456-7890");
        // Create a PhoneNumber object
        PhoneNumber existingPhoneNumber2 = new PhoneNumber();
        existingPhoneNumber2.setType("Mobile");
        existingPhoneNumber2.setNumber("987-654-3210");
        List<PhoneNumber> phoneNumbers = new ArrayList<>();
        existingProfile.setPhoneNumbers(phoneNumbers);
        existingProfile.getPhoneNumbers().add(existingPhoneNumber1);
        existingProfile.getPhoneNumbers().add(existingPhoneNumber2);

        // ======= Create an updated profile
        PersonProfile updatedProfile = new PersonProfile();
        updatedProfile.setName("John Doe");
        updatedProfile.setAge(30);
        updatedProfile.setEmail("demo@google.com");
        // Create an Address object
        Address updatedAddress = new Address();
        updatedAddress.setStreet("123 Main St");
        updatedAddress.setCity("Anytown");
        updatedAddress.setState("NY");
        updatedAddress.setZipCode("54321");
        updatedProfile.setAddress(updatedAddress);
        // Create a list of PhoneNumber objects
        // Create a PhoneNumber object
        PhoneNumber updatedPhoneNumber1 = new PhoneNumber();
        updatedPhoneNumber1.setType("Home");
        updatedPhoneNumber1.setNumber("222-222-2222");
        // Create a PhoneNumber object
        PhoneNumber updatedPhoneNumber2 = new PhoneNumber();
        updatedPhoneNumber2.setType("Mobile");
        updatedPhoneNumber2.setNumber("987-654-3210");
        List<PhoneNumber> phoneNumbers2 = new ArrayList<>();
        updatedProfile.setPhoneNumbers(phoneNumbers2);
        updatedProfile.getPhoneNumbers().add(updatedPhoneNumber1);
        updatedProfile.getPhoneNumbers().add(updatedPhoneNumber2);

        List<String> changedProperties = PersonProfileComparator.updatePersonProfile(existingProfile, updatedProfile);

        assertNotNull(changedProperties);
        for (String property : changedProperties) {
            System.out.println(property);
        }
    }
}
