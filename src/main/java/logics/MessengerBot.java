package logics;

import pages.MessengerLoginPage;
import pages.MessengerPage;
import util.txtFileReader;

import java.io.FileNotFoundException;
import java.util.List;

public class MessengerBot extends Bot {
    MessengerLoginPage messengerLoginPage;
    MessengerPage messengerPage;

    public MessengerBot() {
        messengerLoginPage = new MessengerLoginPage();
    }

    @Override
    public void login() {
        String email = System.getenv("email");
        String password = System.getenv("password");
        messengerLoginPage.actLogin(email, password);
        messengerPage = new MessengerPage(messengerLoginPage.getDriver());
        messengerPage.clickAccept();
    }

    @Override
    boolean notSentByUser() {
        return messengerPage.notSentByUser();
    }

    @Override
    void sendAnswerToPartner(String answer) throws InterruptedException {
        messengerPage.sendAnswer(answer);
    }

    @Override
    String getLastAnswerFromAI() throws InterruptedException {
        return cleverBotPage.getLastAnswerFromAIConversation();
    }

    @Override
    String getLastMessageFromPartner() {
        return messengerPage.getLastMessage();
    }

    @Override
    boolean lastMessageIsInNameList() throws FileNotFoundException {
        List<String> names = txtFileReader.getNamesFromTxt();
        return names.contains(getFormattedNameFromPage()) && messengerPage.notSentByUser();
    }

    private String getFormattedNameFromPage(){
        return messengerPage.getLastMessageSenderName();
    }
}
