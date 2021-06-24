package com.example.herokudemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.example.herokudemo.models.Employee;
import com.example.herokudemo.repositories.EmployeeRepository;

@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@SpringBootTest
@AutoConfigureMockMvc
class EmployeeRepositoryTest {
	@Autowired
    EmployeeRepository employeeRepository;

    @Test
    public void testGetAppEmployees() throws Exception {
    	
    	List<Employee> list = employeeRepository.findAll();
    	
    	assertEquals(list.size(), 1);
    	assertTrue(list.get(0).getFirstName().equals("krishna"));
    }
}
