package com.codewars.esolang;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.codewars.utility.Handler;

public class EsolangInterpreter {

	private static List<Handler> handler;
	private static String code;

	public EsolangInterpreter(String code) {
		EsolangInterpreter.code = code.replaceAll("[^\\+\\.]", "");
		EsolangInterpreter.handler = new ArrayList<Handler>();

	}

	public String interpret() {

		Pattern pattern = Pattern.compile("(\\++)(\\.+)");
		Matcher matcher = pattern.matcher(EsolangInterpreter.code);
		int currentCount = -1;

		while (matcher.find()) {

			if (EsolangInterpreter.handler.isEmpty()) {
				currentCount = matcher.group(1).length();
			} else {

				currentCount = EsolangInterpreter.counter(currentCount, matcher.group(1).length());
			}

			EsolangInterpreter.handler.add(new Handler(currentCount, matcher.group(2).length()));

		}

		List<String> output = new ArrayList<String>();

		for (Handler handler : EsolangInterpreter.handler) {
			for (int i = 0; i < handler.getRepeat(); i++) {
				char ascii = (char) handler.getCode();
				output.add(String.valueOf(ascii));
			}
		}
		return String.join("", output);
	}

	public static int counter(int count, int remaining) {
		int i = 0;
		int c = count;
		while (i < remaining) {
			if (c < 255) {
				c += 1;
			} else {
				c = 0;
			}
			i++;
		}
		return c;
	}

}
