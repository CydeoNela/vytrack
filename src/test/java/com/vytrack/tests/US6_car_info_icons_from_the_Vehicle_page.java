package com.vytrack.tests;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VytrackUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class US6_car_info_icons_from_the_Vehicle_page {

    @DataProvider(name = "vytrack")
    public Object[][] firstDataProvider(){
        return new Object[][]{
                {ConfigurationReader.getProperty("store_manager_username"), ConfigurationReader.getProperty("driver_password")},
                {ConfigurationReader.getProperty("sales_manager_username"), ConfigurationReader.getProperty("driver_password")},
        };
    }

    @Test(dataProvider = "vytrack")
    public void test_car_edited_options(String login, String password){

        System.out.println(login + " : " + password);

        VytrackUtils.login(login, password);
        VytrackUtils.waitTillLoaderMaskDisappear();

        Actions actions = new Actions(Driver.getDriver());

        actions.moveToElement(Driver.getDriver().findElement(By.xpath("//li[2]//span[@class='title title-level-1']")))
                .pause(1)
                .perform();

        Driver.getDriver().findElement(By.xpath("//li[2]//ul//li[3]//a//span[.='Vehicles']")).click();

        BrowserUtils.sleep(2);

        //(//a[@class='dropdown-toggle'])[1]
        //(//td//div//a[.='...'])[4]

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        js.executeScript("window.scrollBy(750.0)");

        actions.moveToElement(Driver.getDriver().findElement(By.xpath("(//a[@class='dropdown-toggle'])[1]")))
                .pause(1)
                .perform();

        BrowserUtils.sleep(3);

        //List<WebElement> elements = Driver.getDriver()
             //   .findElements(By.xpath("(//td//div//ul[@class='nav nav-pills icons-holder launchers-list'])[3]"));

        /*
        List<String> expectedTextOptions = new ArrayList<>(Arrays.asList("View", "Edit", "Delete"));
        List<String> actualTextOptions = new ArrayList<>();

        for (WebElement each : elements) {
            actualTextOptions.add(each.getText());
        }

        Assert.assertEquals(actualTextOptions, expectedTextOptions);

         */



    }

    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }
}
