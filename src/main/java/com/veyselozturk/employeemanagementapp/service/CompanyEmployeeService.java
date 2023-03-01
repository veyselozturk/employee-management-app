package com.veyselozturk.employeemanagementapp.service;

import com.veyselozturk.employeemanagementapp.dto.request.CompanyRequest;
import com.veyselozturk.employeemanagementapp.dto.request.CompanyUpdateRequest;
import com.veyselozturk.employeemanagementapp.dto.request.EmployeeRequest;
import com.veyselozturk.employeemanagementapp.dto.request.EmployeeUpdateRequest;
import com.veyselozturk.employeemanagementapp.dto.response.CompanyResponse;
import com.veyselozturk.employeemanagementapp.dto.response.EmployeeResponse;

import java.util.List;

public interface CompanyEmployeeService {
    CompanyResponse createCompany (CompanyRequest request);
    CompanyResponse removeCompanyById (Long companyId);
    CompanyResponse updateCompany (CompanyUpdateRequest request);
    List<CompanyResponse> findAllCompany();


    EmployeeResponse createEmployee (EmployeeRequest request);
    EmployeeResponse removeEmployeeById (Long employeeId);
    EmployeeResponse updateEmployee (EmployeeUpdateRequest request);
    List<EmployeeResponse> findAllEmployee();
}
