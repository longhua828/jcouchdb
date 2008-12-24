package org.jcouchdb.db;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.startsWith;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.junit.Test;


public class OptionsTestCase
{
    protected static Logger log = Logger.getLogger(OptionsTestCase.class);

    @Test
    public void option()
    {
        String query = new Options("foo",1).put("bar", "baz!").toQuery();
        log.debug(query);
        assertThat(query, startsWith("?"));
        assertThat(query, containsString("foo=1"));
        assertThat(query, containsString("bar=%22baz%21%22"));


        query = new Options("foo",1).put("bar", new ArrayList()).toQuery();
        log.debug(query);
        assertThat(query, startsWith("?"));
        assertThat(query, containsString("foo=1"));
        assertThat(query, containsString("bar=%5B%5D"));
    }

}
