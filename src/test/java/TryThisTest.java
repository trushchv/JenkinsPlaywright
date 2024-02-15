import com.google.gson.JsonObject;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class TryThisTest {


    public static void main(String[] args) throws UnsupportedEncodingException {
        JsonObject capabilities = new JsonObject();
        JsonObject ltOptions = new JsonObject();



            String user = "vtrushch";
                String accessKey = "VrJ4oNi9ePewUVxIsFlLgiDhmtvdYrhQz1JmdEczBejZd4M4vx";

                capabilities.addProperty("browserName", "chrome");
                capabilities.addProperty("browserVersion", "latest");
                ltOptions.addProperty("platform", "Windows 10");
                ltOptions.addProperty("name", "Playwright Test");
                ltOptions.addProperty("build", "Playwright Java Build 2");
                ltOptions.addProperty("user", user);
                ltOptions.addProperty("accessKey", accessKey);
                capabilities.add("LT:Options", ltOptions);

                try (Playwright playwright = Playwright.create()) {
                        BrowserType chromium = playwright.chromium();
                        String caps = URLEncoder.encode(capabilities.toString(), "utf-8");
                        String cdpUrl = "wss://cdp.lambdatest.com/playwright?capabilities=" + caps;
                        try (Browser browser = chromium.connect(cdpUrl)) {
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

                        Download download = page.waitForDownload(() -> page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("California's Transparency in Supply Chains Act /")).click());

                        Page page3 = page.waitForPopup(() -> page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Security Statement /")).click());
                        page.waitForTimeout(3000);
                        page3.close();

                        Download download1 = page.waitForDownload(() -> page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Terms and Conditions")).click());

                        page.locator("//img[contains(@class,'mx-image mx-name-staticImage7')]").click();
                        System.out.println("Information message  = " + page.locator("//p[text()='Please enter a zip code before selecting a material and shape']").textContent());
                        page.locator("//button[@title='OK']").click();

                        page.locator("(//input[@class='form-control'])[1]").fill("60532");
                        page.locator("//div[contains(@class,'mx-name-container226 nextStepOrangeButton')]").click();

                        Locator steel = page.locator("(//span[text()='Steel'])[1]");
                        System.out.println("List of material = " + steel.textContent());
                        System.out.println(page.locator("(//span[text()='Stainless'])[1]").textContent());
                        System.out.println(page.locator("(//span[text()='Aluminum'])[1]").textContent());

                        System.out.println("List of Shape = " + page.locator("(//span[text()='Sheet'])[1]").textContent());
                        System.out.println(page.locator("(//span[text()='Plate'])[1]").textContent());
                        System.out.println(page.locator("(//span[text()='Long'])[1]").textContent());

                        page.locator("(//div[@role='button']//div)[1]").click();
                        page.locator("//div[@class='mx-name-container251 radioButtonActive']").click();
                        page.locator("//span[contains(@class,'mx-text mx-name-text97')]").click();

                        page.locator("(//input[@class='form-control'])[1]").fill("50000");
                        page.locator("//span[contains(@class,'mx-text mx-name-text117')]").click();

                        System.out.println("Select button = " + page.locator("//span[text()='Select the Closest Mill']").textContent());
                        System.out.println("Select button = " + page.locator("//span[text()='Search Mill by Name']").textContent());
                        page.locator("//span[text()='Select the Closest Mill']").click();

                        page.locator("(//span[contains(@class,'mx-text mx-name-text133')])[1]").click();

                        System.out.println("First = " + page.locator("//span[@class='mx-text mx-name-text153']").textContent());
                        System.out.println("Second = " + page.locator("//span[@class='mx-text mx-name-text156']").textContent());

                        page.locator("//img[contains(@class,'mx-image mx-name-staticImage67')]").click();
                        page.waitForTimeout(4000);

                        page.locator("(//span[text()='See Results'])[1]").click();

                        page.locator("//img[contains(@class,'mx-image mx-name-staticImage73')]").click();

                        page.locator("//span[contains(@class,'mx-text mx-name-text19')]").click();
                        page.waitForTimeout(2000);

                        page.locator("//button[@aria-label='close']").click();

                        System.out.println("Name of the button = " + page.locator("//span[text()='Download and Share']").textContent());
                        page.locator("//span[text()='Download and Share']").click();

                        page.locator("//input[@placeholder='Enter an email address']").first().fill("vitalii.trushchenkov@ryerson.com");
                        page.locator("//textarea[contains(@class,'form-control mx-textarea-input')]").fill("test");

                        page.locator("//div[contains(@class,'mx-name-container10 spacing-outer-top-medium')]//img[1]").click();
                        System.out.println("Title = " + page.locator("//h4[text()='Add New Recipient']").textContent());
                        page.locator("(//button[contains(@class,'btn mx-button')])[2]").click();

                        page.waitForTimeout(2000);
                        page.locator("//div[contains(@class,'mx-name-container14 paddingBottomDownloadAndShare')]//img[1]").click();

                        page.locator("//button[@class='btn btn-primary']").click();

                        System.out.println("Shop the Ryerson Catalog is enabled = " + page.locator("//span[text()='Shop the Ryerson Catalog']").isEnabled());

                        page.locator("//a[text()='Clear Scenario(s) & Start Over']").click();
                        page.waitForTimeout(2000);

                }
        }}}