package com.survey.clientsurvey.repository;

import com.survey.clientsurvey.model.ClientSurvey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository <ClientSurvey, Integer> {
    @Query("FROM ClientSurvey WHERE survey_id= :survey_id")
    List<ClientSurvey> findByGet(int survey_id);
}

