package com.ti.pages;

import com.ti.base.DriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class MainPage {
    WebDriver driver = DriverFactory.getInstance().getDriver();
    public JavascriptExecutor js;

    @FindBy(css = ".navbar")    
    private WebElement navbar;
    @FindBy(css = "#homeMenu")
    private WebElement tabHomeMenu;
    @FindBy(css = "#onlineBankingMenu")
    private WebElement tabOnlineBankingMenu;
    @FindBy(css = "#feedback")
    private WebElement tabFeedback;

    @FindBy(css = ".brand")
    private WebElement btnBrand;


    public MainPage(){
		PageFactory.initElements(driver, this);
    }

    public  MainPage home(){
        btnBrand.click();
        return this;
    }
    public  MainPage clickHome(){
        tabHomeMenu.click();
        return this;
    }

    public  MainPage clickOnLineBanking(){
        tabOnlineBankingMenu.click();
        return this;
    }
    public  MainPage clickFeedback(){
        new WebDriverWait(driver, Duration.ofSeconds(8)).until(ExpectedConditions.elementToBeClickable(tabFeedback));
        tabFeedback.click();
        return this;
    }

    public MainPage VerifyNavbar(){
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(navbar));
		Assert.assertTrue(navbar.isDisplayed());
        return this;
    }

}
