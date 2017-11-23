package com.rguerreiro.pubsub.observer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Consumer;

public class Messenger { // Singleton -> Dependency Injection

	private final static Messenger instance = new Messenger();

	public static Messenger getInstance() {
		return instance;
	}

	@SuppressWarnings("rawtypes")
	private final Map<Class, Set<Consumer>> subscribers = new HashMap<>();

	private Messenger() {
	}

	public <T extends Message> void subscribe(Class<T> type, Consumer<? super T> consumer) {
		if (type == null || consumer == null)
			return;

		subscribers.computeIfAbsent(type, (key) -> new HashSet<>()).add(consumer);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void publish(Message message) {
		if (message == null)
			return;

		final Class publishedClass = message.getClass();
		final Set<Consumer> subscribers = new HashSet<>();

		final Set<Entry<Class, Set<Consumer>>> entrySet = this.subscribers.entrySet();
		for (Entry<Class, Set<Consumer>> entry : entrySet) {
			Class subscribedClass = entry.getKey();

			if (subscribedClass.isAssignableFrom(publishedClass))
				subscribers.addAll(entry.getValue());
		}

		for (Consumer c : subscribers)
			c.accept(message);
	}
}
