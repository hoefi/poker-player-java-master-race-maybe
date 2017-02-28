package org.leanpoker.player;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

import java.io.FileReader;

public class PlayerTest {

	@Ignore
    @Test
    public void testBetRequest() throws Exception {

        JsonElement jsonElement = new JsonParser().parse(new FileReader("/Users/mpailer/git/poker-player-java-master-race-maybe/src/test/java/org/leanpoker/player/test.json"));

        jsonElement.getAsJsonObject().get("players");
        Assert.assertNotNull(jsonElement);
        assertEquals(0, Player.betRequest(jsonElement));

    }
}
