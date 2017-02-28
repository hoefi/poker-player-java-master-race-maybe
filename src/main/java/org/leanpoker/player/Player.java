package org.leanpoker.player;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

public class Player {

    static final String VERSION = "Default Java folding player";

    public static int betRequest(JsonElement request) {
    	try{
    		JsonElement c = request.getAsJsonObject().get("players");
    		if (c != null){
    			return 500;
    		}
    		
    	}
    	catch(Exception e){
    		System.out.println(e.getLocalizedMessage());
    	}
        return (int) (Math.random()*1000);
    }

    public static void showdown(JsonElement game) {
    }
    
    
}
