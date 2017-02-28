package org.leanpoker.player;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

public class Player {

    static final String VERSION = "Default Java folding player";

    public static int betRequest(JsonElement request) {
    	try{
    		JsonArray asJsonArray = request.getAsJsonArray();
    		for(Object o : asJsonArray){
    			System.out.println(o.toString());
    		}
    	}
    	catch(Exception e){
    		System.out.println(e.getLocalizedMessage());
    	}
        return 205;
    }

    public static void showdown(JsonElement game) {
    }
    
    
}
