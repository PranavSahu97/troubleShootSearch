package troubleShootSearch.context;

import java.util.ArrayList;
import java.io.BufferedReader;
import troubleShootSearch.dSeaGate.*;
// import troubleShootSearch.util.MyLogger;
import troubleShootSearch.util.Results;
//import troubleShootSearch.util.MyLogger.DebugLevel;
import troubleShootSearch.visitor.*;
import troubleShootSearch.util.FileProcessor;
import troubleShootSearch.driver.Driver;

public class Search {

	Results results;
	SearchVisitor exactSearch, naiveSearch, semanticSearch;
	ArrayList<String> searchInputs ;
	DSeaGate product1, product2, product3, product4;
	public static BufferedReader br1 = null;
	

	public Search(Results results,String input) {
		searchInputs = new ArrayList<>();
		String line1="";
		FileProcessor fp1 = new FileProcessor(input);
		br1 = fp1.getBR();
		while(br1!=null){
			br1 = fp1.getBR();
			line1=fp1.readLine(br1);
			if (line1 == null) {
				break;
			}
			
			searchInputs.add(line1);
		}

		
		this.results=results;
		
   		exactSearch = new ExactVisitor();
   		naiveSearch = new NaiveVisitor();
   		semanticSearch=new SemanticVisitor();
		product1 = new Product1();
		product2 = new Product2();
		product3 = new Product3();
		product4 = new Product4();

		
		
	}

	public void doSearch() {

		for (String searchString : searchInputs) {
			
			results.writeToFile("Search query: " + searchString + "\nDSEaGate Product1");
			product1.accept(exactSearch, results, searchString);
			product1.accept(naiveSearch, results, searchString);
			product1.accept(semanticSearch, results, searchString);
			
			results.writeToFile("Search query: " + searchString + "\nDSEaGate Product2");
			product2.accept(exactSearch, results, searchString);
			product2.accept(naiveSearch, results, searchString);
			product2.accept(semanticSearch, results, searchString);

			results.writeToFile("Search query: " + searchString + "\nDSEaGate Product3");
			product3.accept(exactSearch, results, searchString);
			product3.accept(naiveSearch, results, searchString);
			product3.accept(semanticSearch, results, searchString);

			results.writeToFile("Search query: " + searchString + "\nDSEaGate Product4");
			product4.accept(exactSearch, results, searchString);
			product4.accept(naiveSearch, results, searchString);
			product4.accept(semanticSearch, results, searchString);
		}		
	}
 }