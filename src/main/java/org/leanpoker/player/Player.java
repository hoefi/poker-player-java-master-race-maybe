package org.leanpoker.player;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

public class Player {

    static final String VERSION = "Default Java folding player";

    public static int betRequest(JsonElement request) {
    	try{
    		JsonElement playersElement = request.getAsJsonObject().get("players");
    		boolean playOn = false;
    		
    		if(playersElement.isJsonArray()){
    			JsonArray playersArray = playersElement.getAsJsonArray();
    			
    			int highestBid = 0;
    			
				for (JsonElement player : playersArray) {

					if (!player.getAsJsonObject().get("name").getAsString().contains("Java Master Race Maybe")) {
						int playerBet = player.getAsJsonObject().get("bet").getAsInt();
						if (playerBet > highestBid) {
							highestBid = playerBet;
							System.err.println("Set highest bid to: " + highestBid);
						}
					}
				}
    			
    			for(JsonElement player : playersArray){
    				if(player.getAsJsonObject().get("name").getAsString().contains("Java Master Race Maybe")){
    					
    					JsonElement cardsElement = player.getAsJsonObject().get("hole_cards");
						if(cardsElement.isJsonArray()){
							JsonArray  cardsArray = cardsElement.getAsJsonArray();
							int rankCard1 = mapRankToInteger(cardsArray.get(0).getAsJsonObject().get("rank").getAsString());
							int rankCard2 = mapRankToInteger(cardsArray.get(1).getAsJsonObject().get("rank").getAsString());
							
							System.err.println("Card1:" + rankCard1);
							System.err.println("Card2:" + rankCard2);
							
							playOn = isPair(rankCard1, rankCard2) || isHighCard(rankCard1, rankCard2);
						}
    				} 
    			}
    			
    			System.err.println("Palying on: " + playOn);
    			
    			if(playOn){
    				return highestBid + 5;
    			} else {
    				return 0;
    			}
    			
    		}
    		
    	}
    	catch(Exception e){
    		System.err.println(e.getLocalizedMessage());
    	}
        return 0;
    }

    private static boolean isPair(int rankCard1, int rankCard2){
    	return rankCard1 == rankCard2;
    }
    
	private static boolean isHighCard(int rankCard1, int rankCard2) {
		return (rankCard1 >= 10 && rankCard2 >= 10);
	}

    public static void showdown(JsonElement game) {
    }
    
    private static int mapRankToInteger(String rankString){
    	int convertedRank = 0;
    	
    	System.err.println("Rank as String: " + rankString);
    	
    	if("2".equals(rankString)){
    		convertedRank = 2;
    	}
    	if("3".equals(rankString)){
    		convertedRank = 3;
    	}
    	if("4".equals(rankString)){
    		convertedRank = 4;
    	}
    	if("5".equals(rankString)){
    		convertedRank = 5;
    	}
    	if("6".equals(rankString)){
    		convertedRank = 6;
    	}
    	if("7".equals(rankString)){
    		convertedRank = 7;
    	}
    	if("8".equals(rankString)){
    		convertedRank = 8;
    	}
    	if("9".equals(rankString)){
    		convertedRank = 9;
    	}
    	if("10".equals(rankString)){
    		convertedRank = 10;
    	}
    	if("J".equals(rankString)){
    		convertedRank = 11;
    	}
    	if("Q".equals(rankString)){
    		convertedRank = 12;
    	}
    	if("K".equals(rankString)){
    		convertedRank = 13;
    	}
    	if("A".equals(rankString)){
    		convertedRank = 14;
    	}
    	
    	return convertedRank;
    }
    
    
}
