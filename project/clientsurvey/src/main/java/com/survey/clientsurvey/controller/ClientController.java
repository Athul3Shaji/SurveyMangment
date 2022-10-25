package com.survey.clientsurvey.controller;

import com.survey.clientsurvey.form.SurveyForm;
import com.survey.clientsurvey.model.ClientSurvey;
import com.survey.clientsurvey.service.ClientService;
import com.survey.clientsurvey.service.impl.ClientSurveyServiceImpl;
import com.survey.clientsurvey.view.ClientSurveyView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class ClientController {
    @Autowired
   private ClientSurveyServiceImpl clientSurveyService;
    @Autowired
    private ClientService clientService;

    @RequestMapping(value = "/surveys")
    public Collection<ClientSurvey> getAllClients(){
        return clientService.getAllClients();
    }

    @RequestMapping(value= "/surveys/{survey_id}",method = RequestMethod.GET)
    public List<ClientSurvey> getClient(@PathVariable Integer survey_id){
        return clientSurveyService.getClient(survey_id);

    }
    @RequestMapping(value = "/addsurvey",method = RequestMethod.POST)
    public ClientSurveyView addClient(@Valid @RequestBody SurveyForm form)
    {
      return   clientService.addClient(form);
    }

    @RequestMapping(value = "/surveys/editsurvey/{survey_id}", method = RequestMethod.PATCH)
    public void updateStudent(@PathVariable(name = "survey_id") Integer survey_id ,@RequestBody ClientSurvey clientSurvey) {
       clientSurveyService.updateClient(survey_id,clientSurvey);
    }

    @RequestMapping(value = "/surveys/{survey_id}", method = RequestMethod.DELETE)
    public void deleteClient(@PathVariable Integer survey_id) {
        clientSurveyService.deleteClient(survey_id);

    }
}
