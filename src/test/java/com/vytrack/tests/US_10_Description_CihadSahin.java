package com.vytrack.tests;

import com.vytrack.tests.base.TestBaseCihadSahin;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.VytrackUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US_10_Description_CihadSahin extends TestBaseCihadSahin {


    @Test (priority = 1)
    public void driver_is_Description_Field_Working(){
//    go to login page
    loginPage.gotoLoginPage();

//    login
    loginPage.login(ConfigurationReader.getProperty("driver_username"),ConfigurationReader.getProperty("driver_password"));
//     activities element hover
     VytrackUtils.waitTillLoaderMaskDisappear();
    BrowserUtils.hover(descriptionPage.driver_activityTab);


//    click to Calendar Events
    descriptionPage.driver_CalenderEventTab.click();

//    Click create calendar event button
    descriptionPage.driver_createCalenderEvent.click();


//    write Title
        VytrackUtils.waitTillLoaderMaskDisappear();
    descriptionPage.driver_CreateTitle.sendKeys("Test1");


//    switch to description iframe
    BrowserUtils.iframe(descriptionPage.driver_SwitchToIframe);


//    write description message
    descriptionPage.driver_Description_Message.sendKeys("Test 2 is in progress");


// get out of Frame
 BrowserUtils.getOutOfFrame();
// save and Close click
        descriptionPage.driver_SaveAndClose.click();

        //     activities element hover
        VytrackUtils.waitTillLoaderMaskDisappear();
        BrowserUtils.hover(descriptionPage.driver_activityTab);

        //    click to Calendar Events
        descriptionPage.driver_CalenderEventTab.click();

        // find last created
        descriptionPage.driver_find_last_Created.click();


//    verify if event is created
        VytrackUtils.waitTillLoaderMaskDisappear();
    String actualText = descriptionPage.driver_verifyEventCreated.getText();
    String expectedText="Test 2 is in progress";
    Assert.assertEquals(expectedText,actualText);

}

    @Test (priority = 2)
    public void salesManager_is_Description_Field_Working(){
//    go to login page
        loginPage.gotoLoginPage();

//    login
        loginPage.login(ConfigurationReader.getProperty("sales_manager_username"),ConfigurationReader.getProperty("sales_manager_password"));
//     activities element hover
        VytrackUtils.waitTillLoaderMaskDisappear();
        BrowserUtils.hover(descriptionPage.salesManager_activityTab);


//    click to Calendar Events
        descriptionPage.salesManager_CalenderEventTab.click();

//    Click create calendar event button
        descriptionPage.salesManager_createCalenderEvent.click();


//    write Title
        VytrackUtils.waitTillLoaderMaskDisappear();
        descriptionPage.salesManager_CreateTitle.sendKeys("Test1");


//    switch to description iframe
        BrowserUtils.iframe(descriptionPage.salesManager_SwitchToIframe);


//    write description message
        descriptionPage.salesManager_Description_Message.sendKeys("Test 2 is in progress");


// get out of Frame
        BrowserUtils.getOutOfFrame();
// save and Close click
        descriptionPage.salesManager_SaveAndClose.click();

        //     activities element hover
        VytrackUtils.waitTillLoaderMaskDisappear();
        BrowserUtils.hover(descriptionPage.salesManager_activityTab);

        //    click to Calendar Events
        descriptionPage.salesManager_CalenderEventTab.click();

        // find last created
        descriptionPage.salesManager_find_last_Created.click();


//    verify if event is created
        VytrackUtils.waitTillLoaderMaskDisappear();
        String actualText = descriptionPage.salesManager_verifyEventCreated.getText();
        String expectedText="Test 2 is in progress";
        Assert.assertEquals(expectedText,actualText);

    }
    @Test (priority = 3)
    public void storeManager_is_Description_Field_Working(){
//    go to login page
        loginPage.gotoLoginPage();

//    login
        loginPage.login(ConfigurationReader.getProperty("store_manager_username"),ConfigurationReader.getProperty("store_manager_password"));
//     activities element hover
        VytrackUtils.waitTillLoaderMaskDisappear();
        BrowserUtils.hover(descriptionPage.storeManager_activityTab);


//    click to Calendar Events
        descriptionPage.storeManager_CalenderEventTab.click();

//    Click create calendar event button
        descriptionPage.storeManager_createCalenderEvent.click();


//    write Title
        VytrackUtils.waitTillLoaderMaskDisappear();
        descriptionPage.storeManager_CreateTitle.sendKeys("Test1");


//    switch to description iframe
        BrowserUtils.iframe(descriptionPage.storeManager_SwitchToIframe);


//    write description message
        descriptionPage.storeManager_Description_Message.sendKeys("Test 2 is in progress");


// get out of Frame
        BrowserUtils.getOutOfFrame();
// save and Close click
        descriptionPage.storeManager_SaveAndClose.click();

        //     activities element hover
        VytrackUtils.waitTillLoaderMaskDisappear();
        BrowserUtils.hover(descriptionPage.storeManager_activityTab);

        //    click to Calendar Events
        descriptionPage.storeManager_CalenderEventTab.click();

        // find last created
        descriptionPage.storeManager_find_last_Created.click();


//    verify if event is created
        VytrackUtils.waitTillLoaderMaskDisappear();
        String actualText = descriptionPage.storeManager_verifyEventCreated.getText();
        String expectedText="Test 2 is in progress";
        Assert.assertEquals(expectedText,actualText);

    }


}
