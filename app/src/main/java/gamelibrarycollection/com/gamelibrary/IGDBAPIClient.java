package gamelibrarycollection.com.gamelibrary;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

import callback.OnSuccessCallback;
import gamelibrarycollection.com.gamelibrary.models.VideoGame;
import wrapper.Endpoints;
import wrapper.IGDBWrapper;
import wrapper.Parameters;
import wrapper.Version;


class IGDBAPIClient {

    private final String API_KEY = "12345FAKE";
    private IGDBWrapper wrapper;
    private List<VideoGame> games;

    public IGDBWrapper getWrapperInstance() {
        if (null == wrapper) {
            wrapper = new IGDBWrapper(API_KEY, Version.STANDARD, false);
        }

        return wrapper;
    }


    public List<VideoGame> getGameData(Parameters gameParams) {
        gameParams = new Parameters()
                .addSearch("")
                .addFields("*");

        wrapper.search(Endpoints.GAMES, gameParams, new OnSuccessCallback(){

            @Override
            public void onSuccess(@NotNull JSONArray jsonArray) {
                //Will do the mapping here
                VideoGameMapper mapper = new VideoGameMapper();
                games = mapper.map(jsonArray);
            }

            @Override
            public void onError(@NotNull Exception e) {
                //todo: add exception logic here
                //Do nothing....FOR NOW
            }
        });

        return games;
    }
}
