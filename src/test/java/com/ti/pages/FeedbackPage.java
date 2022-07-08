package com.ti.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class FeedbackPage extends MainPage {
    private SoftAssert softAssert;
    private String currentURL;
    private String changedURL;

    @FindBy(css = "input[value='Send Message']")
    private WebElement btnSendMessage;
    @FindBy(css = ".top_offset")
    private WebElement messageSent;
    @FindBy(css = "input[type=reset]")
    private WebElement btnClear;

    @FindBy(css = "#name")
    private WebElement txtName;
    @FindBy(css = "#email")
    private WebElement txtEmail;
    @FindBy(css = "#subject")
    private WebElement txtSubject;
    @FindBy(css = "#comment")
    private WebElement txtComment;

    public FeedbackPage submitForm(){
        softAssert = new SoftAssert();
        currentURL = driver.getCurrentUrl();
        btnSendMessage.click();
        changedURL = driver.getCurrentUrl();
        softAssert.assertFalse(currentURL.equals(changedURL), "The message was not sent");
        softAssert.assertAll();
        return this;
    }

    public FeedbackPage clearForm(){
        btnClear.click();
        return this;
    }

    public FeedbackPage fillForm(String ... data){
        txtName.clear();
        txtName.sendKeys(data[0]); //fill name

        txtEmail.clear();
        txtEmail.sendKeys(data[1]); //fill email

        txtSubject.clear();
        txtSubject.sendKeys(data[2]); //fill subject

        txtComment.clear();
        txtComment.sendKeys(data[3]); //fill comment

        return this;
    }

}
