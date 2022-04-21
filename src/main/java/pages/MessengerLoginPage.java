package pages;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.URLCollector;
import util.WebElementWait;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class MessengerLoginPage extends BasePage {
    public MessengerLoginPage() {
        setUpDriver();
        PageFactory.initElements(driver, this);
    }

    private void setUpDriver() {
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @FindBy(xpath = "//input[@id='email']")
    WebElement emailInputField;

    @FindBy(xpath = "//input[@id='pass']")
    WebElement passwordInputField;

    @FindBy(xpath = "//button[@name='login']")
    WebElement loginButton;

    @FindBy(xpath = "//button[@data-cookiebanner='accept_button']")
    WebElement acceptCookiesButton;

    public void actLogin(String email, String password) {
        driver.get(URLCollector.MESSENGER_LOGIN_PAGE_URL.URL);
        WebElementWait.waitUntilClickable(driver, acceptCookiesButton);
        acceptCookiesButton.click();
        WebElementWait.waitUntilVisible(driver, emailInputField);
        emailInputField.sendKeys(email);
        WebElementWait.waitUntilVisible(driver, passwordInputField);
        passwordInputField.sendKeys(password);
        WebElementWait.waitUntilClickable(driver, loginButton);
        loginButton.click();
    }
}
