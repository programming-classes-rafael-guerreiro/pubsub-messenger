package com.rguerreiro.pubsub;

import static java.util.Collections.unmodifiableSet;

import java.util.HashSet;
import java.util.Set;

import com.rguerreiro.pubsub.observer.EnterChannel;
import com.rguerreiro.pubsub.observer.Messenger;

public class Channel {
	private final String name;
	private final Set<String> participants = new HashSet<>();

	public Channel(String name) {
		this.name = name;

		Messenger.getInstance().subscribe(EnterChannel.class, (message) -> {
			enterChannel(message.getParticipantName());
		});
		
		
		Messenger.getInstance().subscribe("enter_channel" + name, () -> {
			enterChannel("Rafael");
		});

		Messenger.getInstance().subscribe("leave_channel" + name, () -> {
			leaveChannel("Rafael");
		});
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Channel other = (Channel) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public void enterChannel(String participant) {
		if (isEmpty(participant))
			return;

		participants.add(harmonize(participant));
	}

	public void leaveChannel(String participant) {
		if (isEmpty(participant))
			return;

		participants.remove(harmonize(participant));
	}

	public Set<String> getParticipants() {
		return unmodifiableSet(participants);
	}

	private static boolean isEmpty(String participant) {
		return participant == null || participant.trim().isEmpty();
	}

	private static String harmonize(String name) {
		return name.trim().toLowerCase();
	}
}
