package org.leanpoker.communityCards;

import static org.junit.Assert.*;

import java.io.FileReader;

import org.junit.Test;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class CommunityCardsTest {
	
	@Test
	public void testName() throws Exception {
		JsonElement jsonElement = new JsonParser().parse(new FileReader("/Users/mpailer/git/poker-player-java-master-race-maybe/src/test/java/org/leanpoker/player/test.json"));

		CommunityCards communityCards = new CommunityCards(jsonElement);
		
		assertEquals(3, communityCards.getCardList().size());
		assertEquals(4, communityCards.getCardList().get(0).getRank());
		assertEquals("spades", communityCards.getCardList().get(0).getSuit());
	}
}
