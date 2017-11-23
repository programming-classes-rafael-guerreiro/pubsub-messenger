package com.rguerreiro.pubsub.command.parser;

import com.rguerreiro.pubsub.Channel;
import com.rguerreiro.pubsub.observer.EnterChannel;
import com.rguerreiro.pubsub.observer.Messenger;

public class CommandEnterChannelParser implements CommandParser {
	private final String participant;

	public CommandEnterChannelParser(String participant) {
		this.participant = participant;
	}

	public void run(Channel channel) {
//		Messenger.getInstance().publish(new EnterChannel(participant, channel.getName()));
		
		channel.enterChannel(participant);
	}
}
