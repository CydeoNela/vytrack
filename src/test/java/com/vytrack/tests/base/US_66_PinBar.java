package com.vytrack.tests.base;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VytrackUtils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.List;

public class US_66_PinBar extends TestBase {


    public WebDriver driver;

    @Test(priority = 1)
    public void Login_As_Driver() throws InterruptedException {

        VytrackUtils.loginAsDriver();
        System.out.println("currentUrl -->> " + Driver.getDriver().getCurrentUrl());
        BrowserUtils.sleep(2);
        String ActualTitle = Driver.getDriver().getTitle();
        Thread.sleep(3000);
        String ExpectedTitle = "Dashboard";

        Assert.assertEquals(ActualTitle, ExpectedTitle);
        System.out.println("ActualTitle = " + ActualTitle);
        System.out.println("ExpectedTitle --> " + ExpectedTitle);

    }

    @Test(priority = 2)
    public void verifyText() throws InterruptedException {

        VytrackUtils.loginAsDriver();
        Thread.sleep(3000);
        Driver.getDriver().findElement(By.xpath("//*[@id=\"pinbar\"]/div[1]/div/a")).click();

        //
        //find pinbar “How To Use Pinbar”
        String actualText = Driver.getDriver().findElement(By.xpath("//*[@id=\"container\"]/div[2]/div/h3")).getText();
        Thread.sleep(3000);
        String expectedText = "How To Use Pinbar";

        Assert.assertEquals(actualText, expectedText);
        System.out.println("actualText = " + actualText);
        System.out.println("expectedText = " + expectedText);


    }

    @Test(priority = 3)
    public void verifyText2() throws InterruptedException {
        VytrackUtils.loginAsDriver();

        Driver.getDriver().findElement(By.xpath("//*[@id=\"pinbar\"]/div[1]/div/a")).click();
        Thread.sleep(3000);

        //“Use pin icon on the right top corner of the page to create fast access link in the pinbar.”
        String actualText1 = Driver.getDriver().findElement(By.xpath("//*[@id=\"container\"]/div[2]/div/p[1]")).getText();

        String expectedText1 = "Use pin icon on the right top corner of page to create fast access link in the pinbar.";
        System.out.println("actualText1 = " + actualText1);
        System.out.println("expectedText1 = " + expectedText1);
        Assert.assertEquals(actualText1, expectedText1);

    }

    @Test(priority = 4)
    public void verifyPicture() throws InterruptedException {
        VytrackUtils.loginAsDriver();
        Driver.getDriver().findElement(By.xpath("//*[@id=\"pinbar\"]/div[1]/div/a")).click();
        //verify the  image source  is displayed or not
        WebElement picVerify = Driver.getDriver().findElement(By.cssSelector("#container > div.container-fluid > div > p:nth-child(3) > img"));
        Thread.sleep(3000);
        if (picVerify.isDisplayed()) {
            System.out.println("Image is displayed");
            System.out.println("The image show how to use pinbar" + picVerify.getAttribute("alt"));//get alternative text
        } else
            System.out.println("Image is not displayed");

        // just verify the image source.
        //Expected source: bundles/oronavigation/images/pinbar-location.jpg
        String imageVerify = picVerify.getAttribute("src");
        String expectedImage = "https://qa1.vytrack.com/bundles/oronavigation/images/pinbar-location.jpg";
        Assert.assertEquals(imageVerify, expectedImage);

        System.out.println("pic is Enabled -->>" + picVerify.isEnabled());
        System.out.println("pic Size -->> " + picVerify.getSize());
    }


    @Test(priority = 5)
    public void imageTest() throws IOException {
        VytrackUtils.loginAsDriver();
        Driver.getDriver().findElement(By.xpath("//*[@id=\"pinbar\"]/div[1]/div/a")).click();
        //  looking src in side to img
        //attribute src , <img> tagname
        List<WebElement> list = Driver.getDriver().findElements(By.tagName("img"));

        int count = 1;
        for (WebElement element : list) {
            // to get the src attribute, we have to write getAttribute("src").
            String src = element.getAttribute("src");
            //Read from URL
            URL imageURL = new URL(src);

            //read image from given web Url. ColorModel
            BufferedImage saveImage = ImageIO.read(imageURL);

            //writing the image on disk
            ImageIO.write(saveImage, "jpg", new File(count + "EnesShot.jpg"));
            count++;
        }
    }

    @DataProvider(name = "IncorrectEntry")
    public Object[][] provideLoginCredential() {
        return new Object[][]{
                {"incorrect", "UserUser"}, {"", "useruser"},
                {"incorrect2", "32"}, {"fenerbahce@cydeo.", "uuser"},
                {"", "Usercybertek2"}, {"ar.com", ""},
                {"woodenspoon", "Userser3"}, {"arkacydeo.com", "useruser"},
        };
    }

    @Test(priority = 6, dataProvider = "IncorrectEntry")
    public void verificationIncorrectUsername(String username, String password) throws IOException {
        Driver.getDriver().get("https://qa1.vytrack.com");
        Driver.getDriver().findElement(By.cssSelector("input[id='prependedInput']")).sendKeys("username");

        Driver.getDriver().findElement(By.cssSelector("input[id='prependedInput2']")).sendKeys("password");

        Driver.getDriver().findElement(By.cssSelector("#_submit")).click();

        String actualTitle = Driver.getDriver().findElement(By.xpath("//*[@id=\"login-form\"]/fieldset/div[1]/div")).getText();

        String expectedTitle = "Incorrect login or password";

        //Assert.assertEquals(actualTitle,expectedTitle);

        // Print_CurrentDate_Time_ScreenShot
        Date currentdate = new Date();
        System.out.println("currentdate = " + currentdate);
        String screenshotfilename = currentdate.toString()
                .replace(" ", "-")
                .replace(":", "-");

        TakesScreenshot pic2 = (TakesScreenshot) Driver.getDriver();

        File file = pic2.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File(".//screenshot/" + screenshotfilename + "Enes1.png"));

    }

    }
