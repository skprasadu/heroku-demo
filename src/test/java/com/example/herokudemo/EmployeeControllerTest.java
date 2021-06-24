package com.example.herokudemo;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.herokudemo.controllers.EmployeeController;
import com.example.herokudemo.models.Employee;
import com.example.herokudemo.services.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;

@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@SpringBootTest
@AutoConfigureMockMvc
class EmployeeControllerTest {
    ObjectMapper mapper;
       
    @MockBean
    EmployeeService employeeService;

    @InjectMocks
    EmployeeController controllerUnderTest;

	private MockMvc mockMvc;

    @BeforeEach
    public void contextLoads() {
        mapper = new ObjectMapper();
        
        MockitoAnnotations.openMocks(this);

        this.mockMvc = MockMvcBuilders.standaloneSetup(controllerUnderTest).build();
    }

    @Test
    public void testGetAppEmployees() throws Exception {
    	ArrayList<Employee> arr = new ArrayList<>();
    	arr.add(new Employee(1l, "krishna", "prasad"));
    	
    	when(employeeService.getAllEmployees()).thenReturn(arr);
    	
        mockMvc.perform(get("/getAllEmployees")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(jsonPath("$[0].firstName").value("krishna"))
                .andExpect(jsonPath("$[0].lastName").value("prasad"));
    }
}
