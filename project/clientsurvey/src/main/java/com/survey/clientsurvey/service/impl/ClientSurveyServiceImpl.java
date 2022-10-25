package com.survey.clientsurvey.service.impl;

import com.survey.clientsurvey.model.ClientSurvey;
import com.survey.clientsurvey.repository.ClientRepository;
import com.survey.clientsurvey.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class ClientSurveyServiceImpl implements ClientService {
    @Autowired
    public ClientRepository clientRepository;

    public Collection<ClientSurvey> getAllClients(){

        return clientRepository.findAll();

    }

    public void addClient(ClientSurvey clientSurvey){
        clientRepository.save(clientSurvey);
    }
    public List<ClientSurvey> getClient(Integer survey_id){
        return  clientRepository.findByGet(survey_id);

    }
    public ResponseEntity<ClientSurvey> updateClient(Integer survey_id , ClientSurvey  clientSurvey){
       ClientSurvey survey = clientRepository.findById(survey_id).get();

        survey.setSurvey_name(clientSurvey.getSurvey_name());
        survey.setSurvey_description(clientSurvey.getSurvey_description());

        ClientSurvey update =  clientRepository.save(survey);
       return ResponseEntity.ok(update);
    }
    public void deleteClient(Integer survey_id){
        clientRepository.deleteById(survey_id);
    }
}
