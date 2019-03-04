package gamelibrarycollection.com.gamelibrary;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import gamelibrarycollection.com.gamelibrary.models.VideoGame;

class VideoGameMapper {

    List<VideoGame> map(JSONArray responseArray){
        List<VideoGame> games = new ArrayList<>();
        if(null == responseArray){
            throw new NullPointerException();
        }

        for(int i=0; i < responseArray.length(); i++){
            JSONObject object = responseArray.optJSONObject(i);
            VideoGame game = new VideoGame();
            if(null != object){
                try {
                    //todo: Will add other properties later
                    game.setTitle(object.get("name").toString());
                    games.add(game);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        return games;
    }
}
