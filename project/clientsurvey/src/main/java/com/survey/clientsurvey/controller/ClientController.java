package com.survey.clientsurvey.controller;

import com.survey.clientsurvey.model.ClientSurvey;
import com.survey.clientsurvey.service.ClientSurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class ClientController {
    @Autowired
   private ClientSurveyService clientSurveyService;

    @RequestMapping(value = "/surveys")
    public List<ClientSurvey> getAllClients(){
        return clientSurveyService.getAllClients();
    }

    @RequestMapping(value= "/surveys/{survey_id}")
    public List<ClientSurvey> getClient(@PathVariable Integer survey_id){
        return clientSurveyService.getClient(survey_id);

    }
    @RequestMapping(value = "/addsurvey",method = RequestMethod.POST)
    public void addClient( @RequestBody ClientSurvey clientSurvey){
        clientSurveyService.addClient(clientSurvey);
    }

    @RequestMapping(value = "/surveys/{survey_id}", method = RequestMethod.PUT)
    public void updateStudent(@RequestBody ClientSurvey clientSurvey,@PathVariable Integer survey_id ) {
       clientSurveyService.updateClient(survey_id,clientSurvey);
    }

    @RequestMapping(value = "/surveys/{survey_id}", method = RequestMethod.DELETE)
    public void deleteClient(@PathVariable Integer survey_id) {
        clientSurveyService.deleteClient(survey_id);

    }
}
