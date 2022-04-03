package logics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public abstract class Bot {
    protected static WebDriver driver;

    public Bot() {
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        setUpChromeDriverPath();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    private void setUpChromeDriverPath() {
        if (System.getProperty("os.name").equals("Linux")) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        } else {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        }
    }

    public abstract void login();

    public void loop() throws InterruptedException, FileNotFoundException {
        goToMessages();
        while(true){
            if(lastMessageIsInNameList()){
                String message = getMessage();
                String answer = getAnswerFromBotByMessage(message);
                sendAnswer(answer);
            }
            Thread.sleep(5000);
        }
    }

    abstract void sendAnswer(String answer);
    abstract String getAnswerFromBotByMessage(String message);
    abstract String getMessage();
    abstract boolean lastMessageIsInNameList() throws FileNotFoundException;
    abstract void goToMessages();
}
