package com.dmt.api.controller;

import com.dmt.core.domain.dto.ExamNoteDto;
import com.dmt.core.service.StudentLectureAssignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mali.sahin
 * @since 03-Jun-18
 */
@RestController
@RequestMapping(value = "/api")
public class ExamNotesController {

    @Autowired
    private StudentLectureAssignService studentLectureAssignService;

    @GetMapping(value = "/getNotes/{id}")
    @ResponseBody
    public ResponseEntity<List<ExamNoteDto>> getExamNotes(@PathVariable String id) {

        return new ResponseEntity<List<ExamNoteDto>>(studentLectureAssignService.getExamNoteList(id), HttpStatus.OK);
    }
}