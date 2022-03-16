package com.vytrack.tests.base;

import com.vytrack.Pages.DescriptionPage_CihadSahin;
import com.vytrack.Pages.VyTrackLoginPage_CihadSahin;
import com.vytrack.utilities.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class TestBaseCihadSahin {
    protected VyTrackLoginPage_CihadSahin loginPage;
    protected DescriptionPage_CihadSahin descriptionPage;

    @BeforeMethod
    public void setUp() {
//        Driver.getDriver().get(ConfigurationReader.getProperty("env1"));
        loginPage=new VyTrackLoginPage_CihadSahin();
        descriptionPage=new DescriptionPage_CihadSahin();
    }

    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }

}
