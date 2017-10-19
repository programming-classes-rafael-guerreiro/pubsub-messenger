package com.rguerreiro.pubsub.validity;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doReturn;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class CommandValidityTemplateTest {

	@Mock
	private CommandValidityTemplate target;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testIfIsValidReturnsTrueWhenCheckValidityIsTrue() {
		doReturn(true).when(target).checkValidity(Mockito.any()); // Proxy
		assertTrue(target.isValid(""));

		// assertTrue(new MockedCommandValidityTemplate(true).isValid(""));
	}

	@Test
	public void testIfIsValidReturnsFalseWhenCheckValidityIsFalseAndNextIsNull() {
		doReturn(false).when(target).checkValidity(Mockito.any()); // Proxy
		assertFalse(target.isValid(""));

		// assertFalse(new MockedCommandValidityTemplate(false).isValid(""));
	}

	// @Override
	// public final boolean isValid(String line) {
	// if (checkValidity(line))
	// return true;
	//
	// if (next == null)
	// return false;
	//
	// return next.isValid(line);
	// }
	//
	// @Override
	// public final void setNext(CommandValidity next) {
	// this.next = next;
	// }

	// Mockito
	// private static class MockedCommandValidityTemplate extends
	// CommandValidityTemplate implements CommandValidity {
	// private final boolean returnValue;
	//
	// private MockedCommandValidityTemplate(boolean returnValue) {
	// this.returnValue = returnValue;
	// }
	//
	// @Override
	// protected boolean checkValidity(String line) {
	// return returnValue;
	// }
	// }
}
