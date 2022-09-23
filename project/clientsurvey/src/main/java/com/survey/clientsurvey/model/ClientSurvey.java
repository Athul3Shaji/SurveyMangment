package com.survey.clientsurvey.model;

import javax.persistence.*;

@Entity
@Table(name="survey_info")
public class  ClientSurvey {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int survey_id;
    @Column
    String survey_name;
    @Column
    String survey_description;

    public ClientSurvey() {
    }

    public ClientSurvey(int survey_id, String survey_name, String survey_description) {
        this.survey_id = survey_id;
        this.survey_name = survey_name;
        this.survey_description = survey_description;
    }

    public int getSurvey_id() {
        return survey_id;
    }

    public void setSurvey_id(int survey_id) {
        this.survey_id = survey_id;
    }

    public String getSurvey_name() {
        return survey_name;
    }

    public void setSurvey_name(String survey_name) {
        this.survey_name = survey_name;
    }

    public String getSurvey_description() {
        return survey_description;
    }

    public void setSurvey_description(String survey_description) {
        this.survey_description = survey_description;
    }

    @OneToOne
    @JoinColumn(name = "option_id")
    private Option option ;
}
