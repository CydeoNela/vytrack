package com.vytrack.tests;

import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class US4_Contracts_Page {
    @Test
    public void SalesManager() throws InterruptedException {

        Driver.getDriver().get(ConfigurationReader.getProperty("env1"));

        WebElement userName = Driver.getDriver().findElement(By.xpath("//input[@name='_username']"));
        userName.sendKeys(ConfigurationReader.getProperty("sales_manager_username"));

        WebElement password = Driver.getDriver().findElement(By.xpath("//input[@name='_password']"));
        password.sendKeys(ConfigurationReader.getProperty("sales_manager_password"));

        WebElement login = Driver.getDriver().findElement(By.xpath("//button[@type='submit']"));
        login.click();

        WebElement fleetButton = Driver.getDriver().findElement(By.xpath("(//span[@class='title title-level-1'])[2]"));
        fleetButton.click();

        Thread.sleep(2000);

        WebElement vehicalContrat = Driver.getDriver().findElement(By.xpath("//span[.='Vehicle Contracts']"));
        vehicalContrat.click();
    }

    @AfterMethod
    public void terminate(){
        Driver.getDriver().close();
    }
}
