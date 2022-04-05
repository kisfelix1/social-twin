package util;

public enum URLCollector {
    MESSENGER_LOGIN_PAGE_URL("https://www.messenger.com/"),
    CLEVERBOT_PAGE_URL("https://www.cleverbot.com/");
    public final String URL;

    URLCollector(String url) {
        URL = url;
    }


}
