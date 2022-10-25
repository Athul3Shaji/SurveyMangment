package com.survey.clientsurvey.repository;

import com.survey.clientsurvey.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionRepository extends JpaRepository <Question, Integer> {


//   @Query(value="SELECT q.question from question_survey q where q.survey_id=230")
//   List<Question> findBySurvey(String question);

//    Question findQuestion(int  survey_id);
   @Query("FROM Question WHERE survey_id =:survey_id")
   List<Question> findBySurvey(int survey_id);

   @Query("From Question WHERE question_id= :question_id")
   List<Question> findByQuestion(int question_id);




}
