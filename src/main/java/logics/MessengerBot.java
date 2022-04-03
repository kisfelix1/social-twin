package logics;

import pages.FacebookLoginPage;
import pages.MessengerPage;
import util.txtFileReader;
import util.URLCollector;

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
    String getAnswerFromBotByMessage(String message) {
        return null;
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
