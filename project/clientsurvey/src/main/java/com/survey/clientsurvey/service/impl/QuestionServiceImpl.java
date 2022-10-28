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
import java.util.List;
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
    public List<Question> getQuestion(Integer survey_id){
        return questionRepository.findBySurvey(survey_id);

    }

        public void addQuestion(Question question) {
           questionRepository.save(question);
        }

        public  void questionDelete(Integer question_id){
             questionRepository.deleteById(question_id);

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

