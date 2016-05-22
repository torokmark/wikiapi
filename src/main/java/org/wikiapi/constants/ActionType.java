package org.wikiapi.constants;

public enum ActionType {
    QUERY;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
