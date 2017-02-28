package org.leanpoker.player;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import java.util.Map;

public class Player {

    static final String VERSION = "Default Java folding player";

    public static int betRequest(JsonElement request) {
    	JsonArray asJsonArray = request.getAsJsonArray();
    	
    	
        return 499;
    }

    public static void showdown(JsonElement game) {
    }
    
    
}
