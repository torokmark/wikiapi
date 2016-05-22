package org.wikiapi.helpers;

import java.util.LinkedList;
import java.util.List;

import org.apache.logging.log4j.util.Strings;
import org.wikiapi.constants.ActionType;
import org.wikiapi.constants.FormatType;
import org.wikiapi.constants.ListType;

public class ParameterBuilder {

    private static final String ACTION = "action";
    private static final String FORMAT = "format";
    private static final String LIST = "list";
    private static final String CMTITLE = "cmtitle";

    private static final String CATEGORY = "Category";

    private ActionType action;
    private FormatType format;
    private ListType list;
    private String cmtitle;

    public ParameterBuilder action(final ActionType action) {
        if (action != null) {
            this.action = action;
        } else {
            this.action = ActionType.QUERY;
        }
        return this;
    }

    public ParameterBuilder format(final FormatType format) {
        if (format != null) {
            this.format = format;
        } else {
            this.format = FormatType.NONE;
        }
        return this;
    }

    public ParameterBuilder list(final ListType list) {
        if (list != null) {
            this.list = list;
        } else {
            this.list = ListType.CATEGORYMEMBERS;
        }
        return this;
    }

    public ParameterBuilder cmtitle(final String title) {
        if (title != null) {
            cmtitle = CATEGORY + ":" + title.replace(" ", "%20");
        } else {
            cmtitle = Strings.EMPTY;
        }
        return this;
    }

    public String build() {
        List<String> params = new LinkedList<>();
        if (action != null) {
            params.add(ACTION + "=" + action);
        }
        if (format != null) {
            params.add(FORMAT + "=" + format);
        }
        if (list != null) {
            params.add(LIST + "=" + list);
        }
        if (Strings.isNotBlank(cmtitle)) {
            params.add(CMTITLE + "=" + cmtitle);
        }
        return String.join("&", params);
    }

}
