package com.survey.clientsurvey.repository;

import com.survey.clientsurvey.model.ClientSurvey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface ClientRepository extends JpaRepository <ClientSurvey, Integer> {



    @Query("FROM ClientSurvey WHERE survey_id= :survey_id")
    List<ClientSurvey> findByGet(int survey_id);

//    List<ClientSurvey>findAllByUserUserIdAndStatus(Integer user_id,byte status);
  Collection<ClientSurvey> findAllByUserUserIdAndStatus(Integer userId,byte status);
    ClientSurvey save(ClientSurvey clientSurvey);

    Collection<ClientSurvey>findByUserUserIdAndSurveyId(Integer userId,Integer survey_id);

    List<ClientSurvey>findByUserUserIdAndSurveyNameContainingAndStatus(Integer userId,String search,byte status);


    Optional<ClientSurvey>findBySurveyIdAndStatus(Integer survey_id,byte status);
    


}

