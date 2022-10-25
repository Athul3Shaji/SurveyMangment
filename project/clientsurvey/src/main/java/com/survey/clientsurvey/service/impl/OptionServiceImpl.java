package com.survey.clientsurvey.service.impl;

import com.survey.clientsurvey.model.Option;
import com.survey.clientsurvey.repository.OptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OptionServiceImpl {

    @Autowired
   public OptionRepository optionRepository;
    public List<Option> getAllOptions(){
        List<Option> options = new ArrayList<>();
        optionRepository.findAll()
                .forEach(options::add);
        return options;

    }

    public void addOption(Option option){
        optionRepository.save(option);
    }

    public List<Option> getOption(Integer question_id){
        return  optionRepository.findByQuest(question_id);

    }
    public void updateOption(Integer option_id , Option  option){
        optionRepository.save(option);
    }
    public void deleteOption(Integer option_id){
        optionRepository.deleteById(option_id);
    }
}
