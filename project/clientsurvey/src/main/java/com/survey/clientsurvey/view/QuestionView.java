package com.survey.clientsurvey.view;

import com.survey.clientsurvey.model.Question;

public class QuestionView {
    private final int question_id;
    private final String question;
    private final String question_type;
    private final int survey_id;

    public QuestionView(Question question) {
        this.question_id = getQuestion_id();
        this.question = question.getQuestion();
        this.question_type = question.getQuestion_type();
        this.survey_id = question.getSurvey_id();
    }

    public int getQuestion_id() {
        return question_id;
    }

    public String getQuestion() {
        return question;
    }

    public String getQuestion_type() {
        return question_type;
    }

    public int getSurvey_id() {
        return survey_id;
    }
}
