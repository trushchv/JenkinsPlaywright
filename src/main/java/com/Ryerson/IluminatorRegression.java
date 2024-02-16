//package com.Ryerson;
//
//import com.google.gson.JsonObject;
//import com.microsoft.playwright.*;
//import org.junit.jupiter.api.*;
//import java.io.UnsupportedEncodingException;
//import java.net.URLEncoder;
//
//public class IluminatorRegression {
//
//        static Playwright playwright;
//        static Browser browser;
//
//        BrowserContext context;
//        Page page;
//
//        @BeforeAll
//        static  void launchBrowser() {
//                playwright = Playwright.create();
//                browser = playwright.chromium().launch(
//                        new BrowserType.LaunchOptions().setHeadless(false)
//                );
//        }
//
//
//        @AfterAll
//        static void closeBrowser() {
//                playwright.close();
//        }
//
//        @BeforeEach
//        void createContextAndPage() {
//                context = browser.newContext();
//                page = context.newPage();
//                page.navigate("https://dev-orderaware.ryerson.com/");
////        page.navigate("https://orderaware.ryerson.com/");
////        page.navigate("https://orderaware.ryerson.com/");
//
//        }
//
//        @AfterEach
//        void closeContext() {
//                context.close();
//        }
//
//        @Test
//        void MPB_1879() {
//                System.out.println("--------------MPB-1879--------------");
//                Locator feedback = page.locator("//button[@data-testid='feedback']");
//                feedback.click();
//
//                Locator shareFeedback = page.locator("//h4[text()='Share Feedback']");
//                Locator text1 = page.locator("//h4[@class='mxfeedback-dialog__title']/following-sibling::p[1]");
//                Locator text2 = page.locator("//label[text()='Subject']");
//
//                Locator subjectPole = page.locator("//input[@data-testid='title']");
//                Locator description = page.locator("//label[text()='Description']");
//                Locator descriptionPole = page.locator("//textarea[contains(@class,'form-control mx-textarea-input')]");
//                Locator text3 = page.locator("mxfeedback_feedback_description_input");
//
//                System.out.println("Text in Feedback:");
//
//                System.out.println(shareFeedback.textContent());
//                System.out.println(text1.textContent());
//                System.out.println(text2.textContent());
//                System.out.println("Action - Fill Subject pole");
//
//                subjectPole.fill("test");
//                System.out.println(description.textContent());
//
//                descriptionPole.fill("test");
//                System.out.println("Action - Fill Desciption pole");
//                System.out.println(text2.textContent());
//                System.out.println("");
//                System.out.println("Visible buttons:");
//                System.out.println("Enter Screenshot Mode");
//                System.out.println("Upload From Computer");
//                System.out.println("Cancel");
//                System.out.println("Submit Feedback");
//
//        }}
