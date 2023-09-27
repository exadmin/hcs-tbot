package com.github.exadmin.hcstbot.services;

import com.github.exadmin.hcstbot.model.auth.UserModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class AbstractService {
    protected UserModel userModel;
    protected WebDriver webDriver;

    public AbstractService(UserModel userModel) {
        this.userModel = userModel;
        this.webDriver = new ChromeDriver();
    }

    /**
     * Return unique id of the service which will be used during credentials selecting
     * @return unique string (any chars allowed)
     */
    protected abstract String getServiceId();

    public abstract boolean performAuthentication();
    public abstract String getInfo();
    public abstract void logout();
}
