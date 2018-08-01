package wordCount.util;
/**
 * The  program implements an application that
 * helps in debugging
 * @author  Gaurang Dhake,Manu Sharma
 * @version 1.0
 * @since   08-03-2018
 */
public class MyLogger {
	public static enum DebugLevel { CONSTRUCTOR, FILE_PROCESSOR ,RESULTS,PopulateTree,TotalCharacters,TotalWords,UniqueWords,TreeBuilder,Node,NONE;

	};

	private static DebugLevel debugLevel;


	// FIXME: Add switch cases for all the levels
	public static DebugLevel setDebugValue (int levelIn) {
		switch (levelIn) {
			case 1: debugLevel = DebugLevel.CONSTRUCTOR; break;
			case 2: debugLevel = DebugLevel.FILE_PROCESSOR; break;
			case 3: debugLevel = DebugLevel.RESULTS; break;
			case 4: debugLevel = DebugLevel.PopulateTree; break;
			case 5: debugLevel = DebugLevel.TotalCharacters; break;
			case 6: debugLevel = DebugLevel.TotalWords; break;
			case 7: debugLevel = DebugLevel.UniqueWords; break;
			case 8: debugLevel = DebugLevel.TreeBuilder; break;
            case 9: debugLevel = DebugLevel.Node; break;
			default: debugLevel = DebugLevel.NONE; break;
		}
		return debugLevel;
	}

	public static void setDebugValue (DebugLevel levelIn) {
		debugLevel = levelIn;
	}

	public static void writeMessage (String     message  ,
									 DebugLevel levelIn ) {
		if (levelIn == debugLevel)
			System.out.println(message);
	}

	public String toString() {
		return "The debug level has been set to the following " + debugLevel;
	}
}