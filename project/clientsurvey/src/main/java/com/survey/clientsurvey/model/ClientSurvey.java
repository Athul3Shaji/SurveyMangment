package com.survey.clientsurvey.model;

import com.survey.clientsurvey.form.SurveyForm;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="survey_info")
public class  ClientSurvey {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int surveyId;
    @Column
    String surveyName;
    @Column
    String survey_description;



    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Column

     String status="1";

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User user;

    public ClientSurvey() {
    }

    public ClientSurvey(int survey_id, Date date,String status) {
        this.surveyId = survey_id;

        this.date = date;
        this.status = status;
    }

    public ClientSurvey(SurveyForm form,Integer userId) {
        this.user= new User(userId);
        this.surveyName = form.getSurveyName();
        this.survey_description = form.getSurvey_description();

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(int surveyId) {
        this.surveyId = surveyId;
    }

    public String getSurveyName() {
        return surveyName;
    }

    public void setSurveyName(String surveyName) {
        this.surveyName = surveyName;
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
