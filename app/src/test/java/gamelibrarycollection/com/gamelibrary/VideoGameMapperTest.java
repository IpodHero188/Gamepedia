package gamelibrarycollection.com.gamelibrary;

import org.hamcrest.Matchers;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import gamelibrarycollection.com.gamelibrary.models.VideoGame;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertThrows;

class VideoGameMapperTest {

    private VideoGameMapper mapper;

    @BeforeEach
    void setup() {
        mapper = new VideoGameMapper();
    }

    @Test
    void shouldThrowExceptionWhenInputIsNull() {
        assertThrows(NullPointerException.class, () -> {
            mapper.map(null);
        });
    }

    @Test
    void shouldReturnEmptyListyWhenInputIsEmpty() {
        final JSONArray jsonArray = new JSONArray();
        assertThat(mapper.map(jsonArray), hasSize(0));
    }

    @Test
    void shouldReturnResponseData() throws JSONException {
        final JSONArray jsonArray = new JSONArray();
        final JSONObject jsonObject = new JSONObject();

        jsonObject.put("id", "1123");
        jsonObject.put("name", "Whitevale Defender");
        jsonObject.put("created_at", "12324567");
        jsonArray.put(jsonObject);

        assertThat(mapper.map(jsonArray), hasSize(1));
    }

    @Test
    void shouldReturnResponse() throws JSONException {
        final JSONArray jsonArray = new JSONArray();
        final JSONObject jsonObject = new JSONObject();

        jsonObject.put("id", "2443");
        jsonObject.put("name", "Kingdom Hearts III");
        jsonObject.put("created_at", "12244567");
        jsonArray.put(jsonObject);

        assertThat(mapper.map(jsonArray), hasItem(allOf(Matchers.<VideoGame>hasProperty("title", is("Kingdom Hearts III")))));
    }
}