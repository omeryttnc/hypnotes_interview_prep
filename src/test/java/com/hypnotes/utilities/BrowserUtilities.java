package com.hypnotes.utilities;

import com.github.javafaker.Faker;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.SessionStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import javax.annotation.Nullable;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.hypnotes.stepDefinitions.UIStepDef.Hooks.*;
import static io.restassured.RestAssured.given;


public class BrowserUtilities {

    @Nullable
    public static void writeDataToIdsFile(String tip, String id) { // room=123123
        try (OutputStream output = new FileOutputStream("ids.properties")) {
            Properties prop = new Properties();
            prop.setProperty(tip, id);
            prop.store(output, null);
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    @Nullable
    public static String readDataFromIdsFile(String tip) { // room
        try (InputStream input = new FileInputStream("ids.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            return prop.getProperty(tip);
        } catch (IOException ex) {
            return null;
        }
    }

    public static WebElement waitForVisibility(WebElement element, int timeToWaitInSec) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeToWaitInSec));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement waitForVisibility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForClickability(WebElement element, int timeout) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static WebElement waitForClickability_withoutScroll(WebElement element) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static WebElement waitForClickability(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void waitForPageToLoad(long timeOutInSeconds) {
        ExpectedCondition<Boolean> expectation = driver -> {
            assert driver != null;
            return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
        };
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeOutInSeconds));
            wait.until(expectation);
        } catch (Throwable error) {
            error.printStackTrace();
        }
    }

    public static void verifyElementDisplayed(By by) {
        try {
            Assert.assertTrue("Element is not visible: " + by, Driver.getDriver().findElement(by).isDisplayed());
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            Assert.fail("Element is not found: " + by);
        }
    }

    public static void goToHomePage() {
        BrowserUtilities.wait(2);
        driver.findElement(By.cssSelector(".react-header-logo")).click();

        BrowserUtilities.wait(2);
    }

    public static void verifyElementDisplayed(WebElement element) {
        try {
            Assert.assertTrue("Element is not visible: " + element, element.isDisplayed());
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            Assert.fail("Element not found: " + element);
        }
    }

    public static void verifyElementDisplayedWithJS(WebElement element) {
        try {
            ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
            Assert.assertTrue("Element is not visible: " + element, element.isDisplayed());
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            Assert.fail("Element not found: " + element);
        }
    }

    public static void verifyElementNotDisplayed(By by) {
        try {
            Assert.assertFalse("Element should not be visible: " + by, Driver.getDriver().findElement(by).isDisplayed());
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }

    public static void verifyElementClickable(WebElement element) {
        try {
            ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
            Assert.assertTrue("Element is not visible: " + element, element.isEnabled());
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            Assert.fail("Element not found: " + element);
        }
    }

    public static void verifyElementEnabled(WebElement element) {
        try {
            ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
            Assert.assertTrue("Element is not enabled: " + element, element.isEnabled());
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            Assert.fail("Element is not found: " + element);
        }
    }

    public static void verifyElementEnabled(By by) {
        try {
            Assert.assertTrue("Element is not enabled: " + by, Driver.getDriver().findElement(by).isDisplayed());
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            Assert.fail("Element is not enabled: " + by);
        }
    }

    public static void clickWithJS(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", element);
    }

    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        BrowserUtilities.waitForVisibility(element, 10);
    }


    public static void switchToWindow(String targetTitle) {
        String origin = Driver.getDriver().getWindowHandle();
        for (String handle : Driver.getDriver().getWindowHandles()) {
            Driver.getDriver().switchTo().window(handle);
            if (Driver.getDriver().getTitle().equals(targetTitle)) {
                return;
            }
        }
        Driver.getDriver().switchTo().window(origin);
    }

    //==========Return a list of string given a list of Web Element====////
    public static List<String> getElementsText(List<WebElement> list) {
        List<String> elemTexts = new ArrayList<>();
        for (WebElement el : list) {
            if (!el.getText().isEmpty()) {
                elemTexts.add(el.getText());
            }
        }
        return elemTexts;
    }

    //========Returns the Text of the element given an element locator==//
    public static List<String> getElementsByText(By locator) {
        List<WebElement> elements = Driver.getDriver().findElements(locator);
        List<String> elementTexts = new ArrayList<>();
        for (WebElement el : elements) {
            if (!el.getText().isEmpty()) {
                elementTexts.add(el.getText());
            }
        }
        return elementTexts;
    }

    public static List<String> getElementsText(By locator) {
        List<WebElement> elements = Driver.getDriver().findElements(locator);
        List<String> elemTexts = new ArrayList<>();
        for (WebElement el : elements) {
            elemTexts.add(el.getText());
        }
        return elemTexts;
    }

    public static String getSingleElementText(By locator) {

        return Driver.getDriver().findElement(locator).getText();
    }

    // randomly generate a name method**********************************
    public static String generateAName() {
        String alphabetWithLoverCases = "abcdefghijklmnopqrstuvwxyz";
        String alphabetWithUpperCases = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        Random rnd = new Random();
        StringBuilder name = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            name.append(alphabetWithLoverCases.charAt(rnd.nextInt(alphabetWithUpperCases.length())));
        }
        return name.toString();
    }

    // randomly generate an email method**********************************
    public static String generateAnEmail(Keys enter) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        Random rnd = new Random();
        StringBuilder email = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            email.append(alphabet.charAt(rnd.nextInt(alphabet.length())));
        }
