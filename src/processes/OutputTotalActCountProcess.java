package processes;

import java.io.File;
import java.util.Deque;
import java.util.LinkedList;

import ioSupport.OutputTotalActCountFile;
import static data.TotalActionCountData.actionName;
import data.TotalActionCountData;

public class OutputTotalActCountProcess {
	/** singleton pattern*/
	private static OutputTotalActCountProcess instance;
	
	private String[] inputFolderSides = {"P1", "P2"};
	private String inputPath = "./convertedData/actionCountFiles/";
	private String outputPath = "./convertedData/totalActionCountFiles/";

	private Deque<TotalActionCountData> totalActsData = new LinkedList<TotalActionCountData>();
    
	 // 17+1 AIs name No.15
 	public static final String[] AIsName2015 = {
 			"AI_ZBY0323", "AI123456", "AI128200", "ASH", "AsuchAI_LEPnkNN", "BlueLag",
 			"DragonWarrior", "FICE_AI_OM", "FuzzyGA", "GiantTeam", "Jay_Bot", "Machete",
 			"Ni1mir4ri", "RatioBot", "SampleMCTSAI", "SDBOT", "SniperInSejong", "Snorkel"
 	};
	 
    /** use this method, when you use this class*/
    public static OutputTotalActCountProcess getInstance(){
	   	if( instance == null ) instance = new OutputTotalActCountProcess();
		return instance;
    }
    
    private void init(String side){
    	for( String name : AIsName2015 ){
    		TotalActionCountData data = new TotalActionCountData();
    		data.setInformation(name, side);
    		totalActsData.addLast(data);
    	}
    }
    
    private String targetAIname = "SampleMCTSAI";
    public void startProcess(){
    	// 全AIに対して処理を実行
    	for( String targetName : AIsName2015 ){
    		targetAIname = targetName;
    		mainProcess();
    	}
    }
    
    private void mainProcess(){
    	// init
		OutputTotalActCountFile outputTotalActCount = new OutputTotalActCountFile(outputPath, targetAIname);
    	// P1, P2を順次実行
    	for( String side : this.inputFolderSides ){
        	// initialize
        	init(side);
    		// Path上のサイド(P1orP2)を更新
    		String tempInputPath = inputPath+side+"/";
    		String tempOutputPath = outputPath+side+"/";
    		// フォルダ作成
    		createDirs(tempOutputPath);
	    	// fileを一括取得
	    	File file = new File(tempInputPath);
	        File files[] = file.listFiles();
	        // actionCountFilesからtotalActionCountFilesを作成
	        for( File f : files ){
	        	if( f.getName().startsWith(targetAIname) ){
	        		System.out.println(side+" "+f.getName()+" is processed...");
	        		outputTotalActCount.startProcess(f);
	        	} 
	        }
    	}
		outputTotalActCount.printCounts();
		outputTotalActCount.closeWriter();
    }
    
    private void createDirs(String path01){
    	File f = new File(path01);
    	f.mkdirs();
    }
    
}
