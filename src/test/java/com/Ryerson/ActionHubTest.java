package com.Ryerson;

import com.microsoft.playwright.*;
import org.testng.annotations.*;

public class ActionHubTest {

    static Playwright playwright;
    static Browser browser;

    static BrowserContext context;
    static Page page;

    @BeforeSuite
    static void launchBrowser() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        context = browser.newContext();
        page = context.newPage();
    }

    @AfterSuite
    static void closeBrowser() {
        browser.close();
        playwright.close();
    }

    @BeforeMethod
    void createContextAndPage() {
        context = browser.newContext();
        page = context.newPage();
        page.navigate("https://actionhub100-test.mendixcloud.com/login.html");
    }

    @AfterMethod
    void closeContext() {
        context.close();
    }

    @Test
    void MPB_1855() {
        System.out.println("--------------MPB-1855--------------");
        page.locator("//input[@placeholder='User name']").fill("IT_Reviewer");
        page.locator("//input[@placeholder='Password']").fill("TestPass1234!");
        page.locator("//button[text()='Sign in']").click();

        Locator feedback = page.locator("//button[@data-testid='feedback']");
        feedback.click();

        Locator shareFeedback = page.locator("//h4[text()='Share Feedback']");
        Locator text1 = page.locator("//h4[@class='mxfeedback-dialog__title']/following-sibling::p[1]");
        Locator text2 = page.locator("//label[text()='Subject']");

        Locator subjectPole = page.locator("//input[@data-testid='title']");
        Locator description = page.locator("//label[text()='Description']");
        Locator descriptionPole = page.locator("(//textarea[contains(@class,'form-control mx-textarea-input')])[1]");
        Locator text3 = page.locator("mxfeedback_feedback_description_input");

        System.out.println("Text in Feedback:");
        System.out.println(shareFeedback.textContent());
        System.out.println(text1.textContent());
        System.out.println(text2.textContent());
        System.out.println("Action - Fill Subject pole");

        subjectPole.fill("test");
        System.out.println(description.textContent());

        descriptionPole.fill("test");
        System.out.println("Action - Fill Desciption pole");
        System.out.println(text2.textContent());
        System.out.println("");
        System.out.println("Visible buttons:");
        System.out.println("Enter Screenshot Mode");
        System.out.println("Upload From Computer");
        System.out.println("Cancel");
        System.out.println("Submit Feedback");
        page.waitForTimeout(2000);
    }
}
