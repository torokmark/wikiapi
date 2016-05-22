package org.wikiapi;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.wikiapi.constants.ActionType;
import org.wikiapi.constants.FormatType;
import org.wikiapi.constants.ListType;
import org.wikiapi.helpers.ParameterBuilder;

public class ParameterBuilderTest {

    private ParameterBuilder parameterBuilder;

    @Before
    public void setUp() throws Exception {
        parameterBuilder = new ParameterBuilder();
    }

    @Test
    public void testBuildWithProperInput_ShouldBuildAString() {
        // Arrange

        // Act
        String actual = parameterBuilder
                .action(null)
                .format(FormatType.NONE)
                .action(ActionType.QUERY)
                .format(FormatType.JSON)
                .cmtitle("something")
                .list(ListType.CATEGORYMEMBERS)
                .cmtitle("something else")
                .build();

        System.out.println(actual);

        // Assert
        Assert.assertTrue(actual.contains("action=" + ActionType.QUERY));
        Assert.assertTrue(actual.contains("format=" + FormatType.JSON));
        Assert.assertTrue(actual.contains("list=" + ListType.CATEGORYMEMBERS));
        Assert.assertTrue(actual.contains("cmtitle=Category:something%20else"));
    }

}
