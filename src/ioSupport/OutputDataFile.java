package ioSupport;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class OutputDataFile {
	private File file;
	private PrintWriter pw;
	private String outputFilePath = "";
	public String outputFileName;
	
	public OutputDataFile () {
		this.outputFileName = "NoName";
		this.openWriter();
	}
	
	public OutputDataFile (String newOutputFilePath, String outputFileName) {
		this.outputFilePath = newOutputFilePath;
		this.outputFileName = outputFileName;
		this.openWriter();
	}
	
	private void openWriter(){
		file = new File(outputFilePath+outputFileName);
		try {
			pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void closeWriter(){
		pw.close();
	}
	
	public void reOpenWriter(String outputFileName){
		this.outputFileName = outputFileName;
		this.closeWriter();
		this.openWriter();
	}
	
	public void writeActionsSequence(String[] actSequence){
		for( String str : actSequence ) pw.println(str);
	}
}
