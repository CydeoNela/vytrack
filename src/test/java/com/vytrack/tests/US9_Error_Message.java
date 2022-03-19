package com.vytrack.tests;

import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VytrackUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US9_Error_Message {
    @Test
    public void invalid_repat_day(){
        VytrackUtils.loginAsDriver();
        VytrackUtils.waitTillLoaderMaskDisappear();
        WebElement activities = Driver.getDriver().findElement(By.xpath("(//li[@class='dropdown dropdown-level-1'])[3]"));

        Actions actions=new Actions(Driver.getDriver());
        actions.moveToElement(activities).perform();
        Driver.getDriver().findElement(By.xpath("//span[.='Calendar Events']")).click();
        VytrackUtils.waitTillLoaderMaskDisappear();

        Driver.getDriver().findElement(By.xpath("//a[@title='Create Calendar event']")).click();
        Driver.getDriver().findElement(By.xpath("//input[starts-with(@id,'recurrence-repeat-view')]")).click();

        WebElement inputBox = Driver.getDriver().findElement(By.xpath("//div[@data-name='recurrence-daily']//input[@type='text']"));
        inputBox.clear();
        inputBox.sendKeys("0");

        WebElement errMessage1 = Driver.getDriver().findElement(By.xpath("//span[.='The value have not to be less than 1.']"));
        String expectedErrMessage1="The value have not to be less than 1.";
        String actualErrMessage1=errMessage1.getText();
        Assert.assertEquals(actualErrMessage1,expectedErrMessage1);

        inputBox.clear();
        inputBox.sendKeys("110");



    }
}
