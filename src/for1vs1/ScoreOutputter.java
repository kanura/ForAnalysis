package for1vs1;

import static for1vs1.AllParams.*;

public class ScoreOutputter {
	public ScoreOutputter(){}
	
	private int totalScore = 0;
	public void outputToConsole(){
		allDataList.addLast("dummy_data");
		for(String str:allDataList){
			if( str.contains("_") ) {
				if(totalScore != 0) {
					System.out.print(totalScore);
					System.out.println();//("\n"+str);
				}
				totalScore = 0;
			}
			else {
				totalScore += Integer.parseInt(str);
				//System.out.print(str+",");
			}
		}
	}
}
