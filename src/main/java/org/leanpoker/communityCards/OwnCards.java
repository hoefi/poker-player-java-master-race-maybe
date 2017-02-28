package org.leanpoker.communityCards;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

public class OwnCards {
private List<Card> cardList = new ArrayList();
	
	public OwnCards(JsonElement request) {
		 JsonArray players = request.getAsJsonObject().get("players").getAsJsonArray();
		
		for(JsonElement player : players){
			if(player.getAsJsonObject().get("name").getAsString().contains("Java Master Race Maybe")){
				for(JsonElement card : player.getAsJsonObject().get("hole_cards").getAsJsonArray()){
					cardList.add(new Card(card));
				}
			}
		}
		
	}

	public List<Card> getCardList() {
		return cardList;
	}

	public void setCardList(List<Card> cardList) {
		this.cardList = cardList;
	}
}
