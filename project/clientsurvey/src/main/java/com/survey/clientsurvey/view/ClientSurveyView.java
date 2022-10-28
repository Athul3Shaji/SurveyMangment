package com.survey.clientsurvey.view;

import com.survey.clientsurvey.model.ClientSurvey;

import java.util.Date;

public class ClientSurveyView {

    private final int surveyId;

    private final String survey_name;

    private final String survey_description;

    private final Date date;

    private final String status;



    public ClientSurveyView(ClientSurvey clientSurvey) {
        this.surveyId = clientSurvey.getSurveyId();
        this.survey_name = clientSurvey.getSurvey_name();
        this.survey_description = clientSurvey.getSurvey_description();
        this.date = clientSurvey.getDate();
        this.status=clientSurvey.getStatus();
    }

    public int getSurvey_id() {
        return surveyId;
    }

    public String getSurvey_name() {
        return survey_name;
    }

    public String getSurvey_description() {
        return survey_description;
    }

    public Date getDate() {
        return date;
    }
    public String getStatus() {
        return status;
    }
}
