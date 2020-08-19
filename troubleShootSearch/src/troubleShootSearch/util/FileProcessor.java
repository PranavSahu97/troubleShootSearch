package troubleShootSearch.util;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import troubleShootSearch.driver.Driver;
import troubleShootSearch.util.Results;
import troubleShootSearch.dSeaGate.*;

public class FileProcessor {
	private BufferedReader br;
	public FileProcessor(String filePath) {
		try {
			br = new BufferedReader(new FileReader(filePath));

		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}	
	public BufferedReader getBR(){
		return br;
	}
	public String readLine(BufferedReader br) {
	String line = "";
	try {
		line = br.readLine();
	} catch (IOException e) {
		e.printStackTrace();
	}
	return line;
}
}
