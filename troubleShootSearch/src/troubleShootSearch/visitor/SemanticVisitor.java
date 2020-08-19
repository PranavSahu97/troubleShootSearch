package troubleShootSearch.visitor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.BufferedReader;


import troubleShootSearch.driver.Driver;
import troubleShootSearch.dSeaGate.*;
import troubleShootSearch.util.FileProcessor;
import troubleShootSearch.util.MyLogger;
import troubleShootSearch.util.Results;
import troubleShootSearch.util.MyLogger.DebugLevel;

public class SemanticVisitor implements SearchVisitor{
	public static BufferedReader br = null;
	public SemanticVisitor(){

	}
	@Override
	public void visit(DSeaGate product, Results results,String inputFilePath){
		MyLogger.writeMessage("Semantic Search", DebugLevel.SemanticSearch);
		results.writeToFile("Semantic Search");
		HashMap<String, ArrayList<String>> synonymMap = getSynonymMatch();
		String[] input = inputFilePath.split(" ");
		ArrayList<String> dbSynonyms = synonymMap.get(input[input.length - 1]);
		if (dbSynonyms != null) {
			inputFilePath = inputFilePath.replace(input[input.length - 1], "");
			for (String string : dbSynonyms) {
				inputFilePath = inputFilePath.concat(" " + string);
				for (String string1 : product.getProductDetails()) {
					if (isContain(string1, inputFilePath)) {
						MyLogger.writeMessage("\t" + string1, DebugLevel.SemanticSearch);
						results.writeToFile("\t" + string1);
					}
				}
			}
		}
	}

	private static boolean isContain(String sourceIn, String subItemIn) {
		String pattern = "\\b" + subItemIn + "\\b";
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(sourceIn);
		return m.find();
	}

	private HashMap<String, ArrayList<String>> getSynonymMatch() {
		HashMap<String, ArrayList<String>> synonymMap = new HashMap<String, ArrayList<String>>();
		
		String line="";
		FileProcessor fp = new FileProcessor(Driver.inputFilePath6);
		br = fp.getBR();
		while(br!=null){
			br = fp.getBR();
			line=fp.readLine(br);
			if (line == null) {
				break;
			}
			String[] words = line.split(":");
			if (synonymMap.containsKey(words[0])) {
				synonymMap.get(words[0]).add(words[1]);
			} else {
				ArrayList<String> synonymsOfWord = new ArrayList<>();
				synonymsOfWord.add(words[1]);
				synonymMap.put(words[0], synonymsOfWord);
			}
		}

		return synonymMap;
	}
}