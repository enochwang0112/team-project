package framework_and_drivers.external;

import entities.ChessGame;
import entities.UserProfile;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import usecases.api_interfaces.IChessRepo;
import usecases.api_interfaces.IUserProfileRepo;
import utils.JSONParser;


import java.awt.*;
import java.util.ArrayList;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;



public class ChessAPI implements IChessRepo, IUserProfileRepo {


    private static final String PLAYER_URL = "https://api.chess.com/pub/player/";
    private static final String CACHE_DIR = "data/chess_cache/";
    private final OkHttpClient client;

    public ChessAPI() {
        this.client = new OkHttpClient();
    }

    private String executeGet(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .header("User-Agent", "JavaCleanArchChessApp/1.0 (contact: dev@example.com)")
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful() || response.body() == null) {
                throw new IOException("Unexpected HTTP response " + response.code() + " for " + url);
            }
            return response.body().string();
        }
    }

    @Override
    public UserProfile getUserProfile(String username){
        try {
            // 1. Fetch JSON via OkHttp
            String rawJson = executeGet(PLAYER_URL + username);

            // 2. Save filtered JSON (only your 6 fields) to a local .json file
            String avatar = getStringProperty("avatar", rawJson, "");
            long playerId = getLongProperty("player_id", rawJson, 0L);
            String apiId = getStringProperty("@id", rawJson, "");
            String url = getStringProperty("url", rawJson, "");
            String parsedUsername = getStringProperty("username", rawJson, username);
            String name = getStringProperty("name", rawJson, parsedUsername);

            saveFilteredProfileJson(parsedUsername, avatar, playerId, apiId, url, name);

            // 3. Return populated UserProfile entity
            return new UserProfile(avatar, playerId, apiId, url, name, parsedUsername);

        } catch (IOException e) {
            throw new RuntimeException("Failed to fetch user profile for: " + username, e);
        }
    }

    String rawJson = fetchJsonFromUrl(PLAYER_URL + username);
    public ArrayList<ChessGame> getGames(String username) {
        // TODO: Implement this method
        return null;
    }

    public Image getProfilePicture(String username){
        // TODO: Implement this method
        return null;
    }
}
