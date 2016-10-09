package for1vs1;

import java.io.File;
import java.util.LinkedList;

public class AllParams {
	public static String InputFolderName = "1_delay無しのみ";
	private String targetFolderName = "target/";
	public static String[] InputFolderNames;
	public static String MyAIName = "SampleMCTSAI";
	public static LinkedList<String> allDataList = new LinkedList<String>();
	public static int EachSideGameNum = 10;
	public static int SideNum = 2;
	
	public AllParams (){
		File file = new File(targetFolderName);
		File[] files = file.listFiles();
		InputFolderNames = new String[files.length];
		int i=0;
		for(File f:files) {
			System.out.println("set -> "+f.getName());
			InputFolderNames[i] = targetFolderName+f.getName();
			i++;
		}
	}
}
