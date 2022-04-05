package logics;

public class InstagramBot extends Bot {
    public InstagramBot() {
    }

    @Override
    public void login() {

    }

    @Override
    boolean notSentByUser() {
        return false;
    }

    @Override
    void sendAnswerToPartner(String answer) {

    }

    @Override
    String getLastAnswerFromAI() {
        return null;
    }

    @Override
    String getLastMessageFromPartner() {
        return null;
    }

    @Override
    boolean lastMessageIsInNameList() {
        return false;
    }
}
