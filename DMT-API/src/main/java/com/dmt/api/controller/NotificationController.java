package com.dmt.api.controller;

import com.dmt.core.domain.Notification;
import com.dmt.core.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.Serializable;
import java.util.List;

/**
 * @author mali.sahin
 * @since 16-May-18
 */

@Controller
@RequestMapping("/api")
public class NotificationController implements Serializable {


    @Autowired
    private NotificationService notificationService;

    @RequestMapping(value = "/notification/{email}", method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseEntity<List<Notification>> login(@PathVariable("email") String email) {

        return new ResponseEntity<List<Notification>>(notificationService.getNotificationListByReceiver(email), HttpStatus.OK);

    }


}
