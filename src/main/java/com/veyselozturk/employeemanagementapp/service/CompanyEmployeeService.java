package com.veyselozturk.employeemanagementapp.service;

import com.veyselozturk.employeemanagementapp.dto.request.CompanyRequest;
import com.veyselozturk.employeemanagementapp.dto.request.CompanyUpdateRequest;
import com.veyselozturk.employeemanagementapp.dto.request.EmployeeRequest;
import com.veyselozturk.employeemanagementapp.dto.request.EmployeeUpdateRequest;
import com.veyselozturk.employeemanagementapp.dto.response.CompanyResponse;
import com.veyselozturk.employeemanagementapp.dto.response.EmployeeResponse;
import com.veyselozturk.employeemanagementapp.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface CompanyEmployeeService {
    Optional<CompanyResponse> createCompany (CompanyRequest request);
    Optional<CompanyResponse> removeCompanyById (Long companyId);
    Optional<CompanyResponse> updateCompany (CompanyUpdateRequest request);
    List<CompanyResponse> findAllCompany();


    Optional<EmployeeResponse> createEmployee (EmployeeRequest request);
    Optional<EmployeeResponse> removeEmployeeById (Long employeeId);
    Optional<EmployeeResponse> updateEmployee (EmployeeUpdateRequest request);
    List<EmployeeResponse> findAllEmployee();
}
