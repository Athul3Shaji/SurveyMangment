package com.survey.clientsurvey.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="survey_info")
public class  ClientSurvey {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int survey_id;
    @Column
    String survey_name;
    @Column
    String survey_description;



    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Column

     String status="1";



    public ClientSurvey() {
    }

    public ClientSurvey(int survey_id, String survey_name, String survey_description,Date date,String status) {
        this.survey_id = survey_id;
        this.survey_name = survey_name;
        this.survey_description = survey_description;
        this.date = date;
        this.status = status;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    }
