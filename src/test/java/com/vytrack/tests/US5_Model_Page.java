package com.vytrack.tests;

import com.vytrack.tests.base.TestBase;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class US5_Model_Page extends TestBase {
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

        //   Hover over the fleet button
        Actions actions = new Actions(Driver.getDriver());

        actions.moveToElement(fleetButton).perform();

        BrowserUtils.sleep(2);

        WebElement vehicleModelButton = Driver.getDriver().findElement(By.xpath("//span[.='Vehicles Model']"));
        vehicleModelButton.click();

    }
}
