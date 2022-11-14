package com.survey.clientsurvey.service.impl;

import com.survey.clientsurvey.exception.NotFoundException;
import com.survey.clientsurvey.form.SurveyForm;
import com.survey.clientsurvey.model.ClientSurvey;
import com.survey.clientsurvey.repository.ClientRepository;
import com.survey.clientsurvey.security.util.SecurityUtil;
import com.survey.clientsurvey.service.ClientService;
import com.survey.clientsurvey.view.ClientSurveyView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientSurveyServiceImpl implements ClientService {
    @Autowired
    public ClientRepository clientRepository;

    @Override
    public List<ClientSurveyView> getAllSurveys(){

        return clientRepository.findAllByUserUserIdAndStatus(SecurityUtil.getCurrentUserId(),ClientSurvey.Status.ACTIVE.value).stream().map((surya)->
                new ClientSurveyView(surya)).collect(Collectors.toList());

    }
    @Override
    public List<ClientSurveyView> getSearchSurveys(String search){

        return clientRepository.findByUserUserIdAndSurveyNameContainingAndStatus(SecurityUtil.getCurrentUserId(),search,ClientSurvey.Status.ACTIVE.value).stream().map((sury)->
                new ClientSurveyView(sury)).collect(Collectors.toList());

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
    public ClientSurveyView update(Integer survey_id , SurveyForm form){
     return clientRepository.findById(survey_id).map((survey) -> {
         return new ClientSurveyView(clientRepository.save(survey.update(form)));
     } ).orElseThrow(NotFoundException::new);
    }
    public void deleteClient(Integer survey_id){

     ClientSurvey clientSurvey =clientRepository.findBySurveyIdAndStatus(survey_id, ClientSurvey.Status.ACTIVE.value).orElseThrow(NotFoundException::new);
     clientSurvey.setStatus(ClientSurvey.Status.DELETED.value);
     clientSurvey.setDeleteDate(new Date());
     clientRepository.save(clientSurvey);
    return;
    }


    public Collection<ClientSurvey> listAll(){
     return clientRepository.findAllByUserUserIdAndStatus(SecurityUtil.getCurrentUserId(),ClientSurvey.Status.ACTIVE.value);
    }
}
