package com.dmt.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

/**
 * @author mali.sahin
 * @since 16-May-18
 */
@RestController
@RequestMapping("/test")
public class NotificationController implements Serializable {

    @RequestMapping(value = "/run", method = RequestMethod.GET)
    public
    @ResponseBody
    String isRun() {
        return "APP_IS_RUNNING...";
    }
}
