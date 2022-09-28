package com.survey.clientsurvey.service;

import com.survey.clientsurvey.model.Option;
import com.survey.clientsurvey.model.Question;
import com.survey.clientsurvey.repository.OptionRepository;
import com.survey.clientsurvey.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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

        public void addQuestion(Question question) {
            questionRepository.save(question);
        }


    }

