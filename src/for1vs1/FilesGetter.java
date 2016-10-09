package for1vs1;

import java.io.File;
import static for1vs1.AllParams.*;

public class FilesGetter {
	private String InputPath = "";
	private File folders[];
    private File files[];
    public File pointFiles[];
    
    public FilesGetter(){
    	InputPath = InputFolderName;
    }
    
    public FilesGetter(String inputFolderName){
    	InputPath = inputFolderName;
    }
    
    public void init(){
    }
    
    public void init(String newInputPath){
    	InputPath = newInputPath;
    }
	
	public void getFiles(){
		// fileを一括取得
        folders = getFiles(InputPath);
        for( File folder : folders ){
    		if( !folder.getName().startsWith(".") ){
    			//System.out.println(folder.getName());
    			allDataList.addLast(folder.getName());
    			files = getFiles(InputPath+"/"+folder.getName());
    			//System.out.println(files.length);
            	for( File f : files ){
            		if( !f.getName().contains(".") ){
            			pointFiles = getFiles(InputPath+"/"+folder.getName()+"/"+f.getName()+"/point");
            			for( File pointFile : pointFiles )
            				if( pointFile.getName().contains("PLOG") ) this.test(pointFile);
            		}
            	}
    		}
    		//System.out.println();
        }
	}
	
	FilesReader filesReader;
	private void test(File plogFile){
		//System.out.println(plogFile.getName());
		filesReader = new FilesReader(plogFile);
		filesReader.readFile();
	}
	
	public File[] getFiles(String path){
		File file = new File(path);
		File files[] = file.listFiles();
		return files;
	}
}
