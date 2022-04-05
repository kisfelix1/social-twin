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
    }

    @Override
    boolean notSentByUser() {
        return messengerPage.notSentByUser();
    }

    @Override
    void sendAnswerToPartner(String answer) {
        messengerPage.sendAnswer(answer);
    }

    @Override
    String getLastAnswerFromAI() {
        return cleverBotPage.getLastAnswerFromConversation();
    }

    @Override
    String getLastMessageFromPartner() {
        return messengerPage.getLastMessage();
    }

    @Override
    boolean lastMessageIsInNameList() throws FileNotFoundException {
        List<String> names = txtFileReader.getNamesOfTxt();
        System.out.println(messengerPage.getLastMessageName().split(" ")[0] + " " + messengerPage.getLastMessageName().split(" ")[1]);
        return names.contains(messengerPage.getLastMessageName().split(" ")[0] + " " + messengerPage.getLastMessageName().split(" ")[1]) && messengerPage.notSentByUser();
    }
}
