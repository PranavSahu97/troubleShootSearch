package troubleShootSearch.driver;

import java.util.ArrayList;


import troubleShootSearch.context.Search;
import troubleShootSearch.util.FileProcessor;
import troubleShootSearch.util.MyLogger;
import troubleShootSearch.util.Results;

public class Driver{

	//public String inputFilePath1;
	public static String inputFilePath2;
	public static String inputFilePath3;
	public static String inputFilePath4;
	public static String inputFilePath5;
	public static String inputFilePath6;
	public static String outputFilePath;
	public static int debugLevel;

	public static void main(String [] args){
		if (args.length != 8 || args[0].equals("${arg0}") || args[1].equals("${arg1}") || args[2].equals("${arg2}") || args[3].equals("${arg3}") || args[4].equals("${arg4}") || args[5].equals("${arg5}") || args[6].equals("${arg6}") || args[7].equals("${arg7}")) {
			System.err.println("Error: Incorrect number of arguments. Program accepts 7 arguments.");
			System.exit(0);
		}
		
		String inputFilePath1 = args[0];
		inputFilePath2 = args[1];
		inputFilePath3 = args[2];
		inputFilePath4 = args[3];
		inputFilePath5 = args[4];
		inputFilePath6 = args[5];
		outputFilePath = args[6];
		int debugValue=Integer.parseInt(args[7]);
 		MyLogger.setDebugValue(debugValue);
		Results results = new Results();
		Search search = new Search(results, inputFilePath1);
		search.doSearch();
	}
}