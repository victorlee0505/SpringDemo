package com.example.demo.database.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "EMPLOYEE")
public class EmployeeEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfBirth;

    private BigDecimal salary;

    private int serviceYears;

    private String address;

    private String sinNumber;

    private String driverLicenceNumber;
}