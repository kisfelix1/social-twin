package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.WebElementWait;

import java.awt.Toolkit;
import java.awt.Dimension;


public class MessengerPage extends BasePage {

    public MessengerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[@data-testid='timestamp']")
    WebElement timeStamp;

    @FindBy(xpath = "//div[@role='gridcell']")
    WebElement firstChatOnPage;

    @FindBy(xpath = "(//div[@dir='auto'])[last()]")
    WebElement lastMessage;

    @FindBy(xpath = "//div[@role='textbox']")
    WebElement messageInputField;


    public boolean isTimeStampInCriteria(int timeValueCriteria, String timeMeasureCriteria) {
        String timeValue = getTimeStampMeasureOnIndex(0);
        String timeMeasure = getTimeStampMeasureOnIndex(1);
        return Integer.parseInt(timeValue) < timeValueCriteria && timeMeasure.equals(timeMeasureCriteria);
    }

    private String getTimeStampMeasureOnIndex(int x) {
        return timeStamp.getText().split(" ")[x];
    }

    public void sendAnswer(String answer) throws InterruptedException {
        WebElementWait.waitUntilClickable(driver, firstChatOnPage);
        firstChatOnPage.click();
        WebElementWait.waitUntilVisible(driver, messageInputField);
        Thread.sleep(2000);
        messageInputField.sendKeys(answer);
        messageInputField.sendKeys(Keys.ENTER);
    }

    public String getLastMessage() {
        return lastMessage.getText();
    }

    public String getLastMessageSenderName() {
        WebElementWait.waitUntilVisible(driver, firstChatOnPage);
        return firstChatOnPage.getText().split("\n")[0];
    }

    public boolean notSentByUser() {
        WebElementWait.waitUntilVisible(driver, firstChatOnPage);
        return true;
    }
}
