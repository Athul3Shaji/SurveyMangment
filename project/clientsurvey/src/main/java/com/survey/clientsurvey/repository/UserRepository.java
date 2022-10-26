package com.survey.clientsurvey.repository;

import com.survey.clientsurvey.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
