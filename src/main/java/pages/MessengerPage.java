package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.WebElementWait;

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


    public boolean checkTimeStamp() {
        String timeStampOfLastMessage = timeStamp.getText().split(" ")[0];
        String timeMeasure = timeStamp.getText().split(" ")[1];
        return Integer.parseInt(timeStampOfLastMessage) < 1 && timeMeasure.equals("p");
    }

    public void sendAnswer(String answer) {
        WebElementWait.waitUntilClickable(driver, firstChatOnPage);
        firstChatOnPage.click();
        WebElementWait.waitUntilVisible(driver, messageInputField);
        messageInputField.sendKeys(answer);
        messageInputField.sendKeys(Keys.ENTER);
    }

    public String getLastMessage() {
        return lastMessage.getText();
    }

    public String getLastMessageName() {
        WebElementWait.waitUntilVisible(driver, firstChatOnPage);
        return firstChatOnPage.getText();
    }

    public boolean notSentByUser() {
        WebElementWait.waitUntilVisible(driver, firstChatOnPage);
        System.out.println(firstChatOnPage.getText());
        return true;
    }
}
