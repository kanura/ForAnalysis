package ioSupport;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadDataFile {
	private FileReader fr;
	private BufferedReader br;
	public String path;
	public String fileName;
	private int lineCount = 0;
	private int elementCount = 0;
	public String[][] data;
	
	public ReadDataFile(){}
	
	public ReadDataFile( String newPathName, String newFileName ){
		path = newPathName;
		fileName = newFileName;
	}
	
	/**
	 * mainly use this method
	 */
	public void startReadDataFile(){
		// count lines and elements
		initReader();
		countDataFileLinesElements();
		initDataArrays();
		closeReaders();
		
		// read and save data as a String[lineCount][elementCount]
		initReader();
		readDataFile();
		closeReaders();
		
		// log part
		//outputLog();
	}
	
	private void outputLog(){
		System.out.println("finish reading and saving as a matrix "+lineCount+"x"+elementCount);
		System.out.println("labels are...");
		for( String str : data[0] ) System.out.print(str+", ");
		System.out.println();
	}
	
	private void initReader(){
		try {
			fr = new FileReader(path+fileName);
	        br = new BufferedReader(fr);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void countDataFileLinesElements(){
		String line;
		String[] temp;
		try {
			while((line=br.readLine()) != null) {
					lineCount++;
					temp = line.split(",");
					elementCount = temp.length;
				}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void initDataArrays(){
		data = new String[lineCount][elementCount];
	}
	
	private void readDataFile(){
		String line;
		int i=0;
		try {
			while((line=br.readLine()) != null) {//1.lineでテキストファイルから１行ずつ読み込む
				int j = 0;
				String[] array = line.split(",");//2.その１行をカンマで区切って二つの要素にする
				for( String str : array ){
					data[i][j] = str;
					j++;
				}
				i++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String[][] getData(){
		return this.data;
	}
	
	public String[] getColumnWithRowStyle(int columnNum){
		String[] column = new String[lineCount];
		for( int i = 0 ; i < column.length ; i++ )
			column[i] = data[i][columnNum];
		return column;
	}
	
	public void outputData(){
		for( int i=0;i<lineCount;i++){
			for(int j=0;j<elementCount;j++)
				System.out.print(data[i][j]+",");
			System.out.println();	
		}
	}
	
	public void closeReaders(){
		try {
			this.br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
