package com.survey.clientsurvey.controller;

import com.survey.clientsurvey.model.ClientSurvey;
import com.survey.clientsurvey.service.ClientSurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins="http://localhost:33705")
public class ClientController {
    @Autowired
   private ClientSurveyService clientSurveyService;

    @RequestMapping(value = "/clients")
    public List<ClientSurvey> getAllClients(){
        return clientSurveyService.getAllClients();
    }

    @RequestMapping(value= "/clients/{survey_id}")
    public Optional<ClientSurvey> getClient(@PathVariable Integer survey_id){
        return clientSurveyService.getClient(survey_id);

    }
    @RequestMapping(value = "/clients",method = RequestMethod.POST)
    public void addClient( @RequestBody ClientSurvey clientSurvey){
        clientSurveyService.addClient(clientSurvey);
    }

    @RequestMapping(value = "/clients/{survey_id}", method = RequestMethod.PUT)
    public void updateStudent(@RequestBody ClientSurvey clientSurvey,@PathVariable Integer survey_id ) {
       clientSurveyService.updateClient(survey_id,clientSurvey);
    }

    @RequestMapping(value = "/clients/{survey_id}", method = RequestMethod.DELETE)
    public void deleteClient(@PathVariable Integer survey_id) {
        clientSurveyService.deleteClient(survey_id);

    }
}
