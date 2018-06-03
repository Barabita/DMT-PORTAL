package com.dmt.api.controller;

import com.dmt.core.domain.dto.ExamNoteDto;
import com.dmt.core.service.StudentLectureAssignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping(value = "/getNotes/{id}")
    public ResponseEntity<List<ExamNoteDto>> getExamNotes(){



        return  null;
    }
}
