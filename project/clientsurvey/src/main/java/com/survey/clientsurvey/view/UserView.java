package com.survey.clientsurvey.view;

import com.survey.clientsurvey.json.Json;
import com.survey.clientsurvey.model.User;

import java.util.Date;

public class UserView {

    private final int userId;
    private final String name;
    private final String email;
    private final short status;
    @Json.DateTimeFormat
    private final Date createDate;
    @Json.DateTimeFormat
    private final Date updateDate;

    public UserView(User user) {
        this.userId = user.getUserId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.status = user.getStatus();
        this.createDate = user.getCreateDate();
        this.updateDate = user.getUpdateDate();
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public short getStatus() {
        return status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }
}