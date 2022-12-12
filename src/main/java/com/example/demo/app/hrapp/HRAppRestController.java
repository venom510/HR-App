package com.example.demo.app.hrapp;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.springframework.http.HttpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public ResponseEntity<ArrayList<Employee>> getEmployee() throws FileNotFoundException, ClassNotFoundException, IOException {
        HttpHeaders responseHeaders=new HttpHeaders();
        responseHeaders.set("Access-Control-Allow-Origin", "*"); // Had to add this header, otherwise I was getting "Uncaught (in promise) SyntaxError: Unexpected end of JSON input" error and the function was returning nothing.
        return ResponseEntity.ok()
        .headers(responseHeaders)
        .body(service.getEmployee());
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable int id) throws Exception {
        HttpHeaders responseHeaders=new HttpHeaders();
        responseHeaders.set("Access-Control-Allow-Origin", "*");
        return ResponseEntity.ok()
        .headers(responseHeaders)
        .body(service.getEmployeeById(id));
    }

    @PostMapping("/create/employee/")
    public void addEmployee(@RequestBody Employee emp) throws FileNotFoundException, IOException, ClassNotFoundException {
        service.addEmployee(emp);
    }
}
