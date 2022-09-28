package com.survey.clientsurvey.model;

import javax.persistence.*;

@Entity
@Table(name = "question_survey")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
     private int question_id;
    @Column
    String question;
    @Column
    String question_type;

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

    public Question(int question_id, String question, String question_type) {
        this.question_id = question_id;
        this.question = question;
        this.question_type = question_type;
    }
}
