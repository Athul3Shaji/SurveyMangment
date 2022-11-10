package com.survey.clientsurvey.view;

import com.survey.clientsurvey.model.Question;

public class QuestionView {


    private final int questionId;
    private final String question;
    private final String question_type;
    private final int surveyId;

    private final String options[];



    public QuestionView(Question question) {
        this.questionId = question.getQuestionId();
        this.question = question.getQuestion();
        this.question_type = question.getQuestion_type();
        this.surveyId = question.getSurveyId();
        this.options=question.getOptions();
    }

    public int getQuestionId() {
        return questionId;
    }

    public String getQuestion() {
        return question;
    }

    public String getQuestion_type() {
        return question_type;
    }

    public int getSurveyId() {
        return surveyId;
    }
    public String[] getOptions() {
        return options;
    }
}
