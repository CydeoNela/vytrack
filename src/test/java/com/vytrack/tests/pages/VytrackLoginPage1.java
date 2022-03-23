package com.vytrack.tests.pages;

import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VytrackLoginPage1 {

    public VytrackLoginPage1(){

        PageFactory.initElements(Driver.getDriver(), this);

    }

    //login label
    @FindBy(xpath = "//h2[@class='title']")
    public WebElement loginLabel;

    //userNameInput
    @FindBy(id = "prependedInput")
    public WebElement userNameInput;

    //passwordInput
    @FindBy(id = "prependedInput2")
    public WebElement passwordInput;

    //checkBoxRemember
    @FindBy(xpath = "//span[@class='custom-checkbox__icon']")
    public WebElement checkBoxRemember;

    //rememberMeText
    @FindBy(xpath = "//span[.='Remember me on this computer']")
    public WebElement rememberMeText;

    //forgotPasswordLink
    @FindBy(xpath = "//a[@href='/user/reset-request']")
    public WebElement forgotPasswordLink;

    //loginButton
    @FindBy(id = "_submit")
    public WebElement loginButton;

    //fleetTextOnTheBottom
    @FindBy(xpath = "//div[@class='login-copyright']")
    public WebElement fleetTextOnTheBottom;

    public void goToLoginPage(){
        Driver.getDriver().get(ConfigurationReader.getProperty("env1"));
    }

    public void login(String userName, String password){
        goToLoginPage();
        userNameInput.sendKeys(userName);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

}
