package com.survey.clientsurvey.service;

import com.survey.clientsurvey.exception.BadRequestException;
import com.survey.clientsurvey.form.LoginForm;
import com.survey.clientsurvey.form.UserForm;
import com.survey.clientsurvey.model.User;
import com.survey.clientsurvey.view.LoginView;
import com.survey.clientsurvey.view.UserView;
import org.springframework.validation.Errors;

import java.util.Collection;

public interface UserService {
    UserView add(UserForm form);

//    UserView currentUser();

    UserView currentUser();

    LoginView login(LoginForm form, Errors errors) throws BadRequestException;

    LoginView refresh(String refreshToken) throws BadRequestException;

    Collection<User> list();
}
