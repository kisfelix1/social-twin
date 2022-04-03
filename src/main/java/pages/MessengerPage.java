package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.WebElementWait;

public class MessengerPage extends BasePage {
    public MessengerPage(WebDriver driver) {
        super(driver);
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
        firstChatOnPage.click();
        WebElementWait.waitUntilVisible(driver, messageInputField);
        messageInputField.sendKeys(answer);
        messageInputField.sendKeys(Keys.ENTER);
    }


}
