package com.survey.clientsurvey.service.impl;

import com.survey.clientsurvey.exception.NotFoundException;
import com.survey.clientsurvey.form.QuestionForm;
import com.survey.clientsurvey.model.Question;
import com.survey.clientsurvey.repository.QuestionRepository;
import com.survey.clientsurvey.service.QuestionService;
import com.survey.clientsurvey.view.QuestionView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service

public class QuestionServiceImpl implements QuestionService {


        @Autowired
        public QuestionRepository questionRepository;

        public List<Question> getAllQuestions() {
            List<Question> questions = new ArrayList<>();
            questionRepository.findAll()
                    .forEach(questions::add);
            return questions;

        }
    public List<QuestionView> getQuestion(Integer survey_id){
        return questionRepository.findAllBySurveyIdAndStatus(survey_id,Question.Status.ACTIVE.value).stream().map((quest)->
                new QuestionView(quest)).collect(Collectors.toList());

    }
    @Override
    public QuestionView addQuestion(QuestionForm form) {
            return  new QuestionView(questionRepository.save(new Question(form)))   ;

        }

        public  void questionDelete(Integer question_id){
          Question question = questionRepository.findByQuestionIdAndStatus(question_id,Question.Status.ACTIVE.value).orElseThrow(NotFoundException::new);
          question.setStatus(Question.Status.DELETED.value);
          question.setDeleteDate(new Date());
          questionRepository.save(question);
            return;
        }

        public List<Question> getQuestionById(Integer question_id){
            return questionRepository.findByQuestion(question_id);
        }


    @Override
    @Transactional
    public QuestionView update(Integer question_id, QuestionForm form)  {
        return questionRepository.findById(question_id).map((question) -> {
            return new QuestionView(questionRepository.save(question.update(form)));
        }).orElseThrow(NotFoundException::new);
    }
}

