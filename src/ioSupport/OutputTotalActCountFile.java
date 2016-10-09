package ioSupport;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class OutputTotalActCountFile {
	private FileReader fr;
	private BufferedReader br;
	private File file;
	private PrintWriter pw;
	File inputFile;
	private String outputFilePath = "";
	public String outputFileName;
	
	public OutputTotalActCountFile () {
		this.outputFileName = "NoName";
		this.openWriter();
	}
	
	public OutputTotalActCountFile (String newOutputFilePath, String AIName) {
		this.outputFilePath = newOutputFilePath;
		this.outputFileName = AIName;
		this.openWriter();
	}
	
	public void startProcess(File f){
		setInputFile(f);
		openReader();
		addCounts();
		closeReader();
	}
	
	private void setInputFile(File newInputFile){
		inputFile = newInputFile;
	}
	
	private void openReader(){
		try {
			fr = new FileReader(inputFile);
	        br = new BufferedReader(fr);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void closeReader(){
		try {
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void openWriter(){
		file = new File(outputFilePath+outputFileName+"_actCountTotal.csv");
		try {
			pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void closeWriter(){
		pw.close();
	}
	
	private int[] counts = new int[41];
	private void addCounts(){
		String line;
		try { 
			for(int i=0;(line=br.readLine()) != null;i++){
				if(i==1) {
					String[] str = line.split(",");
					int num=0;
					for(String tenp:str) {
						counts[num] += Integer.parseInt(tenp);
						num++;
					}
				}
			}
		}  catch (IOException e) { e.printStackTrace(); }
	}
	
	public void printCounts(){
		for(int num :counts) {
			System.out.print(num+",");
			pw.print(num+",");
		}
		System.out.println();
		pw.println();
		pw.flush();
	}
	
}
