package data;

import java.util.Arrays;

public class TotalActionCountData {
	public String AIName;
	public String side;
	public static String [] actionName = {
			"NEUTRAL","STAND","FORWARD_WALK","DASH","BACK_STEP","CROUCH","JUMP","FOR_JUMP","BACK_JUMP",			
			"THROW_A","THROW_B",
			"STAND_A","STAND_B","STAND_FA","STAND_FB",
			"CROUCH_A","CROUCH_B","CROUCH_FA","CROUCH_FB",
			"STAND_D_DF_FA","STAND_D_DF_FB","STAND_F_D_DFA","STAND_F_D_DFB","STAND_D_DB_BA","STAND_D_DB_BB","STAND_D_DF_FC",
			"AIR_A","AIR_B","AIR_DA","AIR_DB","AIR_FA","AIR_FB","AIR_UA","AIR_UB",
			"AIR_D_DF_FA","AIR_D_DF_FB","AIR_F_D_DFA","AIR_F_D_DFB","AIR_D_DB_BA","AIR_D_DB_BB",
			"ELSE"
			};
	public int[] actionCount;
	
	public TotalActionCountData(){
		actionCount = new int[actionName.length];
		Arrays.fill(actionCount, 0);
	}
	
	/**
	 * set some information
	 * @param myName my AI name
	 */
	public void setInformation( String myName, String mySide){
		AIName = myName;
		side = mySide;
	}
	
	public String getAIName(){
		return this.AIName;
	}
	
	public String getAISide(){
		return this.side;
	}
	
}
