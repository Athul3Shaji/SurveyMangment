package com.survey.clientsurvey.service;

import com.survey.clientsurvey.form.UserForm;
import com.survey.clientsurvey.model.User;
import com.survey.clientsurvey.view.UserView;

import java.util.Collection;

public interface UserService {
    UserView add(UserForm form);

    Collection<User> list();
}
