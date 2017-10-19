package com.rguerreiro.pubsub.validity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CommandPublishMessageTest {

	@Test
	public void testIfThePatternIsCorrect() {
		assertEquals("^p:\\s.*?\\sc:\\s.*?\\sm:\\s.*?$", new CommandPublishMessage().getPattern());
	}

	@Test
	public void testIfThePatternMatches() {
		assertTrue(new CommandPublishMessage().isValid("p: rafael c: channel m: my message"));
	}
}
