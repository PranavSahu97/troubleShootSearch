package troubleShootSearch.visitor;

import troubleShootSearch.dSeaGate.*;
import troubleShootSearch.util.Results;


public interface SearchVisitor{
	void visit(DSeaGate product, Results results, String inputFilePath);
}