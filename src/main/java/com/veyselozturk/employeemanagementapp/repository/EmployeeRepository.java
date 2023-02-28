package com.veyselozturk.employeemanagementapp.repository;

import com.veyselozturk.employeemanagementapp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
