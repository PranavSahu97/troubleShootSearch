package troubleShootSearch.visitor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import troubleShootSearch.dSeaGate.DSeaGate;
import troubleShootSearch.dSeaGate.Product1;
import troubleShootSearch.util.MyLogger;
import troubleShootSearch.util.Results;
import troubleShootSearch.util.MyLogger.DebugLevel;


public class NaiveVisitor implements SearchVisitor{
	public NaiveVisitor(){

	}

	@Override
	public void visit(DSeaGate product, Results results, String inputFilePath) {
		MyLogger.writeMessage("Naive Search", DebugLevel.NaiveSearch);
		results.writeToFile("\nNaive Search");
		String[] input = inputFilePath.split(" ");
		for (String string : product.getProductDetails()) {
			if (string.contains(input[0])) {
				MyLogger.writeMessage("\t" + string, DebugLevel.NaiveSearch);
				results.writeToFile("\t" + string);
			}
		}
	}
}