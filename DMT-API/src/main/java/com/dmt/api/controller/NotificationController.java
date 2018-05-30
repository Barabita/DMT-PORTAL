package com.dmt.api.controller;

import com.dmt.core.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.Serializable;

/**
 * @author mali.sahin
 * @since 16-May-18
 */

@Controller
@RequestMapping("/api")
public class NotificationController implements Serializable {


    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/login/{email}/{password}", method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseEntity login(@PathVariable("email") String email, @PathVariable String password) {

        HttpStatus status;

        if (studentService.login(email, password)) {
            status = HttpStatus.OK;
        } else {
            status = HttpStatus.FORBIDDEN;
        }

        return new ResponseEntity(status);

    }


}
