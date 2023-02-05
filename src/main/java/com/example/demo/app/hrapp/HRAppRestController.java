package com.example.demo.app.hrapp;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HRAppRestController {
    
    @Autowired
    HRAppService service;

    // @GetMapping("/")
    // public String hello() {
    //     return "index";
    // }

    @GetMapping("/employee")
    public ArrayList<Employee> getEmployee() throws FileNotFoundException, ClassNotFoundException, IOException {
        return service.getEmployee();
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable int id) throws Exception {
        return service.getEmployeeById(id);
    }

    @PostMapping("/create/employee/")
    public void addEmployee(@RequestBody Employee emp) throws FileNotFoundException, IOException, ClassNotFoundException {
        service.addEmployee(emp);
    }

    @DeleteMapping("/delete/employee/{id}")
    public void deleteEmployee(@PathVariable int id) {
        service.deleteEmployee(id);
    }

    @PutMapping("/update/employee/name/{id}")
    public void updateName(@PathVariable int id,@RequestParam String name) throws Exception{
        service.updateName(id,name);
    }

    @PutMapping("/update/employee/salary/{id}")
    public void updateName(@PathVariable int id,@RequestParam int salary) throws Exception{
        service.updateSalary(id,salary);
    }
}
