package org.leanpoker.player;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

public class Player {

    static final String VERSION = "Default Java folding player";

    public static int betRequest(JsonElement request) {
    	try{
    		JsonElement playersElement = request.getAsJsonObject().get("players");
    		if(playersElement.isJsonArray()){
    			JsonArray playersArray = playersElement.getAsJsonArray();
    			
    			int highestBid = 0;
    			
    			for(JsonElement player : playersArray){
    				if(!player.getAsJsonObject().get("name").equals("Java Master Race Maybe")){
    					if(player.getAsJsonObject().get("bet").getAsInt() > highestBid){
    						highestBid = player.getAsJsonObject().get("bet").getAsInt();
    					}
    				}
    			}
    				
    			return highestBid + 5;
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
