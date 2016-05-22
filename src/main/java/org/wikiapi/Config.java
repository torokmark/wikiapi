package org.wikiapi;

public interface Config {

    String host();

    String api();

    @Override
    String toString();
}
