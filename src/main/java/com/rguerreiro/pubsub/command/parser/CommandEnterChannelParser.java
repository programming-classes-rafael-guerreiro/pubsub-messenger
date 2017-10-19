package com.rguerreiro.pubsub.command.parser;

import com.rguerreiro.pubsub.Channel;

public class CommandEnterChannelParser implements CommandParser {
	private final String participant;

	public CommandEnterChannelParser(String participant) {
		this.participant = participant;
	}

	public void run(Channel channel) {
		channel.enterChannel(participant);
	}
}
