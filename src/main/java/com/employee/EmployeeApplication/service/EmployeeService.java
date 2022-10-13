package com.employee.EmployeeApplication.service;


import com.employee.EmployeeApplication.entity.Employee;
import com.employee.EmployeeApplication.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeService {

    List<Employee> employeeList = new ArrayList<>(Arrays.asList(
            new Employee(1,"Alessandro","Paris"),
            new Employee(2,"Federica","Valencia"),
            new Employee(3,"Flavio","Roma")
    ));

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees () {
//        return employeeList;
        return employeeRepository.findAll();
    }

    public Employee getAnEmployee(int id) {
//        try {
//            return employeeList.stream().filter(e -> (
//                e.getEmployeeId() == id)).findFirst().get();
//        } catch (Exception e) {
//           return  new Employee(0,"none","none");
//        }
        return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public void createEmployee(Employee employee) {
//        employeeList.add(employee);
        employeeRepository.save(employee);
    }

    public void updateEmployee(int id,Employee employee) {
//        List<Employee> tmpEmployee = new ArrayList<Employee>();
//        for(Employee emp : employeeList) {
//            if(emp.getEmployeeId() == id){
//                emp.setEmployeeName(employee.getEmployeeName());
//                emp.setEmployeeCity(employee.getEmployeeCity());
//            }
//            tmpEmployee.add(emp);
//        }
//        this.employeeList= tmpEmployee;
        employeeRepository.save(new Employee(id, employee.getEmployeeName(), employee.getEmployeeCity()));
    }

    public void deleteEmployee(int id) {
//        List<Employee> tmpEmployee = new ArrayList<Employee>();
//        for(Employee emp: employeeList) {
//            if(emp.getEmployeeId()== id)
//                continue;
//            tmpEmployee.add(emp);
//        }
//        this.employeeList = tmpEmployee;
        employeeRepository.delete(employeeRepository.getReferenceById(id));
    }
}
