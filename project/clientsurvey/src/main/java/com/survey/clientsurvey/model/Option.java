package com.survey.clientsurvey.model;


import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="option_survey")
public class Option {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int option_id;
    @Column
    private String option_name;
    @Column
    @JsonFormat(timezone = "GMT+03:00")
    private Date CreateDateTime;

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

    public Date getCreateDateTime() {
        return CreateDateTime;
    }

    public void setCreateDateTime(Date createDateTime) {
        CreateDateTime = createDateTime;
    }

    public Option(int option_id, String option_name, Date createDateTime) {
        this.option_id = option_id;
        this.option_name = option_name;
        CreateDateTime = createDateTime;
    }
}
