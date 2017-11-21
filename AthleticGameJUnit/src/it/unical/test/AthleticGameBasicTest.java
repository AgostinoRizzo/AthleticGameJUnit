package it.unical.test;

import java.time.Instant;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import it.unical.game.AthleticGame;

public class AthleticGameBasicTest {

	private AthleticGame game = null;
	
	@Before
	public void beforeEachTest() {
		game = new AthleticGame("Running");
	}
	
	@Test
	public void addFirstArrivalWorks() {
		game.addArrival("Pippo", Instant.now());
		Assert.assertEquals(game.getArrivals().size(), 1);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void getPartecipantTimeWorks() {
		game.addArrival("Pippo", Instant.now());
		game.addArrival("Pluto", Instant.now());
		game.getParecipiantTime("Topolino");
	}
	
	
}
