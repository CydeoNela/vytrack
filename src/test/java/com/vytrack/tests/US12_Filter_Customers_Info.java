package com.vytrack.tests;


import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VytrackUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class US12_Filter_Customers_Info {


    @DataProvider(name="filters")
    public Object[][] dpMethod(){

        List<String> expectedFilters = Arrays.asList("Account Name","Contact Name","Contact Email","Contact Phone",
                "Owner","Business Unit","Created At","Updated At");

        Object[][] objData = new Object[1][1];
        objData[0][0]= expectedFilters;

        return objData;
    }



    @Test(dataProvider = "filters")
    public void account_page_costumer_info(List<String> expectedFilters){

        //log in
        VytrackUtils.loginAsStoreManger();

        //wait for loader to disappear
        // VytrackUtils.waitTillLoaderMaskDisappear(); - needs to be added in utils methods -> implicit wait method

        //locate Customer tab
        WebElement customers= Driver.getDriver().findElement(By.xpath("(//li[@class='dropdown dropdown-level-1'])[2]"));

        //move the mouse on customer tab - not clickable element
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(customers).perform();

        //locate and click on Accounts
        Driver.getDriver().findElement(By.xpath("//span[.='Accounts']")).click();

        //locate and click on Filters - this will display all filters
        Driver.getDriver().findElement(By.xpath("//a[@title='Filters']")).click();

        //store all filter names in a list
        List<WebElement> filters = Driver.getDriver().findElements(By.xpath("//div[@class='filter-item oro-drop']"));

     /*   Actual filter names we got in the list: Account Name: All, Contact Name: All, Contact Email: All, Contact Phone: All, Owner: All,
                                             Business Unit: All, Created At: All, Updated At: All
*/

        //Expected names: Account Name, Contact Name, Contact Email, Contact Phone, Owner,  Business Unit, Created At, Updated At

        //Actual and expected do not match, we will use the loop to split word "All" from filter names and get it to match
        //it's impossible to get filter names without printing "ALL" included, so we have to split:
        for (int i = 0; i < expectedFilters.size(); i++) {
            System.out.println(filters.get(i).getText());
            String[] filter= filters.get(i).getText().split(":");
            String actualFilter = filter[0].toString();
            assertEquals(actualFilter,expectedFilters.get(i));
        }


    }




}
