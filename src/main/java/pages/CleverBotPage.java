package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import util.URLCollector;
import util.WebElementWait;

public class CleverBotPage extends BasePage {
    public CleverBotPage() {
        setUpDriver();
        PageFactory.initElements(driver, this);
        initPage();
    }

    private void setUpDriver() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-blink-features=AutomationControlled");
        chromeOptions.addArguments("--enable-javascript");
        driver = new ChromeDriver(chromeOptions);
    }

    private void initPage() {
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
