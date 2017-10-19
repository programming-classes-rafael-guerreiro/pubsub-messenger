package com.rguerreiro.pubsub.command.parser;

import com.rguerreiro.pubsub.Channel;

public class CommandLeaveChannelParser implements CommandParser {
	private final String participant;

	public CommandLeaveChannelParser(String participant) {
		this.participant = participant;
	}

	public void run(Channel channel) {
		channel.leaveChannel(participant);
	}
}
