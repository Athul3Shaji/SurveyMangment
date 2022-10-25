package com.survey.clientsurvey.service;

import com.survey.clientsurvey.exception.NotFoundException;
import com.survey.clientsurvey.form.QuestionForm;
import com.survey.clientsurvey.view.QuestionView;

public interface QuestionService  {

QuestionView update(Integer question_id, QuestionForm form) throws NotFoundException;
}
