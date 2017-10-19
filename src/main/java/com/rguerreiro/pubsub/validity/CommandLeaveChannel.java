package com.rguerreiro.pubsub.validity;

import com.rguerreiro.pubsub.command.parser.CommandLeaveChannelParser;
import com.rguerreiro.pubsub.command.parser.CommandParser;

public class CommandLeaveChannel extends CommandValidityPatternTemplate implements CommandValidity {
	private static final String LEAVE_CHANNEL_PATTERN = "^l:\\s.*?\\sc:\\s.*?$";

	public CommandLeaveChannel() {
	}

	public CommandLeaveChannel(CommandValidity next) {
		setNext(next);
	}

	@Override
	protected String getPattern() {
		return LEAVE_CHANNEL_PATTERN;
	}
	
	@Override
	protected CommandParser buildParser(String line) {
		return new CommandLeaveChannelParser(getParticipantName('l', line));
	}
}
