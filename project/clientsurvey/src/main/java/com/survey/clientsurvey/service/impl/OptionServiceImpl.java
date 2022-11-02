package com.survey.clientsurvey.service.impl;

import com.survey.clientsurvey.form.OptionForm;
import com.survey.clientsurvey.model.Option;
import com.survey.clientsurvey.repository.OptionRepository;
import com.survey.clientsurvey.service.OptionService;
import com.survey.clientsurvey.view.OptionView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OptionServiceImpl implements OptionService {

    @Autowired
   public OptionRepository optionRepository;
    public List<Option> getAllOptions(){
        List<Option> options = new ArrayList<>();
        optionRepository.findAll()
                .forEach(options::add);
        return options;

    }

    public OptionView addOption(OptionForm form){
        return new OptionView(optionRepository.save(new Option(form)));
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
