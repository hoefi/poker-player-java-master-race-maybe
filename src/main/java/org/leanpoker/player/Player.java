package org.leanpoker.player;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import java.util.Map;

public class Player {

    static final String VERSION = "Default Java folding player";

    public static int betRequest(JsonElement request) {
    	JsonArray asJsonArray = request.getAsJsonArray();
    	System.out.println(request);
    	
    	for(Object o : asJsonArray){
    		System.out.println(o.toString());
    	}
    	
    	
        return 499;
    }

    public static void showdown(JsonElement game) {
    }
    
    
}
