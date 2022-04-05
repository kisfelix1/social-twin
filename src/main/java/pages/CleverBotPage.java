package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.URLCollector;
import util.WebElementWait;

public class CleverBotPage extends BasePage {
    public CleverBotPage() {
        ChromeOptions otherOptions = new ChromeOptions();
        otherOptions.addArguments("--disable-blink-features=AutomationControlled");
        otherOptions.addArguments("--enable-javascript");
        driver = new ChromeDriver(otherOptions);
        PageFactory.initElements(driver, this);
        setUp();
    }

    private void setUp() {
        driver.get(URLCollector.CLEVERBOT_PAGE_URL.URL);
        clickAgreeButton();
    }

    @FindBy(xpath = "//input[@value='understood, and agreed']")
    WebElement agreeButton;

    @FindBy(xpath = "//p[@id='line1']")
    WebElement lastMessage;

    @FindBy(xpath = "//input[@name='stimulus']")
    WebElement stimulusInputField;

    private void clickAgreeButton() {
        WebElementWait.waitUntilClickable(driver, agreeButton);
        agreeButton.click();
    }

    public void sendText(String text) {
        WebElementWait.waitUntilVisible(driver, stimulusInputField);
        stimulusInputField.sendKeys(text);
        stimulusInputField.sendKeys(Keys.ENTER);
    }

    public String getLastAnswerFromConversation() {
        WebElementWait.waitUntilVisible(driver, lastMessage);
        return lastMessage.getText();
    }
}
