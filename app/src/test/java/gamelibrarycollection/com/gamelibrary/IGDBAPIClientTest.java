package gamelibrarycollection.com.gamelibrary;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.json.JSONArray;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import gamelibrarycollection.com.gamelibrary.models.VideoGame;
import wrapper.Endpoints;
import wrapper.IGDBWrapper;
import wrapper.Parameters;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IGDBAPIClientTest {

    private IGDBAPIClient igdbapiClient;

    @BeforeEach
    void setup() {
        igdbapiClient = new IGDBAPIClient();
        igdbapiClient.getWrapperInstance();
    }

    @Test
    void shouldReturnWrapperOnInstantiation() {
        assertThat(igdbapiClient.getWrapperInstance(), is(instanceOf(IGDBWrapper.class)));
    }

}
