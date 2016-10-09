package ioSupport;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Deque;
import java.util.LinkedList;

import data.*;

public class ActionNumCounter {
	public String inputFolderSide = "P1";
	public String inputFolderPath = "./convertedData/actionSequenceFiles/"+inputFolderSide+"/";
	public String inputFileName = "";
	private BufferedReader br;
	private Deque<ActionCountData> dataDeque = new LinkedList<ActionCountData>();
	
	public ActionNumCounter(){
		;
	}
	
	/** 
	 * 読み込みたいファイルの名前を保存・更新する
	 * @param newFileName next read file name 
	 */
	public void setInputFileName(String newFileName){
		this.inputFileName = newFileName;
	}
	
	/** 
	 * 読み込みたいファイルSideの名前を保存・更新する ( P1 orP2 )
	 * @param newFolderSide read folderSide name 
	 */
	public void setInputFolderSide(String newFolderSide){
		this.inputFolderSide = newFolderSide;
	}
	
	/** 1つのファイルを読み込み, ActionDataCountを作成しDequeに随時保存*/
	public void startProcess(){
		// re-init deque
		dataDeque.clear();
		// initialize reader for inputFileName
		this.initReader();
		// start reading file per line
		this.readFilePerLine();
	}
	
	/** 現在登録されているpath+inputFileNameに対するfile-readerを準備*/
	private void initReader(){
		try { br = new BufferedReader(new FileReader(inputFolderPath+inputFileName)); } 
		catch (FileNotFoundException e) { e.printStackTrace(); }
	}
	
	/** ファイルを1行ずつ読み込み, actionをカウント*/
	private void readFilePerLine(){
		String line;
		ActionCountData data = new ActionCountData();
		try { while((line=br.readLine()) != null) data.countAct(line); } 
		catch (IOException e) { e.printStackTrace(); }
		dataDeque.addLast(data);
	}
	
	public Deque<ActionCountData> getDataDeque(){
		return this.dataDeque;
	}
}
