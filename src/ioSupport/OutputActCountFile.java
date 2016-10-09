package ioSupport;

import data.ActionCountData;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Deque;

public class OutputActCountFile {
	private File file;
	private PrintWriter pw;
	private String outputFilePath = "";
	public String outputFileName;
	
	public OutputActCountFile () {
		this.outputFileName = "NoName";
		this.openWriter();
	}
	
	public OutputActCountFile (String newOutputFilePath, String outputFileName) {
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
	
	public void writeActionsSequence(Deque<ActionCountData> deq){
		for( ActionCountData acd : deq ) {
			for( String str : acd.actionName ) pw.write(str+",");
			pw.println();
			for( int num : acd.actionCount ) pw.write(num+",");
			pw.flush();
		}
	}
}
