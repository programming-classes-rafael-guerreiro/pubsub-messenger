package com.rguerreiro.pubsub.validity;

import com.rguerreiro.pubsub.command.parser.CommandEnterChannelParser;
import com.rguerreiro.pubsub.command.parser.CommandParser;

public class CommandEnterChannel extends CommandValidityPatternTemplate implements CommandValidity {
	private static final String ENTER_CHANNEL_PATTERN = "^e:\\s.*?\\sc:\\s.*?$";

	public CommandEnterChannel() {
	}

	public CommandEnterChannel(CommandValidity next) {
		setNext(next);
	}

	@Override
	protected String getPattern() {
		return ENTER_CHANNEL_PATTERN;
	}

	@Override
	protected CommandParser buildParser(String line) {
		return new CommandEnterChannelParser(getParticipantName('e', line));
	}
}
