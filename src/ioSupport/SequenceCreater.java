package ioSupport;

import java.util.Deque;
import java.util.LinkedList;

//round, nowFrame, action, remainingFrame, P1_X, P1_Y, state, P1_HP, P1_Energy, A, B, C, U, D, L, R
public class SequenceCreater {
	private String[] actSequence;
	private Deque<String> actDeq = new LinkedList<String>();
	
	private String[] actName, actFrame;
	private int sequenceSize;
	
	public SequenceCreater(){}
	
	public SequenceCreater( String[] actions, String[] actionFrames ){
		this.actName = actions;
		this.actFrame = actionFrames;
	}
	
	/**
	 * call this method when you create action sequence from debug data file.
	 */
	public void createActSequence(){
		this.countSequenceLength();
		this.convertToSequence();
	}
	
	/**
	 * count the number of the length of act sequence
	 */
	private void countSequenceLength(){
		String beforeStr = "default";
		int beforeActFrame = 0;
		int i = 0;
		int num = 0;
		
		for( String act : actName ){
			switch ( i % (3600) ) {
			case 0:
				break;
			case 1:
				//System.out.println("round chenged...");
				// update parameters
				beforeStr = act;
				beforeActFrame = Integer.parseInt(actFrame[i]);
				//System.out.println(num+":"+act+","+Integer.parseInt(actFrame[i]));
				actDeq.addLast(act);
				num++;
				break;
			default:
				if( !beforeStr.equals(act) || Integer.parseInt(actFrame[i]) >= beforeActFrame) {
					//System.out.println(num+":"+act+","+Integer.parseInt(actFrame[i]));
					actDeq.addLast(act);
					num++;
				}
				// update parameters
				beforeStr = act;
				beforeActFrame = Integer.parseInt(actFrame[i]);
				break;
			}
			i++;
		}
		//System.out.println(num);
		sequenceSize = num;
	}
	
	/**
	 * create action sequence with sequenceSize counted by countSequenceLength
	 */
	private void convertToSequence(){
		actSequence = new String[sequenceSize];
		int i=0;
		for( String str : actDeq ) actSequence[i++] = str;
	}
	
	/**
	 * get action sequence with String[]
	 */
	public String[] getActSequence(){
		return this.actSequence;
	}
	
	/**
	 * get action sequence with deque<String>
	 */
	public Deque<String> getActDeque(){
		return this.actDeq;
	}
}
