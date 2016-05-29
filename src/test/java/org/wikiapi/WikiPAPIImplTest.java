package org.wikiapi;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.wikiapi.entities.MemberInfo;

public class WikiPAPIImplTest {

    private WikiAPIImpl wikiAPIDAOImpl;

    @Before
    public void setUp() throws Exception {
        wikiAPIDAOImpl = new WikiAPIImpl();
    }

    @Test
    public void test() {
        Set<MemberInfo> o = wikiAPIDAOImpl.getPagesByCategory("Hungarian_poets"); // "Hungarian_poets"

        System.out.println(o);
    }
}
