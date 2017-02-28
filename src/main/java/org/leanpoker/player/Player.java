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
    				if(player.getAsJsonObject().get("name").equals("Java Master Race Maybe")){
    					JsonElement cardsElement = player.getAsJsonObject().get("hole_cards");
						if(cardsElement.isJsonArray()){
							JsonArray  cardsArray = cardsElement.getAsJsonArray();
							int rankCard1 = mapRankToInteger(cardsArray.get(0).getAsJsonObject().get("rank").getAsString());
							int rankCard2 = mapRankToInteger(cardsArray.get(1).getAsJsonObject().get("rank").getAsString());
							
							System.err.println("Card1:" + rankCard1);
							System.err.println("Card2:" + rankCard2);
							
							if(playOn(rankCard1, rankCard2)){
								if(!player.getAsJsonObject().get("name").equals("Java Master Race Maybe")){
			    					int playerBet = player.getAsJsonObject().get("bet").getAsInt();
									if(playerBet > highestBid){
			    						highestBid = playerBet;
			    					}
			    				}
								highestBid += 5;
							}
						}
    				}
    			}
    				
    			return highestBid;
    		}
    		
    	}
    	catch(Exception e){
    		System.out.println(e.getLocalizedMessage());
    	}
        return 0;
    }

	private static boolean playOn(int rankCard1, int rankCard2) {
		return rankCard1 == rankCard2 || (rankCard1 >= 10 && rankCard2 >= 10);
	}

    public static void showdown(JsonElement game) {
    }
    
    private static int mapRankToInteger(String rankStrink){
    	int convertedRank = 0;
    	
    	if("2".equals(rankStrink)){
    		convertedRank = 2;
    	}
    	if("3".equals(rankStrink)){
    		convertedRank = 3;
    	}
    	if("4".equals(rankStrink)){
    		convertedRank = 4;
    	}
    	if("5".equals(rankStrink)){
    		convertedRank = 5;
    	}
    	if("6".equals(rankStrink)){
    		convertedRank = 6;
    	}
    	if("7".equals(rankStrink)){
    		convertedRank = 7;
    	}
    	if("8".equals(rankStrink)){
    		convertedRank = 8;
    	}
    	if("9".equals(rankStrink)){
    		convertedRank = 9;
    	}
    	if("10".equals(rankStrink)){
    		convertedRank = 10;
    	}
    	if("J".equals(rankStrink)){
    		convertedRank = 11;
    	}
    	if("Q".equals(rankStrink)){
    		convertedRank = 12;
    	}
    	if("K".equals(rankStrink)){
    		convertedRank = 13;
    	}
    	if("A".equals(rankStrink)){
    		convertedRank = 14;
    	}
    	
    	return convertedRank;
    }
    
    
}
