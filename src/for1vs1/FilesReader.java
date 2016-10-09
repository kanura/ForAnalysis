package for1vs1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static for1vs1.AllParams.*;

public class FilesReader {
	private File file;
	private FileReader fr;
	private BufferedReader br;
	
	public FilesReader(File f){
		file = f;
		this.initReader();
	}
	
	private void initReader(){
		try {
			fr = new FileReader(file);
	        br = new BufferedReader(fr);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private int myScore;
	public void readFile(){
		myScore = 0;
		String line;
		try {
			while((line=br.readLine()) != null) {
					//System.out.println(line);
					this.addScore(line);
				}
		} catch (IOException e) {
			e.printStackTrace();
		}
		//System.out.print(myScore+",");
		allDataList.addLast(String.valueOf(myScore));
		this.closeReader();
	}
	
	private void closeReader(){
		try {
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void addScore(String line){
		String[] temp;
		temp = line.split(",");
		if(file.getName().startsWith(MyAIName)) myScore += Integer.parseInt(temp[1]);
		else if(file.getName().contains(MyAIName)) myScore += Integer.parseInt(temp[2]);
		else System.out.println("no your AI's score");
	}
}
