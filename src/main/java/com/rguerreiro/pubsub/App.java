package com.rguerreiro.pubsub;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.rguerreiro.pubsub.command.parser.CommandParser;
import com.rguerreiro.pubsub.validity.CommandEnterChannel;
import com.rguerreiro.pubsub.validity.CommandLeaveChannel;
import com.rguerreiro.pubsub.validity.CommandPublishMessage;
import com.rguerreiro.pubsub.validity.CommandQuit;

public class App {
	private static final Map<String, Channel> channels = new HashMap<>();

	public static void main(String[] args) {
		// e: person name c: channel -> enter on the channel
		// l: person name c: channel -> leave channel
		// p: person name c: channel m: message -> publish message from person
		// in the channel
		// quit -> terminates the application

		System.out.println("Welcome to the Chat app.");

		try (final Scanner scanner = new Scanner(System.in)) {
			String line;

			do {
				line = harmonize(scanner.nextLine());
				final CommandParser parser = getParser(line);

				if (parser != null) {
					System.out.println("Line is: " + line);
					parser.run(getChannel(line));
				} else {
					System.out.println("Invalid command, try again.");
				}
			} while (!"quit".equals(line));

			System.out.println("Finished the App.");
		}
	}

	private static CommandParser getParser(String line) {
		final CommandPublishMessage publishMessage = new CommandPublishMessage();
		final CommandLeaveChannel leaveChannel = new CommandLeaveChannel(publishMessage);
		final CommandEnterChannel enterChannel = new CommandEnterChannel(leaveChannel);
		final CommandQuit quit = new CommandQuit(enterChannel);

		return quit.getParser(line);
	}

	private static String harmonize(String line) {
		if (line == null || line.trim().isEmpty())
			return "";

		return line.trim().toLowerCase();
	}

	private static Channel getChannel(String line) {
		Pattern regex = Pattern.compile("c:\\s(.*?)(\\sm:.*?)?$");
		Matcher matcher = regex.matcher(line);

		if (matcher.find()) {
			final String channel = matcher.group(1);
			// return channels.computeIfAbsent(channel, (channelName) -> new Channel(channelName));
			return channels.computeIfAbsent(channel, Channel::new);
		}

		return null;
	}
}
