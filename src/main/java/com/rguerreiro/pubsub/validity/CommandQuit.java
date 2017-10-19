package com.rguerreiro.pubsub.validity;

import com.rguerreiro.pubsub.command.parser.CommandParser;
import com.rguerreiro.pubsub.command.parser.CommandQuitParser;

public class CommandQuit extends CommandValidityTemplate implements CommandValidity {

	public CommandQuit() {
	}

	public CommandQuit(CommandValidity next) {
		setNext(next);
	}

	@Override
	protected boolean checkValidity(String line) {
		return "quit".equals(line);
	}

	@Override
	protected CommandParser buildParser(String line) {
		return new CommandQuitParser();
	}
}
