package troubleShootSearch.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import troubleShootSearch.driver.Driver;

public class Results implements FileDisplayInterface, StdoutDisplayInterface{
	
	private String writeToFile = "";

	@Override
	public void writeToStdout(String s) {
		System.out.println(s);
	}

	@Override
	public void writeToFile(String filePath, String s) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
			bw.write(s);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public void storeNewResults(String setString) {
		if(!writeToFile.equals(""))
		writeToFile = writeToFile + "\n" + setString;
		else
		writeToFile = setString;
	}
	
	public void writeToFile(String filePath) {
		writeToFile(filePath,writeToFile);
	}

	public void writeToStdout() {
		writeToStdout(writeToFile);
	}

	// public void print(){
 //      	writeToFile(Driver.outputFilePath);
 //      }
	
}