package com.github.exadmin.hcstbot.model.auth;

import java.util.List;

public class UserModel {
    private String tgNickname;
    private String friendlyName;
    private List<CredentialsModel> credModels;

    public String getTgNickname() {
        return tgNickname;
    }

    public void setTgNickname(String tgNickname) {
        this.tgNickname = tgNickname;
    }

    public List<CredentialsModel> getCredModels() {
        return credModels;
    }

    public void setCredModels(List<CredentialsModel> credModels) {
        this.credModels = credModels;
    }

    public String getFriendlyName() {
        return friendlyName;
    }

    public void setFriendlyName(String friendlyName) {
        this.friendlyName = friendlyName;
    }
}
