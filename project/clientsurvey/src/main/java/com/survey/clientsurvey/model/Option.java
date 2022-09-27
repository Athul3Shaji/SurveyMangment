package com.survey.clientsurvey.model;


import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="option_survey")
public class Option {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int option_id;
    @Column
    String question;
    @Column
     String option_name;


    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date opt_cre_date;

    public Option(){

    }

    public int getOption_id() {
        return option_id;
    }

    public void setOption_id(int option_id) {
        this.option_id = option_id;
    }

    public String getOption_name() {
        return option_name;
    }

    public void setOption_name(String option_name) {
        this.option_name = option_name;
    }


    public Option(int option_id, String question,String option_name, Date opt_cre_date) {
        this.option_id = option_id;
        this.option_name = option_name;
        this.question = question;
        this.opt_cre_date = opt_cre_date;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }


}
