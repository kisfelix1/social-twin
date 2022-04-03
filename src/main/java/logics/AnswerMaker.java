package logics;

import org.openqa.selenium.chrome.ChromeDriver;
import pages.CleverBotPage;

public class AnswerMaker {
    private CleverBotPage cleverBotPage;

    public AnswerMaker() {
        cleverBotPage = new CleverBotPage(new ChromeDriver());
    }
}
