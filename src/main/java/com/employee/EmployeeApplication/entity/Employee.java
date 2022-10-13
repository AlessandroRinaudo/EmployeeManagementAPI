package com.employee.EmployeeApplication.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;
    private String employeeName;
    private String employeeCity;

    @OneToOne
    @JoinColumn(name = "fk_spouse")
    private Spouse spouse;

    @OneToMany
    private List<Address> addresses;

    @ManyToMany
    private List<Project> projects;

    public Employee() {

    }

    public Employee(int employeeId, String employeeName, String getEmployeeCity) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeCity = getEmployeeCity;
    }

    public Employee(int employeeId, String employeeName, String getEmployeeCity,Spouse spouse) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeCity = getEmployeeCity;
        this.spouse=spouse;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public Spouse getSpouse() {
        return spouse;
    }

    public void setSpouse(Spouse spouse) {
        this.spouse = spouse;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeCity() {
        return employeeCity;
    }

    public void setEmployeeCity(String employeeCity) {
        this.employeeCity = employeeCity;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public void removeProject(Project project) {
        this.projects.remove(project);
        project.getEmployees().remove(project);
    }

    public void addProject(Project project) {
        this.projects.add(project);
        project.getEmployees().add(this);
    }
}
