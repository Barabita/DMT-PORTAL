package com.dmt.api.controller;

import com.dmt.core.domain.Summary;
import com.dmt.core.service.SummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.Serializable;
import java.util.List;

/**
 * @author mali.sahin
 * @since 30-May-18
 */

@CrossOrigin(origins = "http://localhost:8080")
@Controller
@RequestMapping("/api")
public class MessajController implements Serializable {


    @Autowired
    private SummaryService summaryService;

    @RequestMapping(value = "/message/{email}", method = RequestMethod.GET)
    ResponseEntity<List<Summary>> getMessageList(@PathVariable String email) {
        return new ResponseEntity<List<Summary>>(summaryService.findByEmail(email), HttpStatus.OK);
    }
}
