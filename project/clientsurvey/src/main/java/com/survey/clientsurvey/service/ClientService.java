package com.survey.clientsurvey.service;

import com.survey.clientsurvey.exception.NotFoundException;
import com.survey.clientsurvey.form.SurveyForm;
import com.survey.clientsurvey.view.ClientSurveyView;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClientService {

   List<ClientSurveyView> getAllSurveys();

 ClientSurveyView addClient(SurveyForm form);

 List<ClientSurveyView> getSurvey(Integer survey_id);

 List<ClientSurveyView>getSearchSurveys(String search);



    ClientSurveyView update(Integer survey_id, SurveyForm form) throws NotFoundException;

}
