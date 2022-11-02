package com.survey.clientsurvey.repository;

import com.survey.clientsurvey.model.Option;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OptionRepository  extends JpaRepository <Option, Integer> {

    @Query("FROM Option WHERE question_id =:question_id")
    List<Option> findByQuest(int question_id);

    Option save(Option option);
}
