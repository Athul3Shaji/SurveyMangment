package com.survey.clientsurvey.controller;

import com.survey.clientsurvey.model.Option;
import com.survey.clientsurvey.model.Question;
import com.survey.clientsurvey.model.QuestionRequest;
import com.survey.clientsurvey.service.OptionService;
import com.survey.clientsurvey.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins="http://localhost:40183")
public class OptionController {
    @Autowired
    public OptionService optionService;
    @Autowired
    public QuestionService questionService;

    @RequestMapping(value = "/options")
    public List<Option> getAllOptions(){
        return optionService.getAllOptions();
    }

    @RequestMapping(value= "/options/{option_id}")
    public Optional<Option> getOption(@PathVariable Integer option_id){
        return optionService.getOption(option_id);

    }
    @RequestMapping(value = "/options",method = RequestMethod.POST)
    public void addOption(@RequestBody QuestionRequest req){
        optionService.addOption(req.option);
        questionService.addQuestion(req.question);
    }

    @RequestMapping(value = "/options/{option_id}", method = RequestMethod.PUT)
    public void updateOption(@RequestBody Option option,@PathVariable Integer option_id ) {
        optionService.updateOption(option_id,option);
    }

    @RequestMapping(value = "/options/{option_id}", method = RequestMethod.DELETE)
    public void deleteOption(@PathVariable Integer option_id) {
        optionService.deleteOption(option_id);

    }
}
