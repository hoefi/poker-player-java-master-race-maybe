package org.leanpoker.communityCards;

import com.google.gson.JsonElement;

public class Card {
	private int rank;
	private String suit;
	
	public Card(JsonElement card) {
		rank = mapRankToInteger(card.getAsJsonObject().get("rank").getAsString());
		suit = card.getAsJsonObject().get("suit").getAsString();
	}
	
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public String getSuit() {
		return suit;
	}
	public void setSuit(String suit) {
		this.suit = suit;
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
