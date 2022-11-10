package com.survey.clientsurvey.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.survey.clientsurvey.form.QuestionForm;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "question")
public class Question {

    public static enum Status {
        DELETED((byte) 0),
        ACTIVE((byte) 1);

        public final byte value;

        private Status(byte value) {
            this.value = value;
        }
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int questionId;
    @Column
    String question;
    @Column
    String question_type;

    private byte status;



    @Column
   int surveyId;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;




    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;



    private Date deleteDate;

    @JsonIgnore
   String options [];



    public String[] getOptions() {
        return options;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }


  public Question(){}



    public Question(int questionId) {
        this.questionId = questionId;


    }

    public Question(QuestionForm form){
        this.question= form.getQuestion();
        this.question_type= form.getQuestion_type();
        this.surveyId = form.getSurveyId();
//        this.option=form.getOption();
        this.options= form.getOptions();
        this.status=Status.ACTIVE.value;
        Date dt = new Date();
        this.createDate = dt;
        this.updateDate = dt;
    }



    public Question update(QuestionForm form){
        this.question=form.getQuestion();
        this.question_type=form.getQuestion_type();
        this.surveyId = form.getSurveyId();
        Date dt = new Date();
        this.updateDate = dt;
        return  this;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getQuestion_type() {
        return question_type;
    }

    public void setQuestion_type(String question_type) {
        this.question_type = question_type;
    }

    public int getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(int surveyId) {
        this.surveyId = surveyId;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Date getDeleteDate() {
        return deleteDate;
    }

    public void setDeleteDate(Date deleteDate) {
        this.deleteDate = deleteDate;
    }
//    public Collection<String> getOption() {
//        return option;
//    }
//
//    public void setOption(Collection<String> option) {
//        this.option = option;
//    }
}
