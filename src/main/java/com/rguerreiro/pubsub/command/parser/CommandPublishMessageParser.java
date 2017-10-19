package com.rguerreiro.pubsub.command.parser;

import com.rguerreiro.pubsub.Channel;

public class CommandPublishMessageParser implements CommandParser {
	private final String participant;
	private final String message;

	public CommandPublishMessageParser(String participant, String message) {
		this.participant = participant;
		this.message = message;
	}

	public void run(Channel channel) {
		channel.getParticipants().stream().filter(this::isNotMe).forEach(this::publishMessage);
	}

	private boolean isNotMe(String participant) {
		return !this.participant.equals(participant);
	}

	private void publishMessage(String participant) {
		System.out.println("@" + participant + " -> " + message);
	}
}
