package com.survey.clientsurvey.service.impl;

import com.survey.clientsurvey.form.SurveyForm;
import com.survey.clientsurvey.model.ClientSurvey;
import com.survey.clientsurvey.repository.ClientRepository;
import com.survey.clientsurvey.service.ClientService;
import com.survey.clientsurvey.view.ClientSurveyView;
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
 @Override
    public ClientSurveyView addClient(SurveyForm form){
        return new ClientSurveyView(clientRepository.save(new ClientSurvey(form)));
    }
    public List<ClientSurvey> getClient(Integer survey_id){
        return  clientRepository.findByGet(survey_id);

    }
    @Override
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
