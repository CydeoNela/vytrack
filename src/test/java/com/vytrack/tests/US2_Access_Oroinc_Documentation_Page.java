package com.vytrack.tests;

import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VytrackUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class US2_Access_Oroinc_Documentation_Page {

    @Test
    public void DriverAccessToOroincDocumentationPage(){

        //1. user go to the homepage (https://qa1.vytrack.com/user/login)
        VytrackUtils.loginAsDriver();

        //2. user click on the question icon
        WebElement questionIcon = Driver.getDriver().findElement(By.xpath("//a[@class='help no-hash']"));
        questionIcon.click();

        for(String each: Driver.getDriver().getWindowHandles()){
            Driver.getDriver().switchTo().window(each);
            System.out.println("Current title while switching windows: "+ Driver.getDriver().getCurrentUrl());
        }


        //7. Assert: Title is “New Window”
        String expectedURLAfterClick ="https://doc.oroinc.com/";
        String actualURL = Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(actualURL,expectedURLAfterClick);

        System.out.println("URL after click: "+actualURL);
        Driver.closeDriver();

    }

    @Test
    public void SalesManagerAccessToOroincDocumentationPage(){

        //1. user go to the homepage (https://qa1.vytrack.com/user/login)
        VytrackUtils.loginAsSalesManager();

        //2. user click on the question icon
        WebElement questionIcon = Driver.getDriver().findElement(By.xpath("//a[@class='help no-hash']"));
        questionIcon.click();

        for(String each: Driver.getDriver().getWindowHandles()){
            Driver.getDriver().switchTo().window(each);
            System.out.println("Current title while switching windows: "+ Driver.getDriver().getCurrentUrl());
        }


        //7. Assert: Title is “New Window”
        String expectedURLAfterClick ="https://doc.oroinc.com/";
        String actualURL = Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(actualURL,expectedURLAfterClick);

        System.out.println("URL after click: "+actualURL);
        Driver.closeDriver();

    }

    @Test
    public void StoreManagerAccessToOroincDocumentationPage(){

        //1. user go to the homepage (https://qa1.vytrack.com/user/login)
        VytrackUtils.loginAsStoreManger();

        //2. user click on the question icon
        WebElement questionIcon = Driver.getDriver().findElement(By.xpath("//a[@class='help no-hash']"));
        questionIcon.click();

        for(String each: Driver.getDriver().getWindowHandles()){
            Driver.getDriver().switchTo().window(each);
            System.out.println("Current title while switching windows: "+ Driver.getDriver().getCurrentUrl());
        }


        //7. Assert: Title is “New Window”
        String expectedURLAfterClick ="https://doc.oroinc.com/";
        String actualURL = Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(actualURL,expectedURLAfterClick);

        System.out.println("URL after click: "+actualURL);
        Driver.closeDriver();

    }

}
