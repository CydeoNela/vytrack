package com.vytrack.Pages;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VyTrackLoginPage_CihadSahin {
    public VyTrackLoginPage_CihadSahin(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    //username
    @FindBy(id = "prependedInput")
    public WebElement userNameInput;

    //password
    @FindBy(css = "input[id='prependedInput2']")
    public WebElement passwordInput;

    //login button
    @FindBy(xpath = "//button[@id='_submit']")
    public WebElement loginButton;

    public void gotoLoginPage(){
        Driver.getDriver().get(ConfigurationReader.getProperty("env1"));
    }

    public void login(String userName,String password){
        userNameInput.sendKeys(userName);
        BrowserUtils.sleep(2);
        passwordInput.sendKeys(password);
        BrowserUtils.sleep(2);
        loginButton.click();
    }
}
