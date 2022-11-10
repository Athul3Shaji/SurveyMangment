package com.survey.clientsurvey.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class QuestionForm {

    @NotBlank
    @Size(max=50)
    private String question;

    @NotBlank
    @Size(max=50)
    private String question_type;

    @NotNull
    private int surveyId;



    private String options [];

    public String[] getOptions() {
        return options;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }
//    @NotNull
//    private Collection<String> option;
//
//    public Collection<String> getOption() {
//        return option;
//    }

//    public void setOption(Collection<String> option) {
//        this.option = option;
//    }

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
}
