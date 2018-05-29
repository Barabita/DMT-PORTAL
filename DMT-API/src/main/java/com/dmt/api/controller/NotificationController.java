package com.dmt.api.controller;

import com.dmt.core.service.Impl.StudentServiceImpl;
import com.dmt.core.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

/**
 * @author mali.sahin
 * @since 16-May-18
 */
@RestController
@RequestMapping("/api")
public class NotificationController implements Serializable {


    @Autowired
    private StudentService studentService(){
        return  new StudentServiceImpl();
    }

    @RequestMapping(value = "/login/{email}/{password}", method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseEntity login(@PathVariable("email") String email, @PathVariable String password) {

        HttpStatus status;

        if (studentService().login(email, password)) {
            status = HttpStatus.OK;
        } else {
            status = HttpStatus.FORBIDDEN;
        }

        return new ResponseEntity(status);
    }


}
