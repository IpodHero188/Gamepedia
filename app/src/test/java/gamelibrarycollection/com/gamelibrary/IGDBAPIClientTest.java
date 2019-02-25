package gamelibrarycollection.com.gamelibrary;

import org.junit.jupiter.api.Test;

import wrapper.IGDBWrapper;
import wrapper.Version;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;

public class IGDBAPIClientTest {

    @Test
    void shouldReturnNull(){
        IGDBWrapper wrapper = null;
        final IGDBAPIClient igdbapiClient = new IGDBAPIClient(wrapper);
        assertNull(igdbapiClient.getWrapper());
    }

    @Test
    void shouldReturnWrapper(){
        IGDBWrapper wrapper = new IGDBWrapper("12345", Version.STANDARD, false);
        final IGDBAPIClient igdbapiClient = new IGDBAPIClient(wrapper);

        assertThat(igdbapiClient.getWrapper(), is(instanceOf(IGDBWrapper.class)));
    }

}
