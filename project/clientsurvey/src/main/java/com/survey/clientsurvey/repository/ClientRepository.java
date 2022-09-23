package com.survey.clientsurvey.repository;

import com.survey.clientsurvey.model.ClientSurvey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends JpaRepository <ClientSurvey, Integer> {
}

