package com.survey.clientsurvey.form;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
public class SurveyForm {


    @NotBlank
    @Size(max=255)
    private String surveyName;

    @NotBlank
    @Size(max = 255)
    private String survey_description;

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
}
