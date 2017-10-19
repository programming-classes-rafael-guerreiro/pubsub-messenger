package com.rguerreiro.pubsub.validity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.rguerreiro.pubsub.command.parser.CommandParser;
import com.rguerreiro.pubsub.command.parser.CommandPublishMessageParser;

public class CommandPublishMessage extends CommandValidityPatternTemplate implements CommandValidity {
	private static final String PUBLISH_MESSAGE_PATTERN = "^p:\\s.*?\\sc:\\s.*?\\sm:\\s.*?$";

	public CommandPublishMessage() {
	}

	public CommandPublishMessage(CommandValidity next) {
		setNext(next);
	}

	@Override
	protected String getPattern() {
		return PUBLISH_MESSAGE_PATTERN;
	}

	@Override
	protected CommandParser buildParser(String line) {
		return new CommandPublishMessageParser(getParticipantName('p', line), getMessage(line));
	}

	private String getMessage(String line) {
		final Pattern regex = Pattern.compile("^.*?\\sm:(.*?)$");
		final Matcher matcher = regex.matcher(line);

		if (matcher.matches())
			return matcher.group(1);

		throw new IllegalStateException("The line [" + line + "] should be valid at this point.");
	}
}
