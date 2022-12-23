package com.example.demo.app.hrapp;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HRAppService {

    @Autowired
    EmployeeRepository empRepository;

    public ArrayList<Employee> getEmployee(){
        return (ArrayList<Employee>)empRepository.findAll();
    }

    public void addEmployee(Employee obj){
        empRepository.save(obj);
    }

    public Employee getEmployeeById(int id) throws Exception {
        Optional<Employee> result=empRepository.findById(id);
        if(result.isPresent())
        return result.get();
        throw new Exception("Object with id "+id+" is not present in the repository!");
    }

    public void deleteEmployee(int id) {
        empRepository.deleteById(id);
    }

    public void updateName(int id,String newName) throws Exception {
        Optional<Employee> result=empRepository.findById(id);
        if(result.isPresent()) {
            Employee obj=result.get();
            obj.setName(newName);
            empRepository.save(obj);
        }
        else
        throw new Exception("Object with id "+id+" is not present in the repository!");
    }

    public void updateSalary(int id,int newSalary) throws Exception {
        Optional<Employee> result=empRepository.findById(id);
        if(result.isPresent()) {
            Employee obj=result.get();
            obj.setSalary(newSalary);
            empRepository.save(obj);
        }
        else
        throw new Exception("Object with id "+id+" is not present in the repository!");
    }
}
