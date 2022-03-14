package com.vytrack.tests;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VytrackUtils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class US6_car_info_icons_from_the_Vehicle_page {

    @DataProvider(name = "vytrack")
    public Object[][] firstDataProvider(){
        return new Object[][]{
                {ConfigurationReader.getProperty("store_manager_username"), ConfigurationReader.getProperty("password")},
                {ConfigurationReader.getProperty("sales_manager_username"), ConfigurationReader.getProperty("password")},
        };
    }

    @Test(dataProvider = "vytrack")
    public void test_car_edited_options(String login, String password) throws IOException {

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


        actions.moveToElement(Driver.getDriver().findElement(By.xpath("(//td[.='...'])[4]")))
                .pause(2)
                .perform();

        File scrFile = ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.FILE);
        // Now you can do whatever you need to do with it, for example copy somewhere
        FileUtils.copyFile(scrFile, new File("c:\\tmp\\screenshot.png"));



        BrowserUtils.sleep(3);





       /* List<String> expectedTextOptions = new ArrayList<>(Arrays.asList("View", "Edit", "Delete"));
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
