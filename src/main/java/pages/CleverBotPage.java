package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.URLCollector;
import util.WebElementWait;

import java.util.concurrent.TimeUnit;

public class CleverBotPage extends BasePage {
    public CleverBotPage() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-blink-features=AutomationControlled");
        chromeOptions.addArguments("--enable-javascript");
        driver = new ChromeDriver(chromeOptions);
        PageFactory.initElements(driver, this);
        setUp();
    }

    private void setUp() {
        driver.get(URLCollector.CLEVERBOT_PAGE_URL.URL);
        clickAgreeButton();
    }

    @FindBy(xpath = "//input[@value='understood, and agreed']")
    WebElement agreeButton;

    @FindBy(xpath = "(//span[@class='bot'])[last()]")
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

    public String getLastAnswerFromAIConversation() throws InterruptedException {
        //this line is the result of cleverbots page -
        //the page answers in a manner that it types like a human - character by character
        Thread.sleep(3000);
        return lastMessage.getText();
    }
}
