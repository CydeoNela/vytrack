package com.vytrack.tests;

import com.vytrack.tests.base.TestBase;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class US4_Contracts_Page extends TestBase {



    @Test
    public void SalesManager() {

        WebElement userName = Driver.getDriver().findElement(By.xpath("//input[@name='_username']"));
        userName.sendKeys(ConfigurationReader.getProperty("sales_manager_username"));

        WebElement password = Driver.getDriver().findElement(By.xpath("//input[@name='_password']"));
        password.sendKeys(ConfigurationReader.getProperty("sales_manager_password"));

        WebElement login = Driver.getDriver().findElement(By.xpath("//button[@type='submit']"));
        login.click();

       BrowserUtils.sleep(7);

        WebElement fleetButton = Driver.getDriver().findElement(By.xpath("(//span[@class='title title-level-1'])[2]"));
        fleetButton.click();

        WebElement vehicleContractButton = Driver.getDriver().findElement(By.xpath("//span[.='Vehicle Contracts']"));
        vehicleContractButton.click();

        BrowserUtils.sleep(5);


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

       BrowserUtils.sleep(7);
        WebElement fleetButton = Driver.getDriver().findElement(By.xpath("(//span[@class='title title-level-1'])[2]"));
        fleetButton.click();

        WebElement vehicleContractButton = Driver.getDriver().findElement(By.xpath("//span[.='Vehicle Contracts']"));
        vehicleContractButton.click();

        BrowserUtils.sleep(5);


        WebElement vehicleContractPage = Driver.getDriver().findElement(By.xpath("//h1[@class='oro-subtitle']"));
        Assert.assertTrue(vehicleContractPage.isDisplayed());
    }


}
