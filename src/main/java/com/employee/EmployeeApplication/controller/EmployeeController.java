package com.employee.EmployeeApplication.controller;

import com.employee.EmployeeApplication.entity.Employee;
import com.employee.EmployeeApplication.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@ResponseBody
//@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> findAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{id}")
    public Employee findAnEmployees(@PathVariable int id){
        return employeeService.getAnEmployee(id);
    }

    @PostMapping("/employees")
    public void createEmployee(@RequestBody Employee employee) {
        employeeService.createEmployee(employee);
    }

    @PutMapping("/employees/{id}")
    public String updateEmployee( @PathVariable int id,@RequestBody Employee employee){
        employeeService.updateEmployee(id,employee);
        return "Updated successfully";
    }

    @DeleteMapping("/employees/{id}")
    public List<Employee>deleteEmployee(@PathVariable int id) {
        employeeService.deleteEmployee(id);
        return employeeService.getAllEmployees();
    }


}
