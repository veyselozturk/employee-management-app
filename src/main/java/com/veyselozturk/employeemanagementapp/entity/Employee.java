package com.veyselozturk.employeemanagementapp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(max=50)
    @Column(name = "employee-name")
    private String name;
    @Size(max=50)
    @Column(name = "employee-surname")
    private String surname;
    @Size(max=50)
    @Column(name = "employee-email")
    private String email;
    @Size(max=15)
    @Column(name = "employee-phone")
    private String phone;

    @ManyToOne
    @JoinColumn(name = "EMPLOYEE_ID")
    private Company company;

}
