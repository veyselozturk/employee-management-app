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
import java.util.Optional;

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
    public Optional<CompanyResponse> createCompany(CompanyRequest request) {
        var company = modelMapper.map(request, Company.class);
        return Optional.of(modelMapper.map(companyRepository.save(company), CompanyResponse.class));
    }

    @Override
    public Optional<CompanyResponse> removeCompanyById(Long companyId) {
        var company = companyRepository.findById(companyId);
        companyRepository.deleteById(companyId);
        return Optional.of(modelMapper.map(company, CompanyResponse.class));
    }

    @Override
    public Optional<CompanyResponse> updateCompany(CompanyUpdateRequest request) {
        var company = companyRepository.findById(request.getCompanyId()).orElseThrow();
        modelMapper.map(request,company);
        return Optional.of(modelMapper.map(companyRepository.saveAndFlush(company), CompanyResponse.class));
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
    public Optional<EmployeeResponse> createEmployee(EmployeeRequest request) {
        var employee = modelMapper.map(request, Employee.class);
        return Optional.of(modelMapper.map(employeeRepository.save(employee), EmployeeResponse.class));
    }

    @Override
    public Optional<EmployeeResponse> removeEmployeeById(Long employeeId) {
        var employee = employeeRepository.findById(employeeId);
        employeeRepository.deleteById(employeeId);
        return Optional.of(modelMapper.map(employee, EmployeeResponse.class));
    }

    @Override
    public Optional<EmployeeResponse> updateEmployee(EmployeeUpdateRequest request) {
        var employee = employeeRepository.findById(request.getEmployeeId()).orElseThrow();
        modelMapper.map(request,employee);
        return Optional.of(modelMapper.map(employeeRepository.saveAndFlush(employee), EmployeeResponse.class));
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
