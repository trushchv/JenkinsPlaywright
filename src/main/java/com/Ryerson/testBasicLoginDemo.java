package com.Ryerson;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import com.google.gson.JsonObject;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;

public class testBasicLoginDemo {

        public static void main(String[] args) throws UnsupportedEncodingException {
            JsonObject capabilities = new JsonObject();
            JsonObject ltOptions = new JsonObject();

            String user = "vtrushch";
            String accessKey = "VrJ4oNi9ePewUVxIsFlLgiDhmtvdYrhQz1JmdEczBejZd4M4vx";

            capabilities.addProperty("browsername", "Chrome"); // Browsers allowed: `Chrome`, `MicrosoftEdge`,
            // `pw-chromium`, `pw-firefox` and `pw-webkit`
            capabilities.addProperty("browserVersion", "latest");
            ltOptions.addProperty("platform", "Windows 10");
            ltOptions.addProperty("name", "Playwright Test");
            ltOptions.addProperty("build", "Playwright Java Build 2");
            ltOptions.addProperty("user", user);
            ltOptions.addProperty("accessKey", accessKey);
            capabilities.add("LT:Options", ltOptions);

            // Playwright test
            Playwright playwright = Playwright.create();
            BrowserType chromium = playwright.chromium();
            String caps = URLEncoder.encode(capabilities.toString(), "utf-8");
            String cdpUrl = "wss://cdp.lambdatest.com/playwright?capabilities=" + caps;
            Browser browser = chromium.connect(cdpUrl);
            Page page = browser.newPage();
            page.navigate("https://illuminator-test.mendixcloud.com/index.html");

            Page page6 = page.waitForPopup(() -> page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("ryerson.com")).click());
            page.waitForTimeout(8000);
            page6.close();

            Locator sendEmail = page.locator("(//img[@role='button'])[3]");
            System.out.println("sendEmail.isVisible() = " + sendEmail.isVisible());

            page.locator("(//img[contains(@class,'mx-image mx-name-staticImage3')])[1]").click();
            System.out.println("Pop up message = " + page.locator("//h4[contains(@class,'mx-text mx-name-text24')]").textContent());
            System.out.println("Second row = " + page.locator("//h2[contains(@class,'mx-text mx-name-text25')]").textContent());
            page.locator("//button[@aria-label='close']").click();

            System.out.println("First row text = " + page.locator("//h3[contains(@class,'mx-text mx-name-text1')]").textContent());

            page.locator("//img[contains(@class,'mx-image mx-name-staticImage5')]").click();
            System.out.println("About the app pop up = " + page.locator("//div[contains(@class,'mx-name-container4 spacing-outer-bottom-large')]//span[1]").textContent());

            Locator firstButton = page.locator("//img[contains(@class,'mx-image mx-name-staticImage1')]");
            System.out.println("Run a supply chain scenario button is enabled = " + firstButton.isEnabled());

            Locator secondButton = page.locator("(//img[contains(@class,'mx-image mx-name-staticImage2')])[3]");
            System.out.println("Learn more about the app button is enabled = " + secondButton.isEnabled());

            Locator thirdButton = page.locator("//span[text()='www.ryerson.com']");
            System.out.println("Third button text = " + thirdButton.textContent());
            System.out.println("Third button is enable = " + thirdButton.isEnabled());

            page.locator("//button[@aria-label='close']").click();

            Page page1 = page.waitForPopup(() -> page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Privacy Policy /")).click());
            page.waitForTimeout(3000);
            page1.close();

            Page page2 = page.waitForPopup(() -> page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("California Consumer Privacy Act /")).click());
            page2.close();


            browser.close();
            playwright.close();
        }

        public static void setTestStatus(String status, String remark, Page page) {
            page.evaluate("_ => {}",
                    "lambdatest_action: { \"action\": \"setTestStatus\", \"arguments\": { \"status\": \"" + status
                            + "\", \"remark\": \"" + remark + "\"}}");
        }
    }

