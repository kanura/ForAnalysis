package main;

import java.io.File;

import for1vs1.AllParams;
import for1vs1.FilesGetter;
import for1vs1.ScoreOutputter;
import static for1vs1.AllParams.*;

public class Main1vs1 {

	public static void main(String[] args) {
		// initialize
		AllParams temp = new AllParams();
		// TODO Auto-generated method stub
		for( String folderName : InputFolderNames ){
			System.out.println(folderName);
			// init
			allDataList.clear();
			
			// main process
			FilesGetter fileGetter = new FilesGetter(folderName);
			fileGetter.init();
			fileGetter.getFiles();
			
			// output total scores
			ScoreOutputter scoreOutputter = new ScoreOutputter();
			scoreOutputter.outputToConsole();
		}
	}

}
