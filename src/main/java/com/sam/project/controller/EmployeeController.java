package com.sam.project.controller;

import java.util.List;

import javax.validation.Valid;

import com.sam.project.pojo.EmployeePojo;
import com.sam.project.pojo.EmployeeResponsePojo;
import com.sam.project.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/v1")
@RestController
public class EmployeeController {
    private final EmpService userService;

    @Autowired
    public EmployeeController(EmpService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String createUser(@RequestBody @Valid EmployeePojo user) {
        return userService.createUser(user);
    }

    @RequestMapping(value="/employees" ,method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public
    @ResponseBody
    List<EmployeeResponsePojo> listUsers() {
        return userService.listUsers();
    }
}
