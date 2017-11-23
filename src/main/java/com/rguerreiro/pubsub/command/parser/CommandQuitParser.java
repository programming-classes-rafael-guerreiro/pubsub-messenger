package com.rguerreiro.pubsub.command.parser;

import com.rguerreiro.pubsub.Channel;
import com.rguerreiro.pubsub.observer.Messenger;

public class CommandQuitParser implements CommandParser {
	public void run(Channel channel) {
		Messenger.getInstance().publish("quit");
	}
}