//        return email + "test@gmail.com";
        return "test__" + email + "@mailsac.com";

    }

    // randomly generate an email method**********************************
    public static String generateAnEmail() {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        Random rnd = new Random();
        StringBuilder email = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            email.append(alphabet.charAt(rnd.nextInt(alphabet.length())));
        }
//        return email + "test@gmail.com";
        return "test__" + email + "@mailsac.com";

    }

    //*********Randomly Generate Password Method************************//
    public static String generateAPassword(int length) {
        String capitalCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String specialCharacters = "!@#$ºª%&/()=?^*:[ ],.-_+";
        String numbers = "1234567890";
        String combinedChars = capitalCaseLetters + lowerCaseLetters + specialCharacters + numbers;
        Random random = new Random();
        String password = "";

        password += "" + lowerCaseLetters.charAt(random.nextInt(lowerCaseLetters.length()));
        password += capitalCaseLetters.charAt(random.nextInt(capitalCaseLetters.length()));
        password += specialCharacters.charAt(random.nextInt(specialCharacters.length()));
        password += numbers.charAt(random.nextInt(numbers.length()));

        for (int i = 4; i < length; i++) {
            password += combinedChars.charAt(random.nextInt(combinedChars.length()));
        }
        return password;
    }

    public static void switchToWindowWithIndex(int index) {
        List<String> windowHandles = new ArrayList<>(Driver.getDriver().getWindowHandles());
        Driver.getDriver().switchTo().window(windowHandles.get(index));
    }

    public static void waitForPresenceOfLocatedElement(WebElement element, int timeOutInSecond) {
        //it seems OK but check it out. DataTableListMap.feature daki kodlari kullanabilirsin
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeOutInSecond));
        By locator = BrowserUtilities.getLocatorFromWebElement(element);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        // this method uses below method
    }

    private static By getLocatorFromWebElement(WebElement element) {
        //[[ChromeDriver: chrome on WINDOWS (421ef25173cc20ec4a7cd08cd2bef8b3)] -> xpath: //*[contains(text(), 'Video Conferencing - Telehealth')]]
        //**** works for css & xpath
        By by;
        //[[ChromeDriver: chrome on XP (d85e7e220b2ec51b7faf42210816285e)] -> xpath: //input[@title='Search']]
        String[] pathVariables = (element.toString().split("->")[1].replaceFirst("(?s)(.*)]", "$1" + "")).split(":");
        String selector = pathVariables[0].trim();
        String value = pathVariables[1].trim();
        switch (selector) {
            case "id":
                by = By.id(value);
                break;
            case "className":
                by = By.className(value);
                break;
            case "tagName":
                by = By.tagName(value);
                break;
            case "xpath":
                by = By.xpath(value);
                break;
            case "css selector": //cssSelector
                by = By.cssSelector(value);
                break;
            case "linkText":
                by = By.linkText(value);
                break;
            case "name":
                by = By.name(value);
                break;
            case "partialLinkText":
                by = By.partialLinkText(value);
                break;
            default:
                throw new IllegalStateException("locator : " + selector + " not found!!!");
        }
        return by;
    }

    public static void verifyVideoPlays(WebElement element) {
        //precondition: user clicks on YouTube video
        // can be added iframe section and clicks
        try {
            ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
            wait(1);
            String playTime = element.getAttribute("currentTime");
            if (Double.parseDouble(playTime) > 0) {
                Assert.assertTrue(true);
            } else {
                Assert.fail();
            }
        } catch (Exception ex) {
            Assert.fail("You didn't click on play button.");
        }
    }

    public static WebElement getElementFromGetText(String text) {
        By element = By.xpath("//*[contains(text(), '" + text + "')]");
        WebElement found;
        try {
            List<WebElement> elements = Driver.getDriver().findElements(element);
            found = Driver.getDriver().findElement(element);
            if (elements.size() != 1) {
                System.out.println(elements.size() + " element found. Check if the element is yours");
            }
            return found;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println("Element not found");
            return null;
        }
    }

    public static void sendKeysWithJS(WebElement element, String sendKeys) {
        Wait<WebDriver> wait = new FluentWait<>(Driver.getDriver()).
                withTimeout(Duration.ofSeconds(10)).
                pollingEvery(Duration.ofSeconds(2)).
                withMessage("My click method failed");
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].setAttribute('value', '" + sendKeys + "')", element);

    }

    public static void mySendKeysMethod(By locator, String sendText) {
        WebElement element = driver.findElement(locator);
        Wait<WebDriver> wait = new FluentWait<>(Driver.getDriver()).
                withTimeout(Duration.ofSeconds(10)).
                pollingEvery(Duration.ofSeconds(2)).
                withMessage("My click method failed");
        wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(sendText);
    }

    public static void mySendKeysMethod(WebElement webElement, String sendText) {
        Wait<WebDriver> wait = new FluentWait<>(Driver.getDriver()).
                withTimeout(Duration.ofSeconds(10)).
                pollingEvery(Duration.ofSeconds(2)).
                withMessage("My click method failed");
        wait.until(ExpectedConditions.visibilityOf(webElement)).sendKeys(sendText);
    }

    public static void myClickMethod(By locator) {

        WebElement element = Driver.getDriver().findElement(locator);

        Wait<WebDriver> wait = new FluentWait<>(Driver.getDriver()).
                withTimeout(Duration.ofSeconds(10)).
                pollingEvery(Duration.ofSeconds(2)).
                withMessage("My click method failed");

        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public static void scrollToBottom() {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("window.scrollBy(0,document.body.scrollHeight)");
        wait(2);

    }

    public static String getScreenshot(String name) throws IOException {
        // naming the screenshot with the current date to avoid duplication
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        // TakesScreenshot is an interface of selenium that takes the screenshot
        TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
        File source = ts.getScreenshotAs(OutputType.FILE);
        // full path to the screenshot location
        String target = System.getProperty("user.dir") + "/test-output/Screenshots/" + name + date + ".png";
        File finalDestination = new File(target);
        // save the screenshot to the path given
        FileUtils.copyFile(source, finalDestination);
        return target;
    }

    public static void scrollToView(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", element);
    }

    public static void hover(WebElement element) {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(element).perform();
    }

    //login for hypnotes
    public static void login(String username, String password) {
        Driver.getDriver().findElement(By.cssSelector("[href='/api/login']")).click();
        Driver.getDriver().findElement(By.xpath("//input[@type='email']")).sendKeys(username);
        Driver.getDriver().findElement(By.xpath("//input[@type='password']")).sendKeys(password);
        Driver.getDriver().findElement(By.xpath("//button[@type='submit']")).click();
    }

    //logout for hypnotes
    public static void logout() {
        wait(3);
        Driver.getDriver().findElement(By.xpath("//span[contains(text(),'Logout')]")).click();
    }

    //this method will clear text box
    public static void cleanTextInBox(WebElement element) {
        String inputText = element.getAttribute("value");
        if (inputText != null) {
            for (int i = 0; i < inputText.length(); i++) {
                element.sendKeys(Keys.BACK_SPACE);
            }
        }
        wait(1);
    }

    public static void waitAndClick(WebElement element, int timeout) {
        for (int i = 0; i < timeout; i++) {
            try {
                element.click();
                return;
            } catch (WebDriverException e) {
                wait(1);
            }
        }
    }

    public static void waitAndSendText(WebElement element, String text, int timeout) {
        for (int i = 0; i < timeout; i++) {
            try {
                element.sendKeys(text);
                return;
            } catch (WebDriverException e) {
                wait(1);
            }
        }
    }

    public static String waitAndGetText(WebElement element, int timeout) {
        String text;
        for (int i = 0; i < timeout; i++) {
            try {
                text = element.getText();
                return text;
            } catch (WebDriverException e) {
                wait(1);
            }
        }
        return null;
    }



    public static void wait(int secs) {
        try {
            Thread.sleep(1000 * secs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (java.util.NoSuchElementException e) {
            e.printStackTrace();
        } catch (StaleElementReferenceException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void waitAndClickElement(WebElement element, int seconds) {
        for (int i = 0; i < seconds; i++) {
            try {
                element.click();
                break;
            } catch (Exception e) {
                wait(1);
            }
        }
    }

    public static Boolean waitForInVisibility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public static void selectAnItemFromDropdown(WebElement item, String selectableItem) {
        wait(5);
        Select select = new Select(item);
        for (int i = 0; i < select.getOptions().size(); i++) {
            if (select.getOptions().get(i).getText().equalsIgnoreCase(selectableItem)) {
                select.getOptions().get(i).click();
                break;
            }
        }
    }

    /**
     * Clicks on an element using JavaScript
     *
     * @param elements -
     */
    public static void clickWithJSAsList(List<WebElement> elements) {
        for (WebElement each : elements) {
            ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", waitForVisibility(each, 5));
            ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", each);
        }
    }

    /**
     * login olunduktan sonra cookies lerden session Id cekmek icin kullanildi
     * not: yaklasik 4 saatlik omru var surekli degisen bir yapi session id
     *
     * @return kullanicinin session id si
     * @author omer
     * @since 03.09.2022
     */
    public static String getSessionId() {
        return driver.manage().getCookieNamed("PHPSESSID").toString().split(";")[0];
    }


    public static class API {
        static Response response;
        static JsonPath jsonPath;

        public static void addCategory(String sessionId, String title, int price, int showPrice, int duration, int blockBefore, int blockAfter, int paymentRequired, int bookable, String desc, boolean online) {
            response = given()
                    .headers("content-type", "application/x-www-form-urlencoded",
                            "cookie", "PHPSESSID=ln6mm0pp6qsi3u37jqjg3gb2i7")
                    .body("title=" + title +
                            "&price=" + price +
                            "&showPrice=" + showPrice +
                            "&duration=" + duration +
                            "&blockBefore=" + blockBefore +
                            "&blockAfter=" + blockAfter +
                            "&paymentRequired=" + paymentRequired +
                            "&bookable=" + bookable +
                            "&description=" + desc +
                            "&online=" + online)
                    .post("https://hypnotes.net/api/settings/meeting/category/add");
            //response.prettyPrint();
        }
    }

    public static void assertForClickability(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Assert.assertTrue(wait.until(ExpectedConditions.elementToBeClickable(element)).isDisplayed());
    }

    public static String getTodayMonth() {
        SimpleDateFormat format = new SimpleDateFormat("MMMM");
        Date date = new Date();
        return format.format(date);
    }

    public static String getTodaysDay() {
        SimpleDateFormat format = new SimpleDateFormat("dd");
        Date date = new Date();
        return format.format(date);
    }

    public static String getDateForLocation(int dayToSkip) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, dayToSkip);
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        return format1.format(cal.getTime());
    }

    public static String getDateForCoupon(int dayToSkip) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, dayToSkip);
        SimpleDateFormat format1 = new SimpleDateFormat("MM/dd/yyyy");
        return format1.format(cal.getTime());
    }

    public static String getYear_month_day_time(int hourToSkip) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.HOUR, hourToSkip);
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return format1.format(cal.getTime());
    }

    public static void staleElementSolution(String date) {
        Duration timeout = Duration.ofSeconds(30);
        new WebDriverWait(driver, timeout)
                .ignoring(StaleElementReferenceException.class)
                .until((WebDriver d) -> {
                    d.findElement(By.xpath("//td[@data-date='" + date + "']//div[@class='fc-daygrid-day-top']")).click();
                    return true;
                });
    }

    public static int booleanToInt(boolean input) {
        return input ? 1 : 0;
    }

    public static String getTodayMonthYear() {
        SimpleDateFormat format = new SimpleDateFormat("MMMM yyyy");
        Date date = new Date();
        return format.format(date);
    }

    public static String getTodayYear_month_day() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        return format.format(date);
    }

    public static boolean isFutureDate(String date) {
        String todayDate = BrowserUtilities.getTodayYear_month_day();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        boolean b = false;
        try {
            b = sdf.parse(todayDate).before(sdf.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return b;
    }

    public static String getTodayMonthDayYear() {
        SimpleDateFormat format = new SimpleDateFormat("MMMM d, yyyy");
        Date date = new Date();
        return format.format(date);
    }

    public static String getDateForMail() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        return format.format(date);
    }

    public static String getTimeForMail() {
        SimpleDateFormat format = new SimpleDateFormat("hh:mm aa");
        Date date = new Date();
        return format.format(date);
    }

    public static String getDateForGroupSession() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = new Date();

        return format.format(date);
    }


    public static void refreshPage() {
        driver.navigate().refresh();
        waitForPageToLoad(10);
        wait(2);
    }

    /**
     * degeri verilen categorinin renk code unu almak icin kullanildi
     *
     * @param i_1_p_2_g_3_s_4_r_5_c_6_n_7 1    Individual Sessions
     *                                    2    Packages
     *                                    3    Group Session
     *                                    4    Show Up
     *                                    5    Reschedule
     *                                    6    Cancelled
     *                                    7    No Show
     * @return secilen categorinin renk code u
     */
    public String getColourOfTheChange(int i_1_p_2_g_3_s_4_r_5_c_6_n_7) {
        String category = "";
        switch (i_1_p_2_g_3_s_4_r_5_c_6_n_7) {
            case 1:
                category = "Individual Sessions :";
                break;
            case 2:
                category = "Packages :";
                break;
            case 3:
                category = "Group Session :";
                break;
            case 4:
                category = "Show Up :";
                break;
            case 5:
                category = "Reschedule :";
                break;
            case 6:
                category = "Cancelled :";
                break;
            case 7:
                category = "No Show :";
                break;
        }
        return driver.findElement(By.xpath("//div[contains(@class,\"d-flex flex-row justify-content-between align-items-center\")]/span[text()='" + category + "']/../button"))
                .getCssValue("background-color");
    }




    /**
     * Performs double click action on an element
     *
     * @param element -
     */
    public static void doubleClick(WebElement element) {
        new Actions(Driver.getDriver()).doubleClick(element).build().perform();
    }

    //    Parameter1 : WebElement
    //    Parameter2:  String
    //    Driver.selectByVisibleText(dropdown element, "CHECKING-91303-116.98$")
    public static void selectByVisibleText(WebElement element, String text) {
        Select objSelect = new Select(element);
        objSelect.selectByVisibleText(text);
    }

    //    Parameter1 : WebElement
    //    Parameter2:  int
    //    Driver.selectByIndex(dropdown element, 1)
    public static void selectByIndex(WebElement element, int index) {
        Select objSelect = new Select(element);
        objSelect.selectByIndex(index);
    }

    //    Parameter1 : WebElement
    //    Parameter2:  String
    //    Driver.selectByIndex(dropdown element, "91303")
    public static void selectByValue(WebElement element, String value) {
        Select objSelect = new Select(element);
        List<WebElement> elementCount = objSelect.getOptions();
        objSelect.selectByValue(value);
        System.out.println("number of elements: " + elementCount.size());
    }

    public static void waitAndClickLocationText(WebElement element, String value) {
        Driver.getDriver().findElement(By.xpath("//*[text()='" + value + "']")).click();
    }

    public static void scrollUntilEnd(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public static int randomClick(List<WebElement> webElements) {
        Random random = new Random();
        if (webElements.size() == 0) {
            Assert.fail();
        }
        int i = random.nextInt(webElements.size() - 1);

        actions.scrollToElement(webElements.get(i)).perform();
        webElements.get(i).click();

        System.out.println(i);
        // BrowserUtilities.waitForVisibility(webElements.get(i),10);
//        BrowserUtilities.scrollToElement(webElements.get(i));
        BrowserUtilities.clickWithJS(webElements.get(i));
        BrowserUtilities.waitForVisibility(webElements.get(i), 10);
        return i;
    }

    public static <T> Set<T> mergeSet(Set<T> a, Set<T> b) {

        // Adding all elements of respective Sets
        // using addAll() method
        return new HashSet<T>() {
            {
                addAll(a);
                addAll(b);
            }
        };

    }

    public static void setClipBoard(String filePath) {
        StringSelection selection = new StringSelection(filePath);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(selection, selection);
    }

    public static void staleElementClick(WebElement element, int timeout) {
        new WebDriverWait(driver, Duration.ofSeconds(timeout))
                .ignoring(StaleElementReferenceException.class)
                .until((WebDriver d) -> {
                    clickWithJS(element);
                    return true;
                });
    }

    public static void staleElementClick(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .ignoring(StaleElementReferenceException.class)
                .until((WebDriver d) -> {
                    element.click();
                    return true;
                });
    }

    /**
     * webelement listesindeki elemenlar arasinda verilen obje adini gorene kadar arrow down a basiyor
     *
     * @param tList        bakilacak webelement listesi
     * @param objectToLook bakilacak obje adi
     */
    public static void clickStringInTheList(List<WebElement> tList, String objectToLook) {
        for (int i = 0; i < tList.size() * 2; i++) {

            try {
                if (tList.stream().noneMatch(t -> t.getText().contains(objectToLook))) {
                    throw new Exception();
                }
            } catch (Exception e) {
                actions.sendKeys(Keys.ARROW_DOWN).perform();
                wait(1);
            }
        }
    }

    public static void staleElementSolutions(String date) {
        Duration timeout = Duration.ofSeconds(10);
        new WebDriverWait(driver, timeout)
                .ignoring(StaleElementReferenceException.class)
                .until((WebDriver d) -> {
                    d.findElement(By.xpath("//td[@data-date='" + date + "']//div[@class='fc-daygrid-day-top']")).click();
                    return true;
                });
    }

    public static String getDateForCalendar(int dayToSkip) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, dayToSkip);
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        return format1.format(cal.getTime());
    }

    public static void assertTexts(String expectedText, WebElement element) {
        Assert.assertEquals(expectedText, element.getText());
    }

    public static boolean isWebelemntVisible(WebElement webElement) {
        boolean flag;

        try {
            webElement.isDisplayed();
            flag = true;
        } catch (NoSuchElementException e) {
            flag = false;
        }
        return flag;
    }

    public static String getDigitFromString(String str) {

        String out = "";
        String strPattern = "\\d+";

        Pattern pattern = Pattern.compile(strPattern);
        Matcher matcher = pattern.matcher(str);

        while (matcher.find()) {
            out = matcher.group();
        }
        return out;

    }
    public static void clearLocalSessionCookies(){
        LocalStorage local = ((WebStorage) driver).getLocalStorage();
        SessionStorage session = ((WebStorage) driver).getSessionStorage();
        local.clear();
        session.clear();
        driver.manage().deleteAllCookies();

    }

    public static void addSeconds(int secondsToSkip) {
        Calendar calendarfuture = Calendar.getInstance();
        Calendar calendar = Calendar.getInstance();
        calendarfuture.add(Calendar.SECOND, secondsToSkip);
        SimpleDateFormat dateFormat = new SimpleDateFormat("mm ss");

        System.out.println("calendar.getTime().getTime() = " + dateFormat.format(calendar.getTime()));
        System.out.println("calendarfuture.getTime().getTime() = " + dateFormat.format(calendarfuture.getTime()));

        while (!dateFormat.format(calendar.getTime()).equals(dateFormat.format(calendarfuture.getTime()))) {
            calendar = Calendar.getInstance();
//            System.out.println(dateFormat.format(calendar.getTime()) + " : " + dateFormat.format(calendarfuture.getTime()));
//            wait(1000);
        }
    }

    public static void selectNewWindow() {
        if(driver.getWindowHandles().size() > 1) {
            String parentWindow = driver.getWindowHandle();
            Set<String> handles = driver.getWindowHandles();
            for (String windowHandle : handles) {
                if (!windowHandle.equals(parentWindow)) {
                    driver.switchTo().window(windowHandle);
                    break;
                }
            }
        } else {
            selectNewWindow();
        }
    }
}
