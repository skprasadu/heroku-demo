package com.example.herokudemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;

import com.example.herokudemo.models.Employee;
import com.example.herokudemo.repositories.EmployeeRepository;
import com.example.herokudemo.services.EmployeeService;

@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@SpringBootTest
@AutoConfigureMockMvc
class EmployeeServiceTest {
    @MockBean
    EmployeeRepository employeeRepository;

    @Autowired
    EmployeeService employeeService;

    @Test
    public void testGetAppEmployees() throws Exception {
    	ArrayList<Employee> arr = new ArrayList<>();
    	arr.add(new Employee(1l, "krishna", "prasad"));
    	
    	when(employeeRepository.findAll()).thenReturn(arr);
    	
    	List<Employee> list = employeeService.getAllEmployees();
    	
    	assertEquals(list.size(), 1);
    	assertTrue(list.get(0).getFirstName().equals("krishna"));
    }
}
