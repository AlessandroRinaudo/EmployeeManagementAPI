package com.employee.EmployeeApplication.entity;

import javax.persistence.*;

@Entity
@Table(name="address")

public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String number;
    private String zipCode;
    private String city;
    private String country;

    public Address() {
    }

    public Address(String name, String number, String zipCode, String city, String country) {
        this.name = name;
        this.number = number;
        this.zipCode = zipCode;
        this.city = city;
        this.country = country;
    }

    @ManyToOne
    private Employee employee;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
