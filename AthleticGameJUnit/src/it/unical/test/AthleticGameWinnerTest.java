package it.unical.test;

import java.time.Instant;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import it.unical.game.AthleticGame;

public class AthleticGameWinnerTest {

	private static AthleticGame game = null;
	
	@BeforeClass
	public static void initialization() {
		game = new AthleticGame("Running");
	}
	
	@After
	public void afterEachTest() {
		game.reset();
	}
	
	@Before
	public void beforeEachTest() {
		game.start();
	}
	
	@Test
	public void getWinnerWorks() {
		game.addArrival("Pippo", Instant.now());
		game.addArrival("Pluto", Instant.now().plusMillis(1000));
		game.addArrival("Topolino", Instant.now().plusMillis(3000));
		Assert.assertEquals(game.getWinner(), "Pippo");
	}
	
	@Test
	public void getWinnerNullWorks() {
		Assert.assertNull(game.getWinner());
	}
	
}
