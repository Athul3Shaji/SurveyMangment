package com.survey.clientsurvey.service;

import com.survey.clientsurvey.form.SurveyForm;
import com.survey.clientsurvey.model.ClientSurvey;
import com.survey.clientsurvey.view.ClientSurveyView;

import java.util.Collection;

public interface ClientService {

 Collection<ClientSurvey> getAllClients();

 ClientSurveyView addClient(SurveyForm form);
}
