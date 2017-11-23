package com.rguerreiro.pubsub.observer;

public class LeaveChannel implements Message {
	private final String participantName;
	private final String channelName;

	public LeaveChannel(String participantName, String channelName) {
		this.participantName = participantName;
		this.channelName = channelName;
	}

	public String getChannelName() {
		return channelName;
	}

	public String getParticipantName() {
		return participantName;
	}
}
