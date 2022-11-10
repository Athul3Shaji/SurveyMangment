package com.survey.clientsurvey.model;

import com.survey.clientsurvey.form.SurveyForm;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="survey_info")
public class  ClientSurvey {



    public static enum Status {
        DELETED((byte) 0),
        ACTIVE((byte) 1);

        public final byte value;

        private Status(byte value) {
            this.value = value;
        }
    }

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int surveyId;
    @Column
    String surveyName;
    @Column
    String survey_description;

    private byte status;



    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;


    private Date deleteDate;



    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User user;

    public ClientSurvey() {
    }

    public ClientSurvey(int survey_id,String status) {
        this.surveyId = survey_id;


    }

    public ClientSurvey(SurveyForm form,Integer userId) {
        this.user= new User(userId);
        this.surveyName = form.getSurveyName();
        this.survey_description = form.getSurvey_description();
        this.status=Status.ACTIVE.value;
        Date dt = new Date();
        this.date = dt;
        this.updateDate = dt;

    }

    public ClientSurvey update(SurveyForm form)
    {
        this.surveyName = form.getSurveyName();
        this.survey_description = form.getSurvey_description();
        this.status=Status.ACTIVE.value;

        Date dt = new Date();
        this.updateDate = dt;
        return this;
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


    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    public Date getDeleteDate() {
        return deleteDate;
    }

    public void setDeleteDate(Date deleteDate) {
        this.deleteDate = deleteDate;
    }
}
