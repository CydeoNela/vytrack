package com.vytrack.tests;

import com.vytrack.tests.base.TestBase;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VytrackUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class US14_manageFilters extends TestBase {

    @Test
    public void verify_StoreManagers_see5Filters() {
        //1.User go to homepage
        VytrackUtils.loginAsStoreManger();

        //2.User click "Campaigns" under the Marketing
        WebElement StoreManager = Driver.getDriver().findElement(By.xpath("(//span[@class='title title-level-1'])[6]"));
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(StoreManager).pause(6).perform();

        WebElement campaignsStoreManager = Driver.getDriver().findElement(By.xpath("//li[@data-route='oro_campaign_index']"));
        campaignsStoreManager.click();

        //3. User click on "Filter" button
        WebElement filterButtonStore = Driver.getDriver().findElement(By.xpath("//i[@class='fa-filter hide-text']"));
        filterButtonStore.click();

        //4. User clicks on "Manage filters"
        WebElement manageFilterStore = Driver.getDriver().findElement(By.xpath("//a[@class='add-filter-button']"));
        manageFilterStore.click();

        //5. User sees 5 filters on the page
        List<WebElement> filters_5Store = Driver.getDriver().findElements(By.xpath("//ul[@class='ui-multiselect-checkboxes ui-helper-reset fixed-li']"));
        List<String> actualFilters_5Store = new ArrayList<>();
        filters_5Store.forEach(k -> actualFilters_5Store.add(k.getText()));
        List<String> expectedFilters_5Store = new ArrayList<>(Arrays.asList(
                "Name\n" +
                        "Code\n" +
                        "Start Date\n" +
                        "End Date\n" +
                        "Budget"));

        Assert.assertEquals(actualFilters_5Store, expectedFilters_5Store);
        //6. User sees if the checkBoxes are selected by default
        List<WebElement> allCheckBoxesStore = Driver.getDriver().findElements(By.xpath("//input[@name='multiselect_0']"));

        allCheckBoxesStore.forEach(p -> Assert.assertTrue(p.isSelected()));
        //7.   User verify one or more options unchecked

        for (int i = 0; i < 5; i++) {
            WebElement eachBox = Driver.getDriver().findElement(By.xpath(String.format("//input[@id='ui-multiselect-0-0-option-" + i + "']")));
            eachBox.click();
            BrowserUtils.sleep(2);
        }
        List<WebElement> allCheckBoxes = Driver.getDriver().findElements(By.xpath("//ul[@class='ui-multiselect-checkboxes ui-helper-reset fixed-li']"));
        allCheckBoxes.forEach(p -> Assert.assertTrue(!(p.isSelected())));

    }


   @Test
    public void verify_SalesManagers_see5Filters() {
        //1.User go to homepage
        VytrackUtils.loginAsSalesManager();

        //2.User click "Campaigns" under the Marketing
        WebElement StoreManager = Driver.getDriver().findElement(By.xpath("(//span[@class='title title-level-1'])[6]"));
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(StoreManager).pause(6).perform();

        WebElement campaignsStoreManager = Driver.getDriver().findElement(By.xpath("//li[@data-route='oro_campaign_index']"));
        campaignsStoreManager.click();

        //3. User click on "Filter" button
        WebElement filterButtonStore = Driver.getDriver().findElement(By.xpath("//i[@class='fa-filter hide-text']"));
        filterButtonStore.click();

        //4. User click on "Manage filters"
        WebElement manageFilterStore = Driver.getDriver().findElement(By.xpath("//a[@class='add-filter-button']"));
        manageFilterStore.click();

        //5.User see 5 filters on the page
        List<WebElement> filters_5Store = Driver.getDriver().findElements(By.xpath("//ul[@class='ui-multiselect-checkboxes ui-helper-reset fixed-li']"));
        List<String> actualFilters_5Store = new ArrayList<>();
        filters_5Store.forEach(k -> actualFilters_5Store.add(k.getText()));
        List<String> expectedFilters_5Store = new ArrayList<>(Arrays.asList(
                "Name\n" +
                        "Code\n" +
                        "Start Date\n" +
                        "End Date\n" +
                        "Budget"));

        Assert.assertEquals(actualFilters_5Store, expectedFilters_5Store);
//6.   User see if the checkBoxes are selected by default
        List<WebElement> allCheckBoxesStore = Driver.getDriver().findElements(By.xpath("//input[@name='multiselect_0']"));

        allCheckBoxesStore.forEach(p -> Assert.assertTrue(p.isSelected()));


        //7.   User verify one or more options unchecked
        for (int i = 0; i < 6; i++) {
            WebElement eachBox = Driver.getDriver().findElement(By.xpath(String.format("//input[@id='ui-multiselect-0-0-option-" + i + "']")));
            eachBox.click();

            //    Assert.assertTrue(!(eachBox.isSelected()));
        }


    }


}


