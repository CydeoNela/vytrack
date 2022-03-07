package com.vytrack.tests;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class US4_Contracts_Page {

@AfterMethod
 public void terminate(){
   BrowserUtils.sleep(3);
     Driver.getDriver().close();
   }
   @BeforeMethod
   public void start(){
       Driver.getDriver().get("https://qa1.vytrack.com/user/login");

   }

    @Test
    public void SalesManager(){

       // Driver.getDriver().get(ConfigurationReader.getProperty("env1"));

        WebElement userName = Driver.getDriver().findElement(By.xpath("//input[@name='_username']"));
        userName.sendKeys(ConfigurationReader.getProperty("sales_manager_username"));

        WebElement password = Driver.getDriver().findElement(By.xpath("//input[@name='_password']"));
        password.sendKeys(ConfigurationReader.getProperty("sales_manager_password"));

        WebElement login = Driver.getDriver().findElement(By.xpath("//button[@type='submit']"));
        login.click();

        BrowserUtils.sleep(7);

        WebElement fleetButton = Driver.getDriver().findElement(By.xpath("(//span[@class='title title-level-1'])[2]"));
        fleetButton.click();

        WebElement vehicalContrat = Driver.getDriver().findElement(By.xpath("//span[.='Vehicle Contracts']"));
        vehicalContrat.click();
    }

    @Test
    public void StoreManager(){

            // Driver.getDriver().get(ConfigurationReader.getProperty("env1"));

            WebElement userName = Driver.getDriver().findElement(By.xpath("//input[@name='_username']"));
            userName.sendKeys(ConfigurationReader.getProperty("store_manager_username"));

            WebElement password = Driver.getDriver().findElement(By.xpath("//input[@name='_password']"));
            password.sendKeys(ConfigurationReader.getProperty("sales_manager_password"));

            WebElement login = Driver.getDriver().findElement(By.xpath("//button[@type='submit']"));
            login.click();

            BrowserUtils.sleep(7);

            WebElement fleetButton = Driver.getDriver().findElement(By.xpath("(//span[@class='title title-level-1'])[2]"));
            fleetButton.click();

            WebElement vehicalContrat = Driver.getDriver().findElement(By.xpath("//span[.='Vehicle Contracts']"));
            vehicalContrat.click();
    }


}
