package com.vytrack.tests;

import com.vytrack.tests.base.TestBase;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US5_Model_Page extends TestBase {
    @Test (priority = 1)

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
        BrowserUtils.sleep(5);

        //we locate the fleet button
        WebElement fleetButton = Driver.getDriver().findElement(By.xpath("(//span[@class='title title-level-1'])[2]"));

        //   Hover over the fleet button
        Actions actions = new Actions(Driver.getDriver());

        actions.moveToElement(fleetButton).perform();

        BrowserUtils.sleep(2);

        //we locate the vehicle model button and click it
        WebElement vehicleModelButton = Driver.getDriver().findElement(By.xpath("//span[.='Vehicles Model']"));
        vehicleModelButton.click();

        //we locate the 10 headers titles that shows in the vehicle model page
        WebElement modelName = Driver.getDriver().findElement(By.xpath("(//span[.='Model Name'])[1]"));
        WebElement make = Driver.getDriver().findElement(By.xpath("(//span[.='Make'])[1]"));
        WebElement can_be_requested = Driver.getDriver().findElement(By.xpath("(//span[.='Can be requested'])[1]"));
        WebElement cVVI = Driver.getDriver().findElement(By.xpath("(//span[.='CVVI'])[1]"));
        WebElement co2_Fee = Driver.getDriver().findElement(By.xpath("(//span[.='CO2 Fee (/month)'])[1]"));
        WebElement Cost_Depreciated = Driver.getDriver().findElement(By.xpath("(//span[.='Cost (Depreciated)'])[1]"));
        WebElement total_Cost_Depreciated = Driver.getDriver().findElement(By.xpath("(//span[.='Total Cost (Depreciated)'])[1]"));
        WebElement co2_Emissions = Driver.getDriver().findElement(By.xpath("(//span[.='CO2 Emissions'])[1]"));
        WebElement fuel_Type = Driver.getDriver().findElement(By.xpath("(//span[.='Fuel Type'])[1]"));
        WebElement vendors = Driver.getDriver().findElement(By.xpath("(//span[.='Vendors'])[1]"));

        //we assert that these titles are displayed
        Assert.assertTrue(modelName.isDisplayed(), "model is not displayed");
        Assert.assertTrue(make.isDisplayed(), "make is not displayed");
        Assert.assertTrue(can_be_requested.isDisplayed(), "can be request is not displayed");
        Assert.assertTrue(cVVI.isDisplayed(), "cvvi is not displayed");
        Assert.assertTrue(co2_Fee.isDisplayed(), "co2 fee is not displayed");
        Assert.assertTrue(Cost_Depreciated.isDisplayed(), "cost depreciated is not displayed");
        Assert.assertTrue(total_Cost_Depreciated.isDisplayed(), "total cost is not displayed");
        Assert.assertTrue(co2_Emissions.isDisplayed(), "co2 emission is not displayed");
        Assert.assertTrue(fuel_Type.isDisplayed(), "fuel type is not displayed");
        Assert.assertTrue(vendors.isDisplayed(), "vendorse is not displayed");
    }

    @Test (priority = 2)
    public void StoreManagerTest(){
        //we locate the username button and we send the username key
        WebElement userName = Driver.getDriver().findElement(By.xpath("//input[@name='_username']"));
        userName.sendKeys(ConfigurationReader.getProperty("store_manager_username"));

        //we locate the password and we send the key
        WebElement password = Driver.getDriver().findElement(By.xpath("//input[@name='_password']"));
        password.sendKeys(ConfigurationReader.getProperty("store_manager_password"));

        //we locate the login button and we click it
        WebElement login = Driver.getDriver().findElement(By.xpath("//button[@type='submit']"));
        login.click();

        //the page is taking some time to load, so I put 8 seconds wait time before proceeding with the next step
        BrowserUtils.sleep(5);

        //we locate the fleet button and we click
        WebElement fleetButton = Driver.getDriver().findElement(By.xpath("(//span[@class='title title-level-1'])[2]"));

        //   Hover over the fleet button
        Actions actions = new Actions(Driver.getDriver());

        actions.moveToElement(fleetButton).perform();

        BrowserUtils.sleep(2);

        WebElement vehicleModelButton = Driver.getDriver().findElement(By.xpath("//span[.='Vehicles Model']"));
        vehicleModelButton.click();

        WebElement modelName = Driver.getDriver().findElement(By.xpath("(//span[.='Model Name'])[1]"));
        WebElement make = Driver.getDriver().findElement(By.xpath("(//span[.='Make'])[1]"));
        WebElement can_be_requested = Driver.getDriver().findElement(By.xpath("(//span[.='Can be requested'])[1]"));
        WebElement cVVI = Driver.getDriver().findElement(By.xpath("(//span[.='CVVI'])[1]"));
        WebElement co2_Fee = Driver.getDriver().findElement(By.xpath("(//span[.='CO2 Fee (/month)'])[1]"));
        WebElement Cost_Depreciated = Driver.getDriver().findElement(By.xpath("(//span[.='Cost (Depreciated)'])[1]"));
        WebElement total_Cost_Depreciated = Driver.getDriver().findElement(By.xpath("(//span[.='Total Cost (Depreciated)'])[1]"));
        WebElement co2_Emissions = Driver.getDriver().findElement(By.xpath("(//span[.='CO2 Emissions'])[1]"));
        WebElement fuel_Type = Driver.getDriver().findElement(By.xpath("(//span[.='Fuel Type'])[1]"));
        WebElement vendors = Driver.getDriver().findElement(By.xpath("(//span[.='Vendors'])[1]"));

        Assert.assertTrue(modelName.isDisplayed(), "model is not displayed");
        Assert.assertTrue(make.isDisplayed(), "make is not displayed");
        Assert.assertTrue(can_be_requested.isDisplayed(), "can be request is not displayed");
        Assert.assertTrue(cVVI.isDisplayed(), "cvvi is not displayed");
        Assert.assertTrue(co2_Fee.isDisplayed(), "co2 fee is not displayed");
        Assert.assertTrue(Cost_Depreciated.isDisplayed(), "cost depreciated is not displayed");
        Assert.assertTrue(total_Cost_Depreciated.isDisplayed(), "total cost is not displayed");
        Assert.assertTrue(co2_Emissions.isDisplayed(), "co2 emission is not displayed");
        Assert.assertTrue(fuel_Type.isDisplayed(), "fuel type is not displayed");
        Assert.assertTrue(vendors.isDisplayed(), "vendorse is not displayed");
    }

        @Test(priority = 3)
        public void DriverTesting () {

            //we locate the username button and we send the username key
            WebElement userName = Driver.getDriver().findElement(By.xpath("//input[@name='_username']"));
            userName.sendKeys(ConfigurationReader.getProperty("driver_username"));

            //we locate the password and we send the key
            WebElement password = Driver.getDriver().findElement(By.xpath("//input[@name='_password']"));
            password.sendKeys(ConfigurationReader.getProperty("driver_password"));

            //we locate the login button and we click it
            WebElement login = Driver.getDriver().findElement(By.xpath("//button[@type='submit']"));
            login.click();

            BrowserUtils.sleep(3);

            //we locate the fleet button and we click
            WebElement fleetButton = Driver.getDriver().findElement(By.xpath("(//span[@class='title title-level-1'])[1]"));
            fleetButton.click();

            BrowserUtils.sleep(1);

            //we locate the vehicle model button and click it
            WebElement vehiclesModelButton = Driver.getDriver().findElement(By.xpath("(//span[.='Vehicles Model'])[1]"));
            vehiclesModelButton.click();

            //we locate the error message that will be displayed after clicking the model page button
            WebElement errorMessage = Driver.getDriver().findElement(By.xpath("//div[.='You do not have permission to perform this action.']"));

            //we verify that the error message is displayed
            Assert.assertTrue(errorMessage.isDisplayed(),"error message is not displayed");

        }
    }
