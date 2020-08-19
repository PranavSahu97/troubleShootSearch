package troubleShootSearch.dSeaGate;

import java.util.ArrayList;
import java.io.BufferedReader;

import troubleShootSearch.driver.Driver;
import troubleShootSearch.context.Search;
import troubleShootSearch.util.FileProcessor;
import troubleShootSearch.util.MyLogger;
import troubleShootSearch.util.MyLogger.DebugLevel;
import troubleShootSearch.util.Results;
import troubleShootSearch.visitor.SearchVisitor;

public class Product2 implements DSeaGate {
	public static BufferedReader br = null;
	public ArrayList<String> productDetails = new ArrayList<>();
	//Results results;
	
	public Product2() {
		String line="";
		FileProcessor fp = new FileProcessor(Driver.inputFilePath3);
		br = fp.getBR();
		while(br!=null){
			br = fp.getBR();
			line=fp.readLine(br);
			if (line == null) {
				break;
			}
			productDetails.add(line);
		}
		MyLogger.writeMessage("Product 2 constructor file was read", DebugLevel.CONSTRUCTOR);
		//System.out.println("size Product2:"+productDetails.size());
		//for(int i=0;i<productDetails.size();i++)
		//System.out.println("A:"+productDetails.get(i));

		
	}

	public ArrayList<String> getProductDetails() {
		return productDetails;
	}

	public void setProductDetails(ArrayList<String> productDetails) {
		this.productDetails = productDetails;
	}

	@Override
	public void accept(SearchVisitor visitor, Results results, String searchInput){
		visitor.visit(this, results, searchInput);
	}
}