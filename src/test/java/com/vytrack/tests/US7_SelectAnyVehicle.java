package com.vytrack.tests;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VytrackUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class US7_SelectAnyVehicle {

    //AC #1:  once the users launch on the Vehicle page, all the checkboxes should be unchecked.
    @Test
    public static void store_manager_all_checkboxes_unchecked() {

        //1. user logs in to https://qa1.vytrack.com/user/login
        VytrackUtils.loginAsStoreManger();

        //2. user hover over to Fleet
        WebElement fleetBtn = Driver.getDriver().findElement(By.xpath("(//span[@class='title title-level-1'])[2]"));

        Actions actions = new Actions(Driver.getDriver());
        BrowserUtils.sleep(2);
        actions.moveToElement(fleetBtn).perform();
        BrowserUtils.sleep(2);

        //3, user click on vehicle
        WebElement vehiclesBtn = Driver.getDriver().findElement(By.linkText("Vehicles"));
        vehiclesBtn.click();

        //4. user vuetify all checkboxes are unchecked
        //List<WebElement> allCheckboxes = Driver.getDriver().findElements(By.xpath("//input[@data-role='select-row-cell']"));
        List<WebElement> allCheckboxes = Driver.getDriver().findElements(By.xpath("//input[@tabindex='-1']"));
        for (WebElement eachCheckbox : allCheckboxes) {
            Assert.assertFalse(eachCheckbox.isSelected());
        }

        Driver.closeDriver();

    }

    //AC #2:  user check the first checkbox to check all the cars
    @Test
    public static void store_manager_check_first_checkbox() {

        //1. user logs in to https://qa1.vytrack.com/user/login
        VytrackUtils.loginAsStoreManger();

        //2. user hover over to Fleet
        WebElement fleetBtn = Driver.getDriver().findElement(By.xpath("(//span[@class='title title-level-1'])[2]"));

        Actions actions = new Actions(Driver.getDriver());
        BrowserUtils.sleep(2);
        actions.moveToElement(fleetBtn).perform();
        BrowserUtils.sleep(2);

        //3, user click on vehicle
        WebElement vehiclesBtn = Driver.getDriver().findElement(By.linkText("Vehicles"));
        vehiclesBtn.click();

        //4. user click on first checkbox to select all the cars
        WebElement firstCheckbox = Driver.getDriver().findElement(By.xpath("//div[@class='btn-group dropdown']//input[@type='checkbox']"));
        firstCheckbox.click();

        //4. user vuetify all checkboxes are checked
        List<WebElement> allCheckboxes = Driver.getDriver().findElements(By.xpath("//input[@tabindex='-1']"));
        for (WebElement eachCheckbox : allCheckboxes) {
            Assert.assertTrue(eachCheckbox.isSelected());
        }

        Driver.closeDriver();
    }

    //AC #3: users can select any car
    @Test
    public static void store_manager_select_any_car() {

        //1. user logs in to https://qa1.vytrack.com/user/login
        VytrackUtils.loginAsStoreManger();

        //2. user hover over to Fleet
        WebElement fleetBtn = Driver.getDriver().findElement(By.xpath("(//span[@class='title title-level-1'])[2]"));

        Actions actions = new Actions(Driver.getDriver());
        BrowserUtils.sleep(2);
        actions.moveToElement(fleetBtn).perform();
        BrowserUtils.sleep(2);

        //3, user click on vehicle
        WebElement vehiclesBtn = Driver.getDriver().findElement(By.linkText("Vehicles"));
        vehiclesBtn.click();

        //4. user check one checkbox to select one car
        WebElement checkbox4 = Driver.getDriver().findElement(By.xpath("(//input[@tabindex='-1'])[4]"));
        checkbox4.click();
        Assert.assertTrue(checkbox4.isSelected());

        WebElement checkbox16 = Driver.getDriver().findElement(By.xpath("(//input[@tabindex='-1'])[16]"));
        checkbox16.click();
        Assert.assertTrue(checkbox16.isSelected());

        Driver.closeDriver();
    }

}
