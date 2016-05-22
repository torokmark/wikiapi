package org.wikiapi.constants;

public enum FormatType {
    JSON,
    PHP,
    RAWFM,
    XML,
    NONE;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
