package com.rguerreiro.pubsub.validity;

import com.rguerreiro.pubsub.command.parser.CommandParser;

abstract class CommandValidityTemplate implements CommandValidity {

	private CommandValidity next;

	@Override
	public final CommandParser getParser(String line) {
		if (checkValidity(line))
			return buildParser(line);

		if (next == null)
			return null;

		return next.getParser(line);
	}

	protected abstract boolean checkValidity(String line);

	protected abstract CommandParser buildParser(String line);

	@Override
	public final void setNext(CommandValidity next) {
		this.next = next;
	}
}
