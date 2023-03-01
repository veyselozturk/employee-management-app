package com.veyselozturk.employeemanagementapp.service.business;

import com.veyselozturk.employeemanagementapp.dto.request.CompanyRequest;
import com.veyselozturk.employeemanagementapp.dto.request.CompanyUpdateRequest;
import com.veyselozturk.employeemanagementapp.dto.request.EmployeeRequest;
import com.veyselozturk.employeemanagementapp.dto.request.EmployeeUpdateRequest;
import com.veyselozturk.employeemanagementapp.dto.response.CompanyResponse;
import com.veyselozturk.employeemanagementapp.dto.response.EmployeeResponse;
import com.veyselozturk.employeemanagementapp.entity.Company;
import com.veyselozturk.employeemanagementapp.entity.Employee;
import com.veyselozturk.employeemanagementapp.repository.CompanyRepository;
import com.veyselozturk.employeemanagementapp.repository.EmployeeRepository;
import com.veyselozturk.employeemanagementapp.service.CompanyEmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class CompanyEmployeeServiceImp implements CompanyEmployeeService {
    private final CompanyRepository companyRepository;
    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public CompanyEmployeeServiceImp(CompanyRepository companyRepository, EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.companyRepository = companyRepository;
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CompanyResponse createCompany(CompanyRequest request) {
        var company = modelMapper.map(request, Company.class);
        return modelMapper.map(companyRepository.save(company), CompanyResponse.class);
    }

    @Override
    public CompanyResponse removeCompanyById(Long companyId) {
        var company = companyRepository.findById(companyId).orElseThrow();
        companyRepository.deleteById(companyId);
        return modelMapper.map(company, CompanyResponse.class);
    }

    @Override
    public CompanyResponse updateCompany(CompanyUpdateRequest request) {
        var company = companyRepository.findById(request.getCompanyId()).orElseThrow();
        modelMapper.map(request,company);
        return modelMapper.map(companyRepository.saveAndFlush(company), CompanyResponse.class);
    }

    @Override
    public List<CompanyResponse> findAllCompany() {
        return companyRepository.findAll()
                .stream()
                .map(company -> modelMapper.map(company,CompanyResponse.class))
                .sorted(Comparator.comparing(CompanyResponse::getName))
                .toList();
    }

    @Override
    public EmployeeResponse createEmployee(EmployeeRequest request) {
        var company = companyRepository.findById(request.getCompanyId()).orElseThrow(()
                -> new IllegalArgumentException("Company not found"));
        var employee = modelMapper.map(request, Employee.class);
        employee.setCompany(company);
        return modelMapper.map(employeeRepository.save(employee), EmployeeResponse.class);
    }

    @Override
    public EmployeeResponse removeEmployeeById(Long employeeId) {
        var employee = employeeRepository.findById(employeeId).orElseThrow();
        employeeRepository.deleteById(employeeId);
        return modelMapper.map(employee, EmployeeResponse.class);
    }

    @Override
    public EmployeeResponse updateEmployee(EmployeeUpdateRequest request) {
        var company = companyRepository.findById(request.getCompanyId()).orElseThrow(()
                -> new IllegalArgumentException("Company not found"));
        var employee = employeeRepository.findById(request.getEmployeeId()).orElseThrow();
        employee.setCompany(company);
        modelMapper.map(request,employee);

        return modelMapper.map(employeeRepository.saveAndFlush(employee), EmployeeResponse.class);
    }

    @Override
    public List<EmployeeResponse> findAllEmployee() {
        return employeeRepository.findAll()
                .stream()
                .map(employee -> modelMapper.map(employee,EmployeeResponse.class))
                .sorted(Comparator.comparing(EmployeeResponse::getName))
                .toList();
    }
}
