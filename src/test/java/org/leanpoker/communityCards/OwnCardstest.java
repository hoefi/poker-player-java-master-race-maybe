package org.leanpoker.communityCards;

import static org.junit.Assert.assertEquals;

import java.io.FileReader;

import org.junit.Test;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class OwnCardstest {
	
	@Test
	public void testName() throws Exception {
		JsonElement jsonElement = new JsonParser().parse(new FileReader("/Users/mpailer/git/poker-player-java-master-race-maybe/src/test/java/org/leanpoker/player/test.json"));

		OwnCards ownCards = new OwnCards(jsonElement);
		
		assertEquals(2, ownCards.getCardList().size());
		assertEquals(6, ownCards.getCardList().get(0).getRank());
		assertEquals("hearts", ownCards.getCardList().get(0).getSuit());
		
		assertEquals(13, ownCards.getCardList().get(1).getRank());
		assertEquals("spades", ownCards.getCardList().get(1).getSuit());
	}
}
