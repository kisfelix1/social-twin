package logics;

import pages.FacebookLoginPage;
import pages.MessengerPage;
import util.URLCollector;
import util.txtFileReader;

import java.io.FileNotFoundException;
import java.util.List;

public class MessengerBot extends Bot {
    FacebookLoginPage fBLoginPage;
    MessengerPage messengerPage;

    public MessengerBot() {
        fBLoginPage = new FacebookLoginPage(driver);
        messengerPage = new MessengerPage(driver);
    }

    @Override
    public void login() {
        String email = System.getenv("email");
        String password = System.getenv("password");
        fBLoginPage.actLogin(email, password);
    }

    @Override
    void sendAnswer(String answer) {

    }

    @Override
    String getLastAnswerFromBot() {
        return cleverBotPage.getLastAnswerFromConversation();
    }

    @Override
    String getMessage() {
        return null;
    }

    @Override
    boolean lastMessageIsInNameList() throws FileNotFoundException {
        List<String> names = txtFileReader.getNamesOfTxt();
        return false;
    }

    @Override
    void goToMessages() {
        driver.get(URLCollector.MESSENGER_PAGE_URL.URL);
    }
}
