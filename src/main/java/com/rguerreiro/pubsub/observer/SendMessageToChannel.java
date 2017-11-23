package com.rguerreiro.pubsub.observer;

public class SendMessageToChannel implements Message {
	private final String participantName;
	private final String channelName;
	private final String message;

	public SendMessageToChannel(String participantName, String channelName, String message) {
		this.participantName = participantName;
		this.channelName = channelName;
		this.message = message;
	}

	public String getChannelName() {
		return channelName;
	}

	public String getParticipantName() {
		return participantName;
	}

	public String getMessage() {
		return message;
	}
}
