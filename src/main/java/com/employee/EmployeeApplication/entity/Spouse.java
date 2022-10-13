package com.employee.EmployeeApplication.entity;

import javax.persistence.*;

@Entity
@Table(name="spouse")
public class Spouse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private String mobileNo;
    private int age;

    @OneToOne(mappedBy="spouse")
    private Employee employe;

    public Spouse() {
    }

    public Spouse(String name, String mobileNo, int age) {
        this.name = name;
        this.mobileNo = mobileNo;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}
