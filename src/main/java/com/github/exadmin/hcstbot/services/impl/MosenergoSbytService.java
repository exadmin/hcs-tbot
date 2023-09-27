package com.github.exadmin.hcstbot.services.impl;

import com.github.exadmin.hcstbot.model.auth.UserModel;
import com.github.exadmin.hcstbot.services.AbstractService;

public class MosenergoSbytService extends AbstractService {
    public static final String SERVICE_ID = "mosenergosbyt.ru";

    public MosenergoSbytService(UserModel userModel) {
        super(userModel);
    }

    @Override
    protected String getServiceId() {
        return SERVICE_ID;
    }

    @Override
    public boolean performAuthentication() {
        return false;
    }

    @Override
    public String getInfo() {
        return null;
    }

    @Override
    public void logout() {

    }
}
