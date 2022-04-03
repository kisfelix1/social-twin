package logics;

import pages.FacebookLoginPage;

public class MessengerBot extends Bot{
    FacebookLoginPage fBLoginPage;
    public MessengerBot() {
        fBLoginPage = new FacebookLoginPage(driver);
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
    boolean lastMessageInNameList() {
        return false;
    }

    @Override
    void goToMessages() {

    }
}
