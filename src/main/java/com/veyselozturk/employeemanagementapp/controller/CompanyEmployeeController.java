package com.veyselozturk.employeemanagementapp.controller;

import com.veyselozturk.employeemanagementapp.dto.request.CompanyRequest;
import com.veyselozturk.employeemanagementapp.dto.request.CompanyUpdateRequest;
import com.veyselozturk.employeemanagementapp.dto.request.EmployeeRequest;
import com.veyselozturk.employeemanagementapp.dto.request.EmployeeUpdateRequest;
import com.veyselozturk.employeemanagementapp.dto.response.CompanyResponse;
import com.veyselozturk.employeemanagementapp.dto.response.EmployeeResponse;
import com.veyselozturk.employeemanagementapp.service.CompanyEmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

@RequestScope
@RestController
@RequestMapping("")
public class CompanyEmployeeController{
    private final CompanyEmployeeService companyEmployeeService;

    public CompanyEmployeeController(CompanyEmployeeService companyEmployeeService) {
        this.companyEmployeeService = companyEmployeeService;
    }
    @PostMapping("company/createCompany")
    public ResponseEntity<CompanyResponse> createCompany(CompanyRequest request){
        return new ResponseEntity<>( companyEmployeeService.createCompany(request), HttpStatus.CREATED);
    }
    @PostMapping("empoloyee/createEmployee")
    public ResponseEntity<EmployeeResponse> createEmployee(EmployeeRequest request){
        return new ResponseEntity<>( companyEmployeeService.createEmployee(request), HttpStatus.CREATED);
    }

    @DeleteMapping("company/delete/{companyId}")
    public CompanyResponse deleteCompanyById(@PathVariable Long companyId){
        return companyEmployeeService.removeCompanyById(companyId);
    }
    @DeleteMapping("empoloyee/delete/{employeeId}")
    public EmployeeResponse deleteEmployeeById(@PathVariable Long employeeId){
        return companyEmployeeService.removeEmployeeById(employeeId);
    }
    @PutMapping(value = "company/companyUpdate")
    public CompanyResponse updateCompany(@RequestBody CompanyUpdateRequest updateRequest){
        return companyEmployeeService.updateCompany(updateRequest);
    }
    @PutMapping(value = "empoloyee/employeeUpdate")
    public EmployeeResponse updateEmployee(@RequestBody EmployeeUpdateRequest updateRequest){
        return companyEmployeeService.updateEmployee(updateRequest);
    }
    @GetMapping("company/getAllCompanies")
    public List<CompanyResponse> findAllCompany(){
        return companyEmployeeService.findAllCompany();
    }
    @GetMapping("empoloyee/getAllEmployees")
    public List<EmployeeResponse> findAllEmployee(){
        return companyEmployeeService.findAllEmployee();
    }
}
