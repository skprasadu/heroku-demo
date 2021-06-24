package com.example.herokudemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.herokudemo.models.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
