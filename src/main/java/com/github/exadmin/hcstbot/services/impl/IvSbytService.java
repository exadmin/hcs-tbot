package com.github.exadmin.hcstbot.services.impl;

import com.github.exadmin.hcstbot.model.auth.CredentialsModel;
import com.github.exadmin.hcstbot.model.auth.UserModel;
import com.github.exadmin.hcstbot.services.AbstractService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class IvSbytService extends AbstractService {
    public static final String SERVICE_ID = "ivsbyt.ru";

    public IvSbytService(UserModel userModel) {
        super(userModel);
    }

    @Override
    protected String getServiceId() {
        return SERVICE_ID;
    }

    @Override
    public boolean performAuthentication() {
        // select authentication model first
        CredentialsModel selectedCredModel = null;

        for (CredentialsModel credModel : userModel.getCredModels()) {
            if (credModel.getServiceId().equals(getServiceId())) {
                // found
                selectedCredModel = credModel;
                break;
            }
        }

        if (selectedCredModel == null) {
            return false;
        }

        try {
            webDriver.get("https://lkk.ivsbyt.ru/login");

            WebElement taLogin = webDriver.findElement(By.name("login"));
            taLogin.sendKeys(selectedCredModel.getLogin());

            WebElement taPassword = webDriver.findElement(By.name("password"));
            taPassword.sendKeys(selectedCredModel.getPassword());

            WebElement btnEnter = webDriver.findElement(By.className("stack-btn-primary"));
            btnEnter.click();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }

        return true;
    }

    @Override
    public String getInfo() {
        WebElement weDiv = webDriver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div[2]/div/div[2]/div[2]/div/a"));
        return weDiv.getText();
    }

    @Override
    public void logout() {
        webDriver.get("https://lkk.ivsbyt.ru/logout");
        webDriver.close();
    }


}
