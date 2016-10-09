package processes;

import java.io.File;

import ioSupport.*;

public class OutputActCountFileProcess {
	/** singleton pattern*/
	private static OutputActCountFileProcess instance;
	
	private String[] inputFolderSides = {"P1", "P2"};
	private String inputPath = "./convertedData/actionSequenceFiles/";
	private String outputPath = "./convertedData/actionCountFiles/";
	
    /** use this method, when you use this class*/
    public static OutputActCountFileProcess getInstance(){
	   	if( instance == null ) instance = new OutputActCountFileProcess();
		return instance;
    }
    
    /** main process for output action counted file conducted by AI*/
    public void startProcess(){
    	// initialize
    	ActionNumCounter anc = new ActionNumCounter();
    	// P1, P2を順次実行
    	for( String side : this.inputFolderSides ){
    		// Path上のサイド(P1orP2)を更新
    		String tempInputPath = inputPath+side+"/";
    		String tempOutputPath = outputPath+side+"/";
    		// フォルダ作成
    		createDirs(tempOutputPath);
	    	// fileを一括取得
	    	File file = new File(tempInputPath);
	        File files[] = file.listFiles();
	        // actionSequenceFilesからactionCountFilesを作成
	        for( File f : files ){
		    	// 読み込むファイルサイドを更新
		    	anc.setInputFolderSide(side);
		    	// 読み込むファイルを更新
		    	anc.setInputFileName(f.getName());
		    	// 読み込み開始
				anc.startProcess();
				// 出力準備
				OutputActCountFile oacf = new OutputActCountFile(tempOutputPath, f.getName());
				// 出力開始
				oacf.writeActionsSequence(anc.getDataDeque());
	    		oacf.closeWriter();
	        }
    	}
    }
    
    private void createDirs(String path01){
    	File f = new File(path01);
    	f.mkdirs();
    }
    
}
