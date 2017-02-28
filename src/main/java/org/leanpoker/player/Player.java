package org.leanpoker.player;

import org.leanpoker.communityCards.Card;
import org.leanpoker.communityCards.CommunityCards;
import org.leanpoker.communityCards.OwnCards;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

public class Player {

    static final String VERSION = "Default Java folding player";

    public static int betRequest(JsonElement request) {
    	
    	CommunityCards communityCards = new CommunityCards(request);
    	OwnCards ownCards = new OwnCards(request);
    	
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
				
				Card card1 = ownCards.getCardList().get(0);
				Card card2 = ownCards.getCardList().get(1);
				
				playOn = isHighPair(card1, card2) || isHighCard(card1, card2) || isSameColorAndHighCard(card1, card2);

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

    private static boolean isHighPair(Card card1, Card card2){
    	return (card1.getRank() > 6) && (card1.getRank() == card2.getRank());
    }
    
	private static boolean isHighCard(Card card1, Card card2) {
		return (card1.getRank() >= 10 && card2.getRank() >= 10);
	}
	
	private static boolean isSameColorAndHighCard(Card card1, Card card2) {
		boolean playOn = false;
		if(card1.getSuit().equals(card2.getSuit()) && (card1.getRank() >= 10 || card2.getRank() >= 10)){
			playOn = true;
		}
		return playOn;
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
