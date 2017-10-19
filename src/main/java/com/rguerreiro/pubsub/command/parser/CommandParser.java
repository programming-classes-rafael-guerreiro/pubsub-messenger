package com.rguerreiro.pubsub.command.parser;

import com.rguerreiro.pubsub.Channel;

public interface CommandParser {
	void run(Channel channel);
}
