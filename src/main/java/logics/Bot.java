package logics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class Bot {
    protected static WebDriver driver;

    public Bot() {
        setUpChromeDriverPath();
        driver = new ChromeDriver();
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

    public void loop() throws InterruptedException {
        goToMessages();
        while(true){
            if(lastMessageInNameList()){
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
    abstract boolean lastMessageInNameList();
    abstract void goToMessages();
}
