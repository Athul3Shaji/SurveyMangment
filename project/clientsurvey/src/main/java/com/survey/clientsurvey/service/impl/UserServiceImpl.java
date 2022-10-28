package com.survey.clientsurvey.service.impl;

import com.survey.clientsurvey.exception.BadRequestException;
import com.survey.clientsurvey.exception.NotFoundException;
import com.survey.clientsurvey.form.LoginForm;
import com.survey.clientsurvey.form.UserForm;
import com.survey.clientsurvey.model.User;
import com.survey.clientsurvey.repository.UserRepository;
import com.survey.clientsurvey.security.config.SecurityConfig;
import com.survey.clientsurvey.security.util.InvalidTokenException;
import com.survey.clientsurvey.security.util.SecurityUtil;
import com.survey.clientsurvey.security.util.TokenExpiredException;
import com.survey.clientsurvey.security.util.TokenGenerator;
import com.survey.clientsurvey.security.util.TokenGenerator.Status;
import com.survey.clientsurvey.security.util.TokenGenerator.Token;
import com.survey.clientsurvey.service.UserService;
import com.survey.clientsurvey.view.LoginView;
import com.survey.clientsurvey.view.UserView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

import java.util.Collection;

import static com.survey.clientsurvey.security.AccessTokenUserDetailsService.PURPOSE_ACCESS_TOKEN;

@Service
public class UserServiceImpl implements UserService {

    private static final String PURPOSE_REFRESH_TOKEN = "REFRESH_TOKEN";

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TokenGenerator tokenGenerator;

    @Autowired
    private SecurityConfig securityConfig;




    public UserView add(UserForm form) {
        return new UserView(userRepository.save(new User(
                form.getName(),
                form.getEmail(),
                passwordEncoder.encode(form.getPassword())
        )));
    }


    @Override
    public UserView currentUser() {
        return new UserView(
                userRepository.findById(SecurityUtil.getCurrentUserId()).orElseThrow(NotFoundException::new)
        );
    }

    @Override
    public LoginView login(LoginForm form, Errors errors) throws BadRequestException {
        if (errors.hasErrors()) {
            throw badRequestException();
        }
        User user = userRepository.findByEmail(form.getEmail()).orElseThrow(UserServiceImpl::badRequestException);
        if (!passwordEncoder.matches(form.getPassword(), user.getPassword())) {
            throw badRequestException();
        }

        String id = String.format("%010d", user.getUserId());
        Token accessToken = tokenGenerator.create(PURPOSE_ACCESS_TOKEN, id, securityConfig.getAccessTokenExpiry());
        Token refreshToken = tokenGenerator.create(PURPOSE_REFRESH_TOKEN, id + user.getPassword(), securityConfig.getRefreshTokenExpiry());
        return new LoginView(user, accessToken, refreshToken);
    }

    @Override
    public LoginView refresh(String refreshToken) throws BadRequestException {
        Status status;
        try {
            status = tokenGenerator.verify(PURPOSE_REFRESH_TOKEN, refreshToken);
        } catch (InvalidTokenException e) {
            throw new BadRequestException("Invalid token", e);
        } catch (TokenExpiredException e) {
            throw new BadRequestException("Token expired", e);
        }

        int userId;
        try {
            userId = Integer.parseInt(status.data.substring(0, 10));
        } catch (NumberFormatException e) {
            throw new BadRequestException("Invalid token", e);
        }

        String password = status.data.substring(10);

        User user = userRepository.findByUserIdAndPassword(userId, password).orElseThrow(UserServiceImpl::badRequestException);

        String id = String.format("%010d", user.getUserId());
        Token accessToken = tokenGenerator.create(PURPOSE_ACCESS_TOKEN, id, securityConfig.getAccessTokenExpiry());
        return new LoginView(
                user,
                new LoginView.TokenView(accessToken.value, accessToken.expiry),
                new LoginView.TokenView(refreshToken, status.expiry)
        );
    }

    private static BadRequestException badRequestException() {
        return new BadRequestException("Invalid credentials");
    }

    public Collection<User> list() {
        return userRepository.findAll();
    }
}
