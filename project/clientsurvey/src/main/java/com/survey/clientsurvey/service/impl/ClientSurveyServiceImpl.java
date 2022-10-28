package com.survey.clientsurvey.service.impl;

import com.survey.clientsurvey.exception.NotFoundException;
import com.survey.clientsurvey.form.SurveyForm;
import com.survey.clientsurvey.model.ClientSurvey;
import com.survey.clientsurvey.repository.ClientRepository;
import com.survey.clientsurvey.security.util.SecurityUtil;
import com.survey.clientsurvey.service.ClientService;
import com.survey.clientsurvey.view.ClientSurveyView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientSurveyServiceImpl implements ClientService {
    @Autowired
    public ClientRepository clientRepository;

    @Override
    public List<ClientSurveyView> getAllSurveys(){

        return clientRepository.findAllByUserUserId(SecurityUtil.getCurrentUserId()).stream().map((surya)->
                new ClientSurveyView(surya)).collect(Collectors.toList());

    }

 @Override
    public ClientSurveyView addClient(SurveyForm form){
        return new ClientSurveyView(clientRepository.save(new ClientSurvey(form, SecurityUtil.getCurrentUserId())));
    }

    @Override
    @Transactional
    public List<ClientSurveyView> getSurvey(Integer survey_id)throws NotFoundException{
      return   clientRepository.findByUserUserIdAndSurveyId(SecurityUtil.getCurrentUserId(),survey_id).stream().map((survey)->
                new ClientSurveyView(survey)).collect(Collectors.toList());


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
