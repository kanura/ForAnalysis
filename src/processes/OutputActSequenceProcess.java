package processes;

import java.io.File;

import ioSupport.OutputDataFile;
import ioSupport.ReadDataFile;
import ioSupport.SequenceCreater;

public class OutputActSequenceProcess {
	/** singleton pattern*/
	private static OutputActSequenceProcess instance;
	private String[] inputFolderSides = {"P1", "P2"};
	private String inputPath = "./originalData/";
	private String outputPath = "./convertedData/actionSequenceFiles/";
	
    /** use this method, when you use this class*/
    public static OutputActSequenceProcess getInstance(){
	   	if(instance == null) instance = new OutputActSequenceProcess();
		return instance;
    }
    
    /** main process for output actions sequence conducted by an AI*/
    public void startProcess(){
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
	        // debugDataからoutputDataFilesを作成
	        for( File f : files ){
	        	// files読み込み, 前準備
	    		ReadDataFile rdf = new ReadDataFile( tempInputPath, f.getName() );
	    		rdf.startReadDataFile();
	    		
	    		// 必要なデータだけを配列形式で取得
	    		String[] actions = rdf.getColumnWithRowStyle(2);// 2 = an action
	    		String[] remainingFrames = rdf.getColumnWithRowStyle(3);// 3 = remaining frames of the action
	    		
	    		// actions sequenceを作成, everyFrameData -> conductedActionData
	    		SequenceCreater sr = new SequenceCreater(actions, remainingFrames);
	    		sr.createActSequence();
	    		
	    		// action sequence fileを出力
	    		OutputDataFile odf = new OutputDataFile(tempOutputPath, rdf.fileName);
	    		odf.writeActionsSequence(sr.getActSequence());
	    		odf.closeWriter();	
	        }
    	}
    }
    
    private void createDirs(String path){
    	File f = new File(path);
    	f.mkdirs();
    }
    
}
