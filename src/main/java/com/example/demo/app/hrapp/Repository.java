package com.example.demo.app.hrapp;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Repository {
    private static final String EMPLOYEE_DATA="src/main/resources/repository/employees";
    private static final String DEPARTMENT_DATA="src/main/resources/repository/departments";
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // for(Employee obj : readEmployees())
        //     System.out.println(obj);
        // addEmployee(new Employee(123,"Manav",2324));
        // addEmployee(new Employee(35, "abc", 24));
        // createEmpDataFile();
        // System.out.println(employeeDataExists());
        // System.out.println(dataExists());
        // File f=new File(FILENAME);
        // System.out.println(f.canWrite());
        // System.out.println(f.length());
        // System.out.println(FILENAME);
        // System.out.println(System.getProperty("user.dir"));
        // try {
        //     if(f.createNewFile())
        //     System.out.println("Created Successfully!");
        //     else
        //     System.out.println("Not Created!!");
        // } catch (IOException e) {
        //     System.out.println("Some unexpected IO Exception occured!");
        //     e.printStackTrace();
        // }

        // Employee e1=new Employee(1234,"Manav", 1234);
        // Employee e2=new Employee(5678,"ABC", 5678);

        // try {
        //     // FileOutputStream fs=new FileOutputStream(new File(FILENAME));
        //     // ObjectOutputStream o=new ObjectOutputStream(fs);
        //     // o.writeObject(e1);
        //     // o.writeObject(e2);
        //     // o.close();
        //     // fs.close();
        //     FileInputStream fsi=new FileInputStream(new File(EMPLOYEE_DATA));
        //     ObjectInputStream oi=new ObjectInputStream(fsi);
        //     while(fsi.available()!=0)
        //     {
        //         Employee e=(Employee)oi.readObject();
        //         System.out.println(e);
        //     }
        //     oi.close();
        //     fsi.close();
        // } catch (FileNotFoundException e) {
        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
        // } catch (IOException e) {
        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
        // } catch (ClassNotFoundException e) {
        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
        // }
    }

    public static boolean employeeDataExists() {
        return new File(EMPLOYEE_DATA).exists();
    }

    public static boolean deptDataExists() {
        return new File(DEPARTMENT_DATA).exists();
    }

    public static void createEmpDataFile() throws IOException {
        File file = new File(EMPLOYEE_DATA);
        if(file.createNewFile())
        System.out.println(EMPLOYEE_DATA+" created successfully!");
        else
        System.out.println(EMPLOYEE_DATA+" already exists!");
    }

    public static void createDeptDataFile() throws IOException {
        File file = new File(DEPARTMENT_DATA);
        if(file.createNewFile())
        System.out.println(DEPARTMENT_DATA+" created successfully!");
        else
        System.out.println(DEPARTMENT_DATA+" already exists!");
    }

    public static void addEmployee(Employee obj) throws FileNotFoundException,IOException, ClassNotFoundException {
        ArrayList<Employee> employees=null;
        try{
            employees=readEmployees();
        } catch (Exception e) {
            System.out.println("Exception occured");
        }
        if(employees==null)
        employees=new ArrayList<Employee>();
        employees.add(obj);
        FileOutputStream fos = new FileOutputStream(new File(EMPLOYEE_DATA));
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(employees);
        oos.close();
        fos.close();
    }

    public static ArrayList<Employee> readEmployees() throws FileNotFoundException,IOException,ClassNotFoundException,EOFException {
        FileInputStream fis = new FileInputStream(new File(EMPLOYEE_DATA));
        ObjectInputStream ois = new ObjectInputStream(fis);
        ArrayList<Employee> employees = (ArrayList<Employee>) ois.readObject();
        return employees;
    }

}
