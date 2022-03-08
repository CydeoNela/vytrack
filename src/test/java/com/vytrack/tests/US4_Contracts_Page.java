package com.vytrack.tests;

import com.vytrack.tests.base.TestBase;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import org.apache.hc.core5.reactor.Command;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class US4_Contracts_Page extends TestBase {


    @Test

    public void SalesManager() {

//we locate the username button and we send the username key
        WebElement userName = Driver.getDriver().findElement(By.xpath("//input[@name='_username']"));
        userName.sendKeys(ConfigurationReader.getProperty("sales_manager_username"));

        //we locate the password and we send the key
        WebElement password = Driver.getDriver().findElement(By.xpath("//input[@name='_password']"));
        password.sendKeys(ConfigurationReader.getProperty("sales_manager_password"));

        //we locate the login button and we click it
        WebElement login = Driver.getDriver().findElement(By.xpath("//button[@type='submit']"));
        login.click();

        //the page is taking some time to load, so I put 8 seconds wait time before proceeding with the next step
        BrowserUtils.sleep(8);

        //we locate the fleet button and we click
        WebElement fleetButton = Driver.getDriver().findElement(By.xpath("(//span[@class='title title-level-1'])[2]"));
        fleetButton.click();

        // I want to see the options that is giving me when I click the fleet, so I put one second wait time
        BrowserUtils.sleep(1);

        //we locate the vehicle contract button and I click
        WebElement vehicleContractButton = Driver.getDriver().findElement(By.xpath("//span[.='Vehicle Contracts']"));
        vehicleContractButton.click();

        // I want to see the next page, so I put 3 seconds wait time
        BrowserUtils.sleep(3);

        // I located the header of the new page and assert it to be displayed
        WebElement vehicleContractPage = Driver.getDriver().findElement(By.xpath("//h1[@class='oro-subtitle']"));
        Assert.assertTrue(vehicleContractPage.isDisplayed());


    }

    @Test
    public void StoreManager() {


        WebElement userName = Driver.getDriver().findElement(By.xpath("//input[@name='_username']"));
        userName.sendKeys(ConfigurationReader.getProperty("store_manager_username"));

        WebElement password = Driver.getDriver().findElement(By.xpath("//input[@name='_password']"));
        password.sendKeys(ConfigurationReader.getProperty("sales_manager_password"));

        WebElement login = Driver.getDriver().findElement(By.xpath("//button[@type='submit']"));
        login.click();

        BrowserUtils.sleep(8);
        WebElement fleetButton = Driver.getDriver().findElement(By.xpath("(//span[@class='title title-level-1'])[2]"));
        fleetButton.click();

        BrowserUtils.sleep(1);


        WebElement vehicleContractButton = Driver.getDriver().findElement(By.xpath("//span[.='Vehicle Contracts']"));
        vehicleContractButton.click();

        BrowserUtils.sleep(5);


        WebElement vehicleContractPage = Driver.getDriver().findElement(By.xpath("//h1[@class='oro-subtitle']"));
        Assert.assertTrue(vehicleContractPage.isDisplayed());
    }

    @Test
    public void DriverTesting() {

        WebElement userName = Driver.getDriver().findElement(By.xpath("//input[@name='_username']"));
        userName.sendKeys(ConfigurationReader.getProperty("driver_username"));

        WebElement password = Driver.getDriver().findElement(By.xpath("//input[@name='_password']"));
        password.sendKeys(ConfigurationReader.getProperty("driver_password"));

        WebElement login = Driver.getDriver().findElement(By.xpath("//button[@type='submit']"));
        login.click();

        BrowserUtils.sleep(8);
        WebElement fleetButton = Driver.getDriver().findElement(By.xpath("(//span[@class='title title-level-1'])[1]"));
        fleetButton.click();
        BrowserUtils.sleep(1);

        WebElement vehicleContractButton = Driver.getDriver().findElement(By.xpath("//span[.='Vehicle Contracts']"));
        vehicleContractButton.click();

        BrowserUtils.sleep(2);

        WebElement errorMessage = Driver.getDriver().findElement(By.xpath("//div[.='You do not have permission to perform this action.']"));

        String expectedErrorMessage = "You do not have permission to perform this action.";
        String actualErrorMessage = errorMessage.getText();

        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);


    }


}
