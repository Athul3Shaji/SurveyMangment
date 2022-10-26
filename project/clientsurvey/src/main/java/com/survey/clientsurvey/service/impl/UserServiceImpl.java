package com.survey.clientsurvey.service.impl;

import com.survey.clientsurvey.form.UserForm;
import com.survey.clientsurvey.model.User;
import com.survey.clientsurvey.repository.UserRepository;
import com.survey.clientsurvey.service.UserService;
import com.survey.clientsurvey.view.UserView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
//    @Autowired
//    private PasswordEncoder passwordEncoder;



    public UserView add(UserForm form) {
        return new UserView(userRepository.save(new User(
                form.getName(),
                form.getEmail(),
                form.getPassword()
        )));
    }


    public Collection<User> list() {
        return userRepository.findAll();
    }
}
