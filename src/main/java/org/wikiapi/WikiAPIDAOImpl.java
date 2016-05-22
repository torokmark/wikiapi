package org.wikiapi;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.util.Strings;
import org.wikiapi.constants.ActionType;
import org.wikiapi.constants.FormatType;
import org.wikiapi.constants.ListType;
import org.wikiapi.entities.MemberInfo;
import org.wikiapi.helpers.MemberInfoTransformer;
import org.wikiapi.helpers.ParameterBuilder;

import com.jayway.jsonpath.JsonPath;

public class WikiAPIDAOImpl implements WikiAPIDAO {

    private static final Logger LOGGER = (Logger)LogManager.getLogger();

    private Config config;

    public WikiAPIDAOImpl() {
        config = new WikiAPIConfig();
    }

    public WikiAPIDAOImpl(final Config config) {
        this.config = config;
    }

    @Override
    public Set<MemberInfo> getPagesByCategory(final String categoryName) {
        String json = getRawListByCategoryName(categoryName);
        Set<MemberInfo> retValue = getSetOfMemberInfos(json);
        return retValue;
    }

    @Override
    public Map<String, Set<MemberInfo>> getPagesByCategories(final Set<String> categoryNames) {
        Map<String, Set<MemberInfo>> retValue = new HashMap<>();
        for (String categoryName : categoryNames) {
            retValue.put(categoryName, getPagesByCategory(categoryName));
        }
        return retValue;
    }

    private String getRawListByCategoryName(final String categoryName) {
        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
            String parameter = new ParameterBuilder()
                    .action(ActionType.QUERY)
                    .format(FormatType.JSON)
                    .list(ListType.CATEGORYMEMBERS)
                    .cmtitle(categoryName)
                    .build();
            HttpGet httpget = new HttpGet(config.toString() + "?" + parameter);

            ResponseHandler<String> responseHandler = response -> {
                int status = response.getStatusLine().getStatusCode();
                if (status >= 200 && status < 300) {
                    HttpEntity entity = response.getEntity();
                    return entity != null ? EntityUtils.toString(entity) : null;
                } else {
                    throw new ClientProtocolException("Unexpected response status: " + status);
                }
            };
            String responseBody = httpclient.execute(httpget, responseHandler);
            return responseBody;
        } catch (Exception e) {
            LOGGER.error(e);
        }
        return Strings.EMPTY;
    }

    private Set<MemberInfo> getSetOfMemberInfos(final String json) {
        Set<MemberInfo> retValue = new HashSet<>();
        List<LinkedHashMap<String, Object>> members = JsonPath.<List<LinkedHashMap<String, Object>>>read(json, "$.query.categorymembers[*]");
        for (LinkedHashMap<String, Object> s : members) {
            retValue.add(MemberInfoTransformer.from(s));
        }
        return retValue;
    }

}
