package com.rguerreiro.pubsub.validity;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CommandQuitTest {
	@Test
	public void testIfIsQuitReturnsTrue() {
		assertTrue(new CommandQuit().isValid("quit"));
	}

	@Test
	public void testIfIsNotQuitReturnsFalse() {
		assertFalse(new CommandQuit().isValid("q"));
	}

	@Test
	public void testIfIsNullSafe() {
		assertFalse(new CommandQuit().isValid(null));
	}
}
