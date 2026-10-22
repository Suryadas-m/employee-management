
package com.codenzic.employee_management.service;

import com.codenzic.employee_management.exception.ResourceNotFoundException;
import com.codenzic.employee_management.entity.Employee;
import com.codenzic.employee_management.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    
public Employee updateEmployee(Long id, Employee updatedEmployee) {
    Employee employee = employeeRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException(
            "Employee not found with id: " + id));

    employee.setName(updatedEmployee.getName());
    employee.setEmail(updatedEmployee.getEmail());
    employee.setDepartment(updatedEmployee.getDepartment());
    employee.setSalary(updatedEmployee.getSalary());

    return employeeRepository.save(employee);
}


    
public void deleteEmployee(Long id) {
    if (!employeeRepository.existsById(id)) {
        throw new ResourceNotFoundException(
            "Employee not found with id: " + id);
    }

    employeeRepository.deleteById(id);
}

}
