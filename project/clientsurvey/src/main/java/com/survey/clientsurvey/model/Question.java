package com.survey.clientsurvey.model;

import com.survey.clientsurvey.form.QuestionForm;

import javax.persistence.*;

@Entity
@Table(name = "question_survey")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int question_id;
    @Column
    String question;
    @Column
    String question_type;

   @Column
   int survey_id;

    public  Question(){

    }
    public Question(int question_id, String question, String question_type, int survey_id) {
        this.question_id = question_id;
        this.question = question;
        this.question_type = question_type;
        this.survey_id = survey_id;
    }



    public Question update(QuestionForm form){
        this.question=form.getQuestion();
        this.question_type=form.getQuestion_type();
        this.survey_id = form.getSurvey_id();
        return  this;
    }

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
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

    public int getSurvey_id() {
        return survey_id;
    }

    public void setSurvey_id(int survey_id) {
        this.survey_id = survey_id;
    }
}
