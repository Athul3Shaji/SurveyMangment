package com.survey.clientsurvey.controller;


import com.survey.clientsurvey.model.Question;
import com.survey.clientsurvey.service.impl.QuestionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:4200")

public class QuestionController {

    @Autowired
    private QuestionServiceImpl questionService;

    @RequestMapping(value="/questions",method = RequestMethod.GET)
    public List<Question> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    @RequestMapping(value = "/questions/addquestion",method = RequestMethod.POST)
    public void addQuestion( @RequestBody Question question){
        questionService.addQuestion(question);
    }


    @RequestMapping(value= "/questions/surveyId/{survey_id}")
    public List<Question> getQuestion(@PathVariable Integer survey_id){
        return questionService.getQuestion(survey_id);

    }
    @RequestMapping(value="/questions/question_id/" +
            "{question_id}",method = RequestMethod.DELETE)
    public void deleteQuestion(@PathVariable Integer question_id){
     questionService.questionDelete(question_id);
    }
    @RequestMapping(value="editquestion/question_id/{question_id}",method = RequestMethod.GET)
    public List<Question> getQuestionById(@PathVariable Integer question_id){
        return questionService.getQuestionById(question_id);
    }

}
