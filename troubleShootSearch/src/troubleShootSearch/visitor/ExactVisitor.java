package troubleShootSearch.visitor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import troubleShootSearch.dSeaGate.*;
import troubleShootSearch.util.MyLogger;
import troubleShootSearch.util.Results;
import troubleShootSearch.util.MyLogger.DebugLevel;

public class ExactVisitor implements SearchVisitor{
	public ExactVisitor(){

	}
	@Override
	public void visit(DSeaGate product, Results results,String inputFilePath){
		MyLogger.writeMessage("Exact Search", DebugLevel.ExactSearch);
		results.writeToFile("\nExact Search");
		for (String string : product.getProductDetails()) {
			if (isContain(string, inputFilePath)) {
				MyLogger.writeMessage("\t" + string, DebugLevel.ExactSearch);
				results.writeToFile("\t" + string + "\n");
			}
		}	
	}

	private static boolean isContain(String source, String subItem){
		String pattern="\\b"+subItem+"\\b";
		Pattern p= Pattern.compile(pattern);
		Matcher m= p.matcher(source);
		return m.find();
	}
}