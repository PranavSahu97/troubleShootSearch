package troubleShootSearch.util;

public class MyLogger {

	public static enum DebugLevel {
		CONSTRUCTOR, NONE, SemanticSearch, NaiveSearch, ExactSearch
	};

	private static DebugLevel debugLevel;

	public static void setDebugValue(int levelIn) {
		switch (levelIn) {
		case 4:	debugLevel = DebugLevel.SemanticSearch;
			break;
		case 3:	debugLevel = DebugLevel.NaiveSearch;
			break;
		case 2:	debugLevel = DebugLevel.ExactSearch;
			break;
		case 1:	debugLevel = DebugLevel.CONSTRUCTOR;
			break;
		default: debugLevel = DebugLevel.NONE;
			break;
		}
	}

	public static void setDebugValue(DebugLevel levelIn) {
		debugLevel = levelIn;
	}

	/**
	 * Print the message in console if the debug level provided is same as the one
	 * set in Driver
	 * 
	 * @param message
	 * @param levelIn
	 */
	public static void writeMessage(String message, DebugLevel levelIn) {
		if (levelIn == debugLevel)
			System.out.println(message);
	}

	public String toString() {
		return "The debug level has been set to the following " + debugLevel;
	}
}