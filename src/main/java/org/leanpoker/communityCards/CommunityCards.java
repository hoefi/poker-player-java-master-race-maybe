package org.leanpoker.communityCards;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

public class CommunityCards {
	private List<Card> cardList = new ArrayList();
	
	public CommunityCards(JsonElement jsonElement) {
		JsonArray communityCardsArray = jsonElement.getAsJsonObject().get("community_cards").getAsJsonArray();
		for(JsonElement card : communityCardsArray){
			cardList.add(new Card(card));
		}
	}

	public List<Card> getCardList() {
		return cardList;
	}

	public void setCardList(List<Card> cardList) {
		this.cardList = cardList;
	}
	
	
}
