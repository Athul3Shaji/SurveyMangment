package com.survey.clientsurvey.repository;

import com.survey.clientsurvey.model.ClientSurvey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;

public interface ClientRepository extends JpaRepository <ClientSurvey, Integer> {



    @Query("FROM ClientSurvey WHERE survey_id= :survey_id")
    List<ClientSurvey> findByGet(int survey_id);
  Collection<ClientSurvey> findAllByUserUserId(Integer userId);
    ClientSurvey save(ClientSurvey clientSurvey);
//    Optional<ClientSurvey> findByContactIdAndUserUserId(Integer survey_id, Integer userId);

//    Collection<ClientSurvey> findAll();
//     Collection<ClientSurveyView> findAllByUserUserId(Integer userId);

    Collection<ClientSurvey>findByUserUserIdAndSurveyId(Integer userId,Integer survey_id);


}

