package com.rguerreiro.pubsub.validity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract class CommandValidityPatternTemplate extends CommandValidityTemplate implements CommandValidity {

	@Override
	protected boolean checkValidity(String line) {
		return line.matches(getPattern());
	}

	protected abstract String getPattern();

	protected final String getParticipantName(char key, String line) {
		final Pattern regex = Pattern.compile("^" + key + ":\\s(.*?)\\sc:.*?$");
		final Matcher matcher = regex.matcher(line);

		if (matcher.matches())
			return matcher.group(1);

		throw new IllegalStateException("The line [" + line + "] should be valid at this point.");
	}
}
