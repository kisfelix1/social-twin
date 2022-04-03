package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.WebElementWait;
import util.URLCollector;

public class FacebookLoginPage extends BasePage {
    public FacebookLoginPage(WebDriver driver) {
        super(driver);
        driver.get(URLCollector.FACEBOOK_LOGIN_PAGE_URL.URL);
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
