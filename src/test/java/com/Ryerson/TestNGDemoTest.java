package com.Ryerson;

import com.google.gson.JsonObject;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.testng.annotations.Test;

import com.Ryerson.Driver;
import com.Ryerson.PlaywrightConnection;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class TestNGDemoTest extends PlaywrightConnection{

    @Test
    public void testPlaywrightDemo() throws UnsupportedEncodingException {
        JsonObject capabilities = new JsonObject();
        JsonObject ltOptions = new JsonObject();

        String user = "vtrushch";
        String accessKey = "VrJ4oNi9ePewUVxIsFlLgiDhmtvdYrhQz1JmdEczBejZd4M4vx";

        capabilities.addProperty("browsername", "Chrome");
        capabilities.addProperty("browserVersion", "latest");
        ltOptions.addProperty("platform", "Windows 10");
        ltOptions.addProperty("name", "Playwright Test");
        ltOptions.addProperty("build", "Playwright Java Build 2");
        ltOptions.addProperty("user", user);
        ltOptions.addProperty("accessKey", accessKey);
        capabilities.add("LT:Options", ltOptions);

        Playwright playwright = Playwright.create();
        BrowserType chromium = playwright.chromium();
        String caps = URLEncoder.encode(capabilities.toString(), "utf-8");
        String cdpUrl = "wss://cdp.lambdatest.com/playwright?capabilities=" + caps;
        Browser browser = chromium.connect(cdpUrl);
        Page page = browser.newPage();
        try {
            page.navigate("https://illuminator-test.mendixcloud.com/index.html");
            page.waitForTimeout(10000);
            String title = page.title();

            if (title.equals("Illuminator - Enter Scenario")) {
                setTestStatus("passed", "Title matched", page);
            } else {
                setTestStatus("failed", "Title not matched", page);
            }

            Page page6 = page.waitForPopup(() -> page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("ryerson.com")).click());
            page.waitForTimeout(8000);
            page6.close();

            // Rest of your test logic here...

        } catch (Exception err) {
            setTestStatus("failed", err.getMessage(), page);
            err.printStackTrace();
        } finally {
            browser.close();
            playwright.close();
        }
    }

    public void setTestStatus(String status, String remark, Page page) {
        page.evaluate("_ => {}",
                "lambdatest_action: { \"action\": \"setTestStatus\", \"arguments\": { \"status\": \"" + status
                        + "\", \"remark\": \"" + remark + "\"}}");
    }
}