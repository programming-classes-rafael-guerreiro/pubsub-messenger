package com.rguerreiro.pubsub.validity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CommandLeaveChannelTest {

	@Test
	public void testIfThePatternIsCorrect() {
		assertEquals("^l:\\s.*?\\sc:\\s.*?$", new CommandLeaveChannel().getPattern());
	}

	@Test
	public void testIfThePatternMatches() {
		assertTrue(new CommandLeaveChannel().isValid("l: rafael c: channel"));
	}
}
