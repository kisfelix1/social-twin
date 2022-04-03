package util;

public enum URLCollector {
    FACEBOOK_LOGIN_PAGE_URL("https://www.facebook.com/"),
    MESSENGER_PAGE_URL("https://www.facebook.com/messages/");
    public final String URL;

    URLCollector(String url) {
        URL = url;
    }


}