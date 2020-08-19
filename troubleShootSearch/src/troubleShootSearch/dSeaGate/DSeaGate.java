package troubleShootSearch.dSeaGate;

import java.util.ArrayList;

import troubleShootSearch.util.Results;
import troubleShootSearch.visitor.SearchVisitor;

public interface DSeaGate{
	public void accept(SearchVisitor visitor, Results results, String searchInput);

	public ArrayList<String> getProductDetails();
}