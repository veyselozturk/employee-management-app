package com.veyselozturk.employeemanagementapp.controller;

import com.veyselozturk.employeemanagementapp.dto.request.CompanyRequest;
import com.veyselozturk.employeemanagementapp.dto.request.CompanyUpdateRequest;
import com.veyselozturk.employeemanagementapp.dto.request.EmployeeRequest;
import com.veyselozturk.employeemanagementapp.dto.request.EmployeeUpdateRequest;
import com.veyselozturk.employeemanagementapp.dto.response.CompanyResponse;
import com.veyselozturk.employeemanagementapp.dto.response.EmployeeResponse;
import com.veyselozturk.employeemanagementapp.service.CompanyEmployeeService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;
import java.util.Optional;

@RequestScope
@RestController
@RequestMapping("/employees")
@Validated
public class CompanyEmployeeController{
    private final CompanyEmployeeService companyEmployeeService;

    public CompanyEmployeeController(CompanyEmployeeService companyEmployeeService) {
        this.companyEmployeeService = companyEmployeeService;
    }
    @PostMapping("/createCompany")
    public Optional<CompanyResponse> createCompany(CompanyRequest request){
        return companyEmployeeService.createCompany(request);
    }
    @PostMapping("/createEmployee")
    public Optional<EmployeeResponse> createEmployee(EmployeeRequest request){
        return companyEmployeeService.createEmployee(request);
    }
    @DeleteMapping("/delete/{companyId}")
    public Optional<CompanyResponse> deleteCompanyById(@PathVariable Long companyId){
        return companyEmployeeService.removeCompanyById(companyId);
    }
    @DeleteMapping("/delete/{employeeId}")
    public Optional<EmployeeResponse> deleteEmployeeById(@PathVariable Long employeeId){
        return companyEmployeeService.removeEmployeeById(employeeId);
    }
    @PutMapping(value = "/companyUpdate")
    public Optional<CompanyResponse> updateCompany(@RequestBody CompanyUpdateRequest updateRequest){
        return companyEmployeeService.updateCompany(updateRequest);
    }
    @PutMapping(value = "/employeeUpdate")
    public Optional<EmployeeResponse> updateEmployee(@RequestBody EmployeeUpdateRequest updateRequest){
        return companyEmployeeService.updateEmployee(updateRequest);
    }
    @GetMapping("/getAllCompany")
    public List<CompanyResponse> findAllCompany(){
        return companyEmployeeService.findAllCompany();
    }
    @GetMapping("/getAllEmployee")
    public List<EmployeeResponse> findAllEmployee(){
        return companyEmployeeService.findAllEmployee();
    }
}
