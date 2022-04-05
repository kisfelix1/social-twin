package logics;

import pages.CleverBotPage;

import java.io.FileNotFoundException;

public abstract class Bot {
    protected static CleverBotPage cleverBotPage;

    public Bot() {
        setUpChromeDriverPath();
        cleverBotPage = new CleverBotPage();
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
        while(true) {
            if (lastMessageIsInNameList() && notSentByUser()) {
                String message = getMessage();
                cleverBotPage.sendText(message);
                String answer = getLastAnswerFromBot();
                sendAnswer(answer);
            }
            Thread.sleep(10000);
        }
    }

    abstract boolean notSentByUser();

    abstract void sendAnswer(String answer);

    abstract String getLastAnswerFromBot();

    abstract String getMessage();

    abstract boolean lastMessageIsInNameList() throws FileNotFoundException;
}
