package org.example.springsecurewebservicev2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @GetMapping
    public String employeeEndpoint() {
        return "Hello employee";
    }

}
