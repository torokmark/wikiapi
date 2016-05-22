package org.wikiapi;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.wikiapi.entities.MemberInfo;

public class WikiPAPIDADOImplTest {

    private WikiAPIDAOImpl wikiAPIDAOImpl;

    @Before
    public void setUp() throws Exception {
        wikiAPIDAOImpl = new WikiAPIDAOImpl();
    }

    @Test
    public void test() {
        Set<MemberInfo> o = wikiAPIDAOImpl.getPagesByCategory("Hungarian_poets");

        System.out.println(o);
    }
}
