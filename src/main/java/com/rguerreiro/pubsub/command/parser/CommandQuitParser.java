package com.rguerreiro.pubsub.command.parser;

import com.rguerreiro.pubsub.Channel;

public class CommandQuitParser implements CommandParser {
	public void run(Channel channel) {
		System.exit(0);
	}
}
