package com.survey.clientsurvey.controller;


import com.survey.clientsurvey.form.QuestionForm;
import com.survey.clientsurvey.model.Question;
import com.survey.clientsurvey.service.impl.QuestionServiceImpl;
import com.survey.clientsurvey.service.QuestionService;

import com.survey.clientsurvey.view.QuestionView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController

public class QuestionController {

    @Autowired
    private QuestionServiceImpl questionService;
@Autowired
   private QuestionService quest;

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

    @RequestMapping(value="update_question/question_id/{question_id}",method = RequestMethod.PATCH)
    public QuestionView updateQuestion(@PathVariable Integer question_id, @Valid @RequestBody  QuestionForm form){
        return quest.update(question_id,form);
    }

}
