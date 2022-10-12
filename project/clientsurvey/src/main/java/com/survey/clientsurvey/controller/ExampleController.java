package com.survey.clientsurvey.controller;

import com.survey.clientsurvey.model.Question;
import com.survey.clientsurvey.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExampleController {

//    @Autowired
//    private QuestionRepository quee;
//
//    @GetMapping("questions/{survey_id}")
//    public List<Question> getQue(@PathVariable Integer survey_id){
//        return  quee.findBySurvey(survey_id);
//    }
}
