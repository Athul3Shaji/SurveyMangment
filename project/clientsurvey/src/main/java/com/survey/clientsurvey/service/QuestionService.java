package com.survey.clientsurvey.service;

import com.survey.clientsurvey.model.Question;
import com.survey.clientsurvey.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service

public class QuestionService {


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


    }

