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

    @FindBy(xpath = "(//div[@style='background-color: rgb(0, 132, 255);'])[last()]")
    WebElement lastMessageByUser;


    @FindBy(xpath = "//*[contains(text(), 'Az összes cookie engedélyezése')]")
    WebElement accept;




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
        return !lastMessageByUser.getText().equals(lastMessage.getText());
    }

    public void clickAccept() {
        try {
            WebElementWait.waitUntilClickable(driver, accept);
            accept.click();
        }catch(Exception e){
            System.out.println("There was no element");
        }
    }
}
