package com.vytrack.tests;


import com.vytrack.tests.base.TestBase;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VytrackUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class US11_AccessToVehicleOdometer extends TestBase {

    @DataProvider(name = "roles")
    public Object[][] provideRoles() {
        return new Object[][]{{"storemanager"}, {"driver"}};
    }

    @Test(dataProvider = "roles")
    public void accessToVehicleOdometer(String role) {
        switch (role) {
            case "driver":

                VytrackUtils.loginAsDriver();

                BrowserUtils.sleep(2);

                WebElement fleetMenu = Driver.getDriver().findElement(By.xpath("(//span[@class='title title-level-1'])[1]"));
                // System.out.println("fleetMenu.getText() = " + fleetMenu.getText());
                fleetMenu.click();
                BrowserUtils.sleep(2);

                WebElement vehicleOdometer = Driver.getDriver().findElement(By.xpath("(//span[@class='title title-level-2'])[2]"));
                // System.out.println("vehicleOdometer.getText() = " + vehicleOdometer.getText());
                vehicleOdometer.click();
                BrowserUtils.sleep(2);

                WebElement number1 = Driver.getDriver().findElement(By.xpath("//input[@value='1']"));
                System.out.println("number1.getText() = " + number1.getText());
                Assert.assertTrue(number1.isDisplayed());


                WebElement number25 = Driver.getDriver().findElement(By.xpath("//button[@class='btn dropdown-toggle ']"));
                System.out.println("number25.getText() = " + number25.getText());
                Assert.assertTrue(number25.isDisplayed());
                break;

            case "storemanager":
                VytrackUtils.loginAsStoreManger();
                Driver.getDriver().findElement(By.cssSelector("button[data-dismiss='alert']")).click();//closing the alert

                WebElement fleetMenu2 = Driver.getDriver().findElement(By.xpath("(//span[@class='title title-level-1'])[2]"));
                System.out.println("fleetMenu.getText() = " + fleetMenu2.getText());
                fleetMenu2.click();
                BrowserUtils.sleep(2);

                WebElement vehicleOdometer2 = Driver.getDriver().findElement(By.xpath("(//span[@class='title title-level-2'])[4]"));
                System.out.println("vehicleOdometer.getText() = " + vehicleOdometer2.getText());
                vehicleOdometer2.click();
                BrowserUtils.sleep(2);

                WebElement errorMessage = Driver.getDriver().findElement(By.cssSelector("div[class = 'message']"));
                System.out.println("errorMessage.getText() = " + errorMessage.getText());
                break;

        }
    }
}
