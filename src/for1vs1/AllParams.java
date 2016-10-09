package for1vs1;

import java.util.LinkedList;

public class AllParams {
	public static String InputFolderName = "1_delay無しのみ";
	public static String[] InputFolderNames = {
		"0_default", "1_delay無しのみ", "2_predictionのみ", "3_predictionDelay無し", 
		"sammary"
		};
	public static String MyAIName = "SampleMCTSAI";
	public static LinkedList<String> allDataList = new LinkedList<String>();
	public static int EachSideGameNum = 10;
	public static int SideNum = 2;
}
