package com.example.demo.app.hrapp;

public class Department {
    private String name;
    private Employee[] employees;
    private int id;
    private final int MAX_SIZE=10;
    private int size;
    public Department(int id,String name) {
        setId(id);
        setName(name);
        size=0;
        employees=new Employee[MAX_SIZE];
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getSize() {
        return size;
    }
    public Employee[] getEmployees() {
        if(getSize()==0)
        {
            System.out.println("No employee present in "+getName()+" department.");
            return null;
        }
        Employee[] ans=new Employee[getSize()];
        for(int i=0;i<getSize();i++)
            ans[i]=employees[i];
        return ans;
    }
    public void addEmployee(Employee emp) {
        int curSize=getSize();
        if(curSize==MAX_SIZE)
        {
            System.out.println("Employee addition failed! Department is full.");
            return;
        }
        employees[curSize]=emp;
        size++;
    }
    public Employee search(int id) {
        int curSize=getSize();
        for(int i=0;i<curSize;i++)
        {
            if(employees[i].getId()==id)
            return employees[i];
        }
        System.out.println("Employee with id "+id+" is not present in "+getName()+" department.");
        return null;
    }
    public double getTotalSalary() {
        double total=0;
        int curSize=getSize();
        for(int i=0;i<curSize;i++)
        total+=employees[i].getSalary();
        return total;
    }
    public double getAverageSalary() {
        int curSize=getSize();
        if(curSize==0)
        return 0;
        double totalSalary=getTotalSalary();
        return totalSalary/curSize;
    }
    @Override
    public String toString() {
        return "DEPT: "+getId()+", "+getName()+", "+getSize();
    }
}
