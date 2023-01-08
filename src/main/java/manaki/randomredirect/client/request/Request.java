package manaki.randomredirect.client.request;

import com.google.gson.GsonBuilder;

import java.util.UUID;

public class Request {

    private final UUID id;

    private final String player;

    public Request(UUID id, String player) {
        this.id = id;
        this.player = player;
    }

    public UUID getId() {
        return id;
    }

    public String getPlayer() {
        return player;
    }

    public String toString() {
        return new GsonBuilder().create().toJson(this);
    }

    public static Request parse(String requestString) {
        return new GsonBuilder().create().fromJson(requestString, Request.class);
    }
}

