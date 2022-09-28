package com.survey.clientsurvey.repository;

import com.survey.clientsurvey.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository <Question, Integer> {
}
