package com.dmt.api.controller;

import com.dmt.core.domain.Student;
import com.dmt.core.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author mali.sahin
 * @since 30-May-18
 */

@Controller
@RequestMapping(value = "/api")
public class LoginController {


    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/login/{email}/{password}", method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseEntity login(@PathVariable("email") String email, @PathVariable String password) {


        List<Student> studentList = studentService.login(email, password);


        return new ResponseEntity(studentList, HttpStatus.OK);

    }

}
