package com.survey.clientsurvey.service;

import com.survey.clientsurvey.model.ClientSurvey;
import com.survey.clientsurvey.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public Optional<ClientSurvey> getClient(Integer survey_id){
        return  clientRepository.findById(survey_id);

    }
    public void updateClient(Integer survey_id , ClientSurvey  clientSurvey){
        clientRepository.save(clientSurvey);
    }
    public void deleteClient(Integer survey_id){
        clientRepository.deleteById(survey_id);
    }
}
