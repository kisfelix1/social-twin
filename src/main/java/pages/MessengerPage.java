package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MessengerPage extends BasePage {
    public MessengerPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h1[contains(text(),'Chatek')]")
    WebElement chatHeader;

    @FindBy(xpath = "//span[@data-testid='timestamp']")
    WebElement timeStamp;

    public boolean checkTimeStamp() {
        String timeStampOfLastMessage = timeStamp.getText().split(" ")[0];
        String timeMeasure = timeStamp.getText().split(" ")[1];
        return Integer.parseInt(timeStampOfLastMessage) < 1 && timeMeasure.equals("p");
    }


}
