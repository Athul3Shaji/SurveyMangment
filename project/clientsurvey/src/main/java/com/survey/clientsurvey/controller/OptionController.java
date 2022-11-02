package com.survey.clientsurvey.controller;

import com.survey.clientsurvey.form.OptionForm;
import com.survey.clientsurvey.model.Option;
import com.survey.clientsurvey.service.OptionService;
import com.survey.clientsurvey.service.impl.OptionServiceImpl;
import com.survey.clientsurvey.view.OptionView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
public class OptionController {
    @Autowired
    public OptionServiceImpl optionService;

    @Autowired
    public OptionService optservice;


    @RequestMapping(value = "/options")
    public List<Option> getAllOptions(){
        return optionService.getAllOptions();
    }




    @RequestMapping(value= "/options/questionId/{question_id}")
    public List<Option> getOption(@PathVariable Integer question_id){
        return optionService.getOption(question_id);


    }

    @RequestMapping(value = "/addOption",method = RequestMethod.POST)
    public OptionView addOption(@Valid @RequestBody OptionForm form){
//        questionService.addQuestion(form);

          return  optservice.addOption(form);
    }

    @RequestMapping(value = "/options/{option_id}", method = RequestMethod.PUT)
    public void updateOption(@RequestBody Option option,@PathVariable Integer option_id ) {
        optionService.updateOption(option_id,option);
    }

    @RequestMapping(value = "/options/{option_id}", method = RequestMethod.DELETE)
    public void deleteOption(@PathVariable Integer option_id) {
        optionService.deleteOption(option_id);

    }



//    @RequestMapping(value= "/questions/{survey_id}")
//    public ResponseEntity<List<Question>> getQuestion(@RequestParam Integer survey_id){
//        return new ResponseEntity<List<Question>>(que.findBySurveyId(survey_id), HttpStatus.OK);
//
//    }

}
