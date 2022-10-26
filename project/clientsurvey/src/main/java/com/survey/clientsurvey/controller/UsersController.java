package com.survey.clientsurvey.controller;

import com.survey.clientsurvey.form.UserForm;
import com.survey.clientsurvey.model.User;
import com.survey.clientsurvey.service.UserService;
import com.survey.clientsurvey.view.UserView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UserService userService;

    @PostMapping
    public UserView add(@Valid @RequestBody UserForm form) {
        return userService.add(form);
    }

    @GetMapping
    public Collection<User> list() {
        return userService.list();
    }
}
