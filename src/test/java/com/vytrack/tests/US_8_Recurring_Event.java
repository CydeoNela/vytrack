package com.vytrack.tests;


import com.vytrack.tests.base.TestBase;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VytrackUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US_8_Recurring_Event extends TestBase{

@Test
public void default1CheckedForRepeat(){
        //Users are on the homepage
        VytrackUtils.loginAsStoreManger();

        //Click the “Calendar Events” under the Activities
        WebElement Activities = Driver.getDriver().findElement(By.xpath("//span[contains( .,\"Activities\")]"));

        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(Activities).perform();

        WebElement calendarEvents = Driver.getDriver().findElement(By.xpath("//span[contains(.,'Calendar Events')]"));
        calendarEvents.click();

        BrowserUtils.sleep(3);
        //Click the “Create Calendar Event” button
        WebElement creatCalEvent = Driver.getDriver().findElement(By.xpath("//a[@title='Create Calendar event']"));
        creatCalEvent.click();

        BrowserUtils.sleep(3);

        //Check the Repeat checkbox
        WebElement checkBox = Driver.getDriver().findElement(By.xpath("//input[@data-name='recurrence-repeat']"));
        checkBox.click();

        BrowserUtils.sleep(3);


        WebElement repeat = Driver.getDriver().findElement(By.xpath("(//input[@class='recurrence-subview-control__number'])[1]"));
        String actualResult = repeat.getAttribute("value");
        String expectedResult = "1";

        System.out.println("actualResult = " + actualResult);
        System.out.println("expectedResult = " + expectedResult);
        Assert.assertEquals(actualResult,expectedResult);
        }



@Test
public void clear1UncheckedForRepeat() {
        //Users are on the homepage
        VytrackUtils.loginAsSalesManager();

        //Click the “Calendar Events” under the Activities
        WebElement Activities = Driver.getDriver().findElement(By.xpath("//span[contains( .,\"Activities\")]"));

        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(Activities).perform();

        BrowserUtils.sleep(2);
        Activities.click();
        WebElement calendarEvents = Driver.getDriver().findElement(By.xpath("//span[contains(.,'Calendar Events')]"));
        calendarEvents.click();

        //Click the “Create Calendar Event” button
        WebElement creatCalEvent = Driver.getDriver().findElement(By.xpath("//a[@title='Create Calendar event']"));
        creatCalEvent.click();

        //Check the Repeat checkbox
        WebElement checkBox = Driver.getDriver().findElement(By.xpath("//input[@data-name='recurrence-repeat']"));
        checkBox.click();


        //Clear(delete) the number 1
        WebElement repeat = Driver.getDriver().findElement(By.xpath("(//input[@class='recurrence-subview-control__number'])[1]"));
        repeat.clear();


        //Verify the app displays “This value should not be blank.”
        WebElement errormsg = Driver.getDriver().findElement(By.xpath("//span[@class='validation-failed']"));
        String expectedErrormsg = "This value should not be blank.";
        String actualErrorMesssage = errormsg.getText();

        System.out.println("actualErrorMesssage = " + actualErrorMesssage);
        System.out.println("expectedErrormsg = " + expectedErrormsg);

        Assert.assertEquals(actualErrorMesssage,expectedErrormsg);
        }

        }

//Test cases #1
//Description:  users see the default repeat day as 1
//Environment: https://qa2.vytrack.com/user/login
//Steps:

//
//Test cases #2
//Description:  users clear the repeat day and see an error message
//Environment: https://qa2.vytrack.com/user/login
//Steps


