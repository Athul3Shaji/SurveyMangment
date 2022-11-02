package com.survey.clientsurvey.view;

import com.survey.clientsurvey.model.Option;

public class OptionView {

    private final int option_id;

    private final String option_name;
     private final int question_id;

    public int getOption_id() {
        return option_id;
    }

    public String getOption_name() {
        return option_name;
    }

    public int getQuestion_id() {
        return question_id;
    }

    public OptionView(Option option) {
        this.option_id = getOption_id();
        this.option_name = getOption_name();
        this.question_id=getQuestion_id();
    }


}
