package com.example.demo.app.hrapp;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
public class HRAppService {
    // public static void main(String[] args) {
    //     System.out.println("Welcome to HR App!");
    //     System.out.println("Yay! The application is starting.....");
    //     Department dev=new Department(123, "Developer");
    //     System.out.println(dev);
    //     Employee e1=new Employee(1, "Manav", 12033);
    //     Employee e2=new Employee(2, "abc", 103);
    //     Employee e3=new Employee(3, "sdhu", 133);
    //     Employee e4=new Employee(4, "adiue", 33);
    //     Employee e5=new Employee(5, "wqedu", 4433);
    //     Employee e6=new Employee(6, "sa", 1334);
    //     Employee e7=new Employee(7, "wqdui", 1000);
    //     Employee e8=new Employee(8, "qwein", 2323);
    //     Employee e9=new Employee(9, "wqiue", 4674);
    //     Employee e10=new Employee(10, "2eu", 32487);
    //     Employee e11=new Employee(11, "d   jdw", 13487);
    //     Employee e12=new Employee(12, "qdiwq", 13478);
    //     Employee e13=new Employee(13, " ndi ", 25);
    //     Employee e14=new Employee(14, "wdu", 3478);
    //     dev.addEmployee(e14);
    //     dev.addEmployee(e11);
    //     dev.addEmployee(e2);
    //     dev.addEmployee(e1);
    //     dev.addEmployee(e3);
    //     dev.addEmployee(e4);
    //     dev.addEmployee(e5);
    //     dev.addEmployee(e6);
    //     dev.addEmployee(e7);
    //     dev.addEmployee(e8);
    //     dev.addEmployee(e10);
    //     Employee tmp=dev.search(12);
    //     if(tmp!=null)
    //     System.out.println(tmp);
    //     Employee[] emps=dev.getEmployees();
    //     if(emps!=null)
    //     {
    //         for(Employee emp : emps)
    //         System.out.println(emp);
    //     }
    //     System.out.println("Total Salary: "+dev.getTotalSalary());
    //     System.out.println("Average Salary: "+dev.getAverageSalary());
    //     System.out.println(dev);
    //     Department test=new Department(34, "Testing");
    //     System.out.println(test);
    //     System.out.println(test.getTotalSalary());
    //     System.out.println(test.getAverageSalary());
    //     test.addEmployee(e9);
    //     test.addEmployee(e12);
    //     test.addEmployee(e13);
    // }

    public ArrayList<Employee> getEmployee() throws IOException,FileNotFoundException,ClassNotFoundException{
        return Repository.readEmployees();
    }

    public void addEmployee(Employee obj) throws FileNotFoundException, IOException, ClassNotFoundException {
        if(!Repository.employeeDataExists())
        Repository.createEmpDataFile();
        Repository.addEmployee(obj);
    }

    public Employee getEmployeeById(int id) throws Exception {
        ArrayList<Employee> employees;
        try {
            employees=getEmployee();
        } catch (Exception e) {
            throw e;
        }
        if(employees!=null)
        {
            for(Employee emp : employees)
            {
                if(emp.getId()==id)
                return emp;
            }
        }
        throw new Exception("Object with id "+id+" not found.");
    }
}
