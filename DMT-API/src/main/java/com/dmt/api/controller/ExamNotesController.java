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

        List<ExamNoteDto> list = new ArrayList<ExamNoteDto>();
        list.add(new ExamNoteDto("Helen Rosentu", "Introduction to Finance Mathematics", 60, -1, -1, 4));
        list.add(new ExamNoteDto("Freya Dumas", "Linear Programming Theory", 72, 80, -1, 4));
        list.add(new ExamNoteDto("Birsen Gulden Ozdemir", "Computer Science", 80, 88, -1, 6));

        return new ResponseEntity<List<ExamNoteDto>>(list, HttpStatus.OK);
    }
}
