package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.KeyInput;
import org.openqa.selenium.support.FindBy;
import util.WebElementWait;

import java.security.Key;

public class CleverBotPage extends BasePage {
    public CleverBotPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@value='understood, and agreed']")
    WebElement agreeButton;

    @FindBy(xpath = "//input[@name='stimulus']")
    WebElement stimulusInputField;

    public void clickAgreeButton() {
        WebElementWait.waitUntilClickable(driver, agreeButton);
        agreeButton.click();
    }

    public void sendText(String text) {
        WebElementWait.waitUntilVisible(driver, stimulusInputField);
        stimulusInputField.sendKeys(text);
        stimulusInputField.sendKeys(Keys.ENTER);
    }
}
