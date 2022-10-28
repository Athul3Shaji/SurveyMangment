package com.survey.clientsurvey.model;


import com.sun.istack.NotNull;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="option_survey")
public class Option {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int option_id;

    @Column
     String option_name;
    @NotNull
    @Column
     int question_id=12;


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

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public Date getOpt_cre_date() {
        return opt_cre_date;
    }

    public void setOpt_cre_date(Date opt_cre_date) {
        this.opt_cre_date = opt_cre_date;
    }

    public Option(int option_id, String option_name, int question_id, Date opt_cre_date) {
        this.option_id = option_id;
        this.option_name = option_name;
        this.question_id = question_id;
        this.opt_cre_date = opt_cre_date;
    }
}
