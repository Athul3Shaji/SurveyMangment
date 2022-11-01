package com.survey.clientsurvey.view;

import com.survey.clientsurvey.model.Question;

public class QuestionView {
    private final int question_id;
    private final String question;
    private final String question_type;
    private final int survey_id;

    private final String options[];



    public QuestionView(Question question) {
        this.question_id = getQuestionId();
        this.question = question.getQuestion();
        this.question_type = question.getQuestion_type();
        this.survey_id = question.getSurvey_id();
        this.options=question.getOptions();
    }

    public int getQuestionId() {
        return question_id;
    }

    public String getQuestion() {
        return question;
    }

    public String getQuestion_type() {
        return question_type;
    }

    public int getSurveyId() {
        return survey_id;
    }
    public String[] getOptions() {
        return options;
    }
}
