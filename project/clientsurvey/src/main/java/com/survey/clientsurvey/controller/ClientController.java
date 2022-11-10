package com.survey.clientsurvey.controller;

import com.survey.clientsurvey.form.SurveyForm;
import com.survey.clientsurvey.service.ClientService;
import com.survey.clientsurvey.service.impl.ClientSurveyServiceImpl;
import com.survey.clientsurvey.view.ClientSurveyView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

@RestController
public class ClientController {
    @Autowired
   private ClientSurveyServiceImpl clientSurveyService;
    @Autowired
    private ClientService clientService;

    @RequestMapping(value = "/surveys")
    public Collection<ClientSurveyView> getAllSurveys(){
        return clientSurveyService.getAllSurveys();
    }



    @RequestMapping(value= "/surveys/{survey_id}",method = RequestMethod.GET)
    public List<ClientSurveyView> getSurvey(@PathVariable Integer survey_id){
        return clientService.getSurvey(survey_id);

    }
    @RequestMapping(value = "/addsurvey",method = RequestMethod.POST)
    public ClientSurveyView addClient(@Valid @RequestBody SurveyForm form)
    {
      return   clientService.addClient(form);
    }

    @RequestMapping(value = "/surveys/editsurvey/{survey_id}", method = RequestMethod.PUT)
    public ClientSurveyView update(@PathVariable(name = "survey_id") Integer survey_id ,@RequestBody SurveyForm form) {
      return clientService.update(survey_id,form);
    }


    @RequestMapping(value = "/surveys/{survey_id}", method = RequestMethod.DELETE)
    public void deleteClient(@PathVariable Integer survey_id) {
        clientSurveyService.deleteClient(survey_id);

    }

    @RequestMapping(value= "/surveys/search/{search}",method = RequestMethod.GET)
    public List<ClientSurveyView> getSearchSurveys(@PathVariable String search){
        return clientService.getSearchSurveys(search);

    }
}
