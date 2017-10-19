package com.rguerreiro.pubsub.validity;

import static org.junit.Assert.*;

import org.junit.Test;

public class CommandEnterChannelTest {

	@Test
	public void testIfThePatternIsCorrect() {
		assertEquals("^e:\\s.*?\\sc:\\s.*?$", new CommandEnterChannel().getPattern());
	}

	@Test
	public void testIfThePatternMatches() {
		assertTrue(new CommandEnterChannel().isValid("e: rafael c: channel"));
	}
}
