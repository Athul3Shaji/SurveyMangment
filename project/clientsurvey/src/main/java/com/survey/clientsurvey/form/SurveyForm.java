package com.survey.clientsurvey.form;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
public class SurveyForm {


    @NotBlank
    @Size(max=255)
    private String survey_name;

    @NotBlank
    @Size(max = 255)
    private String survey_description;

    public String getSurvey_name() {
        return survey_name;
    }

    public void setSurvey_name(String survey_name) {
        this.survey_name = survey_name;
    }

    public String getSurvey_description() {
        return survey_description;
    }

    public void setSurvey_description(String survey_description) {
        this.survey_description = survey_description;
    }
}
