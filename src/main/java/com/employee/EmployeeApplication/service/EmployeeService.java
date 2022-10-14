package com.employee.EmployeeApplication.service;


import com.employee.EmployeeApplication.entity.Address;
import com.employee.EmployeeApplication.entity.Employee;
import com.employee.EmployeeApplication.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getAnEmployee(int id) {
        return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public void createEmployee(Employee employee) {

        ArrayList<Address> addressArrayList = new ArrayList<>();

        for (Address address : employee.getAddresses()) {
            addressArrayList.add((new Address(
                    address.getName(),
                    address.getNumber(),
                    address.getZipCode(),
                    address.getCity(),
                    address.getCountry(),
                    employee)
            ));
        }
        employee.setAddresses(addressArrayList);
        employeeRepository.save(employee);
    }

    public void updateEmployee(int id, Employee employee) {
        employeeRepository.save(new Employee(id, employee.getEmployeeName(), employee.getEmployeeCity()));
    }

    public void deleteEmployee(int id) {
        employeeRepository.delete(employeeRepository.getReferenceById(id));
    }
}
