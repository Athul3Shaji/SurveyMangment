package com.survey.clientsurvey.view;

import com.survey.clientsurvey.model.ClientSurvey;

import java.util.Date;

public class ClientSurveyView {

    private final int surveyId;

    private final String surveyName;

    private final String survey_description;

    private final Date date;





    public ClientSurveyView(ClientSurvey clientSurvey) {
        this.surveyId = clientSurvey.getSurveyId();
        this.surveyName = clientSurvey.getSurveyName();
        this.survey_description = clientSurvey.getSurvey_description();
        this.date = clientSurvey.getDate();

    }

    public int getSurvey_id() {
        return surveyId;
    }

    public String getSurveyName() {
        return surveyName;
    }

    public String getSurvey_description() {
        return survey_description;
    }

    public Date getDate() {
        return date;
    }

}
