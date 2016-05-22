package org.wikiapi;

import java.util.Map;
import java.util.Set;

import org.wikiapi.entities.MemberInfo;

public interface WikiAPIDAO {

    Set<MemberInfo> getPagesByCategory(String categoryName);

    Map<String, Set<MemberInfo>> getPagesByCategories(Set<String> categoryNames);
}
