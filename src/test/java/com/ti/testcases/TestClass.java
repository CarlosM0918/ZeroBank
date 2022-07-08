package com.ti.testcases;

import org.testng.annotations.Test;
import sun.awt.windows.ThemeReader;

public class TestClass extends BaseTestClass {
    @Test(priority = 1 )
    void verifyHomeNavigation() {
        mainPage.clickHome().VerifyNavbar();
    }
    @Test(priority = 2 )
    void verifyOnlineBankingNavigation(){
        mainPage.clickOnLineBanking().VerifyNavbar();
    }
    @Test(priority = 3 )
    void verifyFeedbackNavigation() {
        mainPage.clickFeedback().VerifyNavbar();
    }

    @Test(priority = 5 )
    void validateEmptyInputs(){
        feedbackPage.home().clickFeedback();
        feedbackPage.submitForm();
    }

    @Test(priority = 6 )
    void validInputs() {
        feedbackPage.home().clickFeedback();
        feedbackPage.fillForm(inputData.get("name"),inputData.get("email"),inputData.get("subject"), inputData.get("comment")).submitForm();
    }

    @Test(priority = 4 )
    void clearInputs() {
        feedbackPage.home().clickFeedback();
        feedbackPage.fillForm(inputData.get("name"),inputData.get("email"),inputData.get("subject"), inputData.get("comment")).clearForm();
    }

    @Test(priority = 6 )
    void invalidEmail() {
        feedbackPage.home().clickFeedback();
        feedbackPage.fillForm(inputData.get("name"),inputData.get("invalidEmail"),inputData.get("subject"), inputData.get("comment")).submitForm();
    }

    @Test(priority = 6 )
    void specialCharacters() throws InterruptedException {
        feedbackPage.home().clickFeedback();
        feedbackPage.fillForm(inputData.get("specialCharacters"),inputData.get("specialCharacters"),inputData.get("specialCharacters"), inputData.get("specialCharacters")).submitForm();
    }

    @Test(priority = 6 )
    void blankSpaces() {
        feedbackPage.home().clickFeedback();
        feedbackPage.fillForm(inputData.get("blankSpace"),inputData.get("blankSpace"),inputData.get("blankSpace"), inputData.get("blankSpace")).submitForm();
    }
}
