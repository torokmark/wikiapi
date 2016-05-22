package org.wikiapi;

public final class WikiAPIConfig implements Config {

    private final String HOST = "https://en.wikipedia.org";
    private final String API = "/w/api.php";

    @Override
    public String host() {
        return HOST;
    }

    @Override
    public String api() {
        return API;
    }

    @Override
    public String toString() {
        return HOST + API;
    }
}
