package com.survey.clientsurvey.view;

import com.survey.clientsurvey.model.ClientSurvey;

import java.util.Date;

public class ClientSurveyView {

    private final int survey_id;

    private final String survey_name;

    private final String survey_description;

    private final Date date;


    public ClientSurveyView(ClientSurvey clientSurvey) {
        this.survey_id = clientSurvey.getSurvey_id();
        this.survey_name = clientSurvey.getSurvey_name();
        this.survey_description = clientSurvey.getSurvey_description();
        this.date = clientSurvey.getDate();
    }

    public int getSurvey_id() {
        return survey_id;
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
}
