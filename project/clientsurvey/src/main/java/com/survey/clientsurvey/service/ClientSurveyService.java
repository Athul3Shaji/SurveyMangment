package com.survey.clientsurvey.service;

import com.survey.clientsurvey.exception.ResourceNotFoundException;
import com.survey.clientsurvey.model.ClientSurvey;
import com.survey.clientsurvey.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientSurveyService {
    @Autowired
    public ClientRepository clientRepository;

    public List<ClientSurvey> getAllClients(){
        List<ClientSurvey> clients = new ArrayList<>();
        clientRepository.findAll()
                .forEach(clients::add);
        return clients;

    }

    public void addClient(ClientSurvey clientSurvey){
        clientRepository.save(clientSurvey);
    }
    public List<ClientSurvey> getClient(Integer survey_id){
        return  clientRepository.findByGet(survey_id);

    }
    public ResponseEntity<ClientSurvey> updateClient(Integer survey_id , ClientSurvey  clientSurvey){
       ClientSurvey survey = clientRepository.findById(survey_id).orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + survey_id));

        survey.setSurvey_name(clientSurvey.getSurvey_name());
        survey.setSurvey_description(clientSurvey.getSurvey_description());

        ClientSurvey update =  clientRepository.save(survey);
       return ResponseEntity.ok(update);
    }
    public void deleteClient(Integer survey_id){
        clientRepository.deleteById(survey_id);
    }
}
