package gamelibrarycollection.com.gamelibrary;

import org.json.JSONArray;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import wrapper.Endpoints;
import wrapper.IGDBWrapper;
import wrapper.Parameters;

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

//    @Test
//    void shouldReturnDataFromAllGamesFromEmptySearchQuery() {
//
//        String expected = "[\n" +
//                "    {\n" +
//                "        \"id\": 98774,\n" +
//                "        \"category\": 0,\n" +
//                "        \"created_at\": 1524614400,\n" +
//                "        \"external_games\": [\n" +
//                "            390825\n" +
//                "        ],\n" +
//                "        \"game_modes\": [\n" +
//                "            1\n" +
//                "        ],\n" +
//                "        \"genres\": [\n" +
//                "            15,\n" +
//                "            32\n" +
//                "        ],\n" +
//                "        \"name\": \"Whitevale Defender\",\n" +
//                "        \"popularity\": 1,\n" +
//                "        \"screenshots\": [\n" +
//                "            232990,\n" +
//                "            232991,\n" +
//                "            232992,\n" +
//                "            232993,\n" +
//                "            232994\n" +
//                "        ],\n" +
//                "        \"similar_games\": [\n" +
//                "            25311,\n" +
//                "            25640,\n" +
//                "            33603,\n" +
//                "            34919,\n" +
//                "            37419,\n" +
//                "            55077,\n" +
//                "            65827,\n" +
//                "            76127,\n" +
//                "            109438,\n" +
//                "            113161\n" +
//                "        ],\n" +
//                "        \"slug\": \"whitevale-defender\",\n" +
//                "        \"summary\": \"Help King Theodore save Whitevale from hordes of war machines in this handcrafted, retro strategy defense game.\",\n" +
//                "        \"tags\": [\n" +
//                "            1,\n" +
//                "            268435471,\n" +
//                "            268435488\n" +
//                "        ],\n" +
//                "        \"themes\": [\n" +
//                "            1\n" +
//                "        ],\n" +
//                "        \"updated_at\": 1534204800,\n" +
//                "        \"url\": \"https://www.igdb.com/games/whitevale-defender\",\n" +
//                "        \"websites\": [\n" +
//                "            84921,\n" +
//                "            84922\n" +
//                "        ]\n" +
//                "    }\n" +
//                "\t]";
//
//        String searchTerm = "";
//        Parameters gameParam = new Parameters()
//                                            .addSearch(searchTerm)
//                                            .addFields("*");
//
//        JSONArray resultArray = new JSONArray();
//        VideoGameMapper gameMapper = mock(VideoGameMapper.class);
//        when(gameMapper.map(resultArray)).thenReturn(expected);
//
//        assertThat(igdbapiClient.getGameData(gameParam), is(expected));
//    }

}
