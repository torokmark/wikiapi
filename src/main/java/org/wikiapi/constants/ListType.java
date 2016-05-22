package org.wikiapi.constants;

public enum ListType {
    CATEGORYMEMBERS;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
