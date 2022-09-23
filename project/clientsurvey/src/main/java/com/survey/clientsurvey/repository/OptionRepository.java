package com.survey.clientsurvey.repository;

import com.survey.clientsurvey.model.Option;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OptionRepository  extends JpaRepository <Option, Integer> {
}
