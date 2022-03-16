package com.vytrack.Pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DescriptionPage_CihadSahin {
    public DescriptionPage_CihadSahin(){

        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "(//span[@class='title title-level-1'])[3]")
    public WebElement driver_activityTab;

    @FindBy(xpath = "//span[.='Calendar Events']")
    public WebElement driver_CalenderEventTab;

    @FindBy(xpath = "//a[@title='Create Calendar event']")
    public  WebElement driver_createCalenderEvent;

    @FindBy(xpath = "(//input[@type='text'])[4]")
    public WebElement driver_CreateTitle;

    @FindBy(xpath = "//iframe")
    public WebElement driver_SwitchToIframe;

    @FindBy (xpath = "//body[@id='tinymce']")
    public WebElement driver_Description_Message;
    @FindBy(xpath = "//button[@class='btn btn-success action-button']")
    public WebElement driver_SaveAndClose;
    @FindBy(xpath = "//p")
    public WebElement driver_verifyEventCreated;
    @FindBy(xpath = "(//td[.='Alex Jones'])[last()]")
    public WebElement driver_find_last_Created;










    @FindBy(xpath = "//div[@id='main-menu']/ul/li[5]/a[@href='#']/span[@class='title title-level-1']")
    public WebElement salesManager_activityTab;

    @FindBy(xpath = "//span[.='Calendar Events']")
    public WebElement salesManager_CalenderEventTab;

    @FindBy(xpath = "//a[@title='Create Calendar event']")
    public  WebElement salesManager_createCalenderEvent;

    @FindBy(xpath = "(//input[@type='text'])[3]")
    public WebElement salesManager_CreateTitle;

    @FindBy(xpath = "//iframe")
    public WebElement salesManager_SwitchToIframe;

    @FindBy (xpath = "//body[@id='tinymce']")
    public WebElement salesManager_Description_Message;
    @FindBy(xpath = "//button[@class='btn btn-success action-button']")
    public WebElement salesManager_SaveAndClose;
    @FindBy(xpath = "//p")
    public WebElement salesManager_verifyEventCreated;
    @FindBy(xpath = "(//td[.='Alex Jones'])[last()]")
    public WebElement salesManager_find_last_Created;










    @FindBy(xpath = "//div[@id='main-menu']/ul/li[5]/a[@href='#']/span[@class='title title-level-1']")
    public WebElement storeManager_activityTab;

    @FindBy(xpath = "//span[.='Calendar Events']")
    public WebElement storeManager_CalenderEventTab;

    @FindBy(xpath = "//a[@title='Create Calendar event']")
    public  WebElement storeManager_createCalenderEvent;

    @FindBy(xpath = "(//input[@type='text'])[4]")
    public WebElement storeManager_CreateTitle;

    @FindBy(xpath = "//iframe")
    public WebElement storeManager_SwitchToIframe;

    @FindBy (xpath = "//body[@id='tinymce']")
    public WebElement storeManager_Description_Message;
    @FindBy(xpath = "//button[@class='btn btn-success action-button']")
    public WebElement storeManager_SaveAndClose;
    @FindBy(xpath = "//p")
    public WebElement storeManager_verifyEventCreated;
    @FindBy(xpath = "(//td[.='No'])[last()]")
    public WebElement storeManager_find_last_Created;


}
