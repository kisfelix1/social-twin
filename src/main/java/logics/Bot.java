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
        while (true) {
            if (messageReceived()) {
                String message = getLastMessageFromPartner();
                sendMessageToAI(message);
                String answer = getLastAnswerFromAI();
                sendAnswerToPartner(answer);
            }
            Thread.sleep(10000);
        }
    }

    private boolean messageReceived() throws FileNotFoundException {
        return lastMessageIsInNameList() && notSentByUser();
    }

    private void sendMessageToAI(String message) {
        cleverBotPage.sendText(message);
    }

    abstract boolean notSentByUser();

    abstract void sendAnswerToPartner(String answer) throws InterruptedException;

    abstract String getLastAnswerFromAI() throws InterruptedException;

    abstract String getLastMessageFromPartner();

    abstract boolean lastMessageIsInNameList() throws FileNotFoundException;
}
