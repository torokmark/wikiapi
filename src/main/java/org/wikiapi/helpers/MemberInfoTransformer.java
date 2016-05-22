package org.wikiapi.helpers;

import java.util.LinkedHashMap;

import org.wikiapi.entities.MemberInfo;

public class MemberInfoTransformer {

    public static MemberInfo from(LinkedHashMap<String, Object> hashMap) {
        MemberInfo retValue = new MemberInfo();
        retValue.pageId = Long.valueOf(hashMap.get("pageid").toString());
        retValue.ns = Integer.valueOf(hashMap.get("ns").toString());
        retValue.title = hashMap.get("title").toString();
        return retValue;
    }

}
