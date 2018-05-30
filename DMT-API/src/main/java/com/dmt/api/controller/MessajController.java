package com.dmt.api.controller;

import com.dmt.core.domain.Summary;
import com.dmt.core.service.SummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.Serializable;
import java.util.List;

/**
 * @author mali.sahin
 * @since 30-May-18
 */

@Controller
@RequestMapping("/api")
public class MessajController implements Serializable {


    @Autowired
    private SummaryService summaryService;

    @RequestMapping(value = "/message/{email}")
    ResponseEntity<List<Summary>> getMessageList(@PathVariable String email) {
        return new ResponseEntity<List<Summary>>(summaryService.findByEmail(email), HttpStatus.OK);
    }
}
