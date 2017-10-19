package com.rguerreiro.pubsub.validity;

import com.rguerreiro.pubsub.command.parser.CommandParser;

public interface CommandValidity {
	CommandParser getParser(String line);
	
	void setNext(CommandValidity next);
}
