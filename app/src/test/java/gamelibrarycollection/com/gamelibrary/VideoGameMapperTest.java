package gamelibrarycollection.com.gamelibrary;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
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
}