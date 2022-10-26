package com.survey.clientsurvey.service;

import com.survey.clientsurvey.form.SurveyForm;
import com.survey.clientsurvey.model.ClientSurvey;
import com.survey.clientsurvey.view.ClientSurveyView;
import org.springframework.http.ResponseEntity;

import java.util.Collection;

public interface ClientService {

 Collection<ClientSurvey> getAllClients();

 ClientSurveyView addClient(SurveyForm form);

    ResponseEntity<ClientSurvey> updateClient(Integer survey_id, ClientSurvey clientSurvey);
}
