package com.example.demo.app.hrapp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Employee{
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private double salary;
    public Employee() {}
    public Employee(String name, double salary) {
        setName(name);
        setSalary(salary);
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    @Override
    public String toString() {
        return "EMP: "+getId()+", "+getName()+", "+getSalary();
    }
}