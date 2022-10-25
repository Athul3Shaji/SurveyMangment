package com.survey.clientsurvey.view;

import java.util.Date;

public class ClientSurveyView {

    private final int survey_id;

    private final String survey_name;

    private final String survey_description;

    private final Date date;

    public ClientSurveyView(int survey_id, String survey_name, String survey_description, Date date) {
        this.survey_id = survey_id;
        this.survey_name = survey_name;
        this.survey_description = survey_description;
        this.date = date;
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
