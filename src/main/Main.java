package main;

import processes.*;

public class Main {
	
	public static void main(String[] args) {
		// 1. debugDataからoutputDataFilesにactionSequenceFileを作成・出力
		//OutputActSequenceProcess.getInstance().startProcess();
		
		// 2.1 outputDataFilesからファイルを読み込み1game毎のaction count
		//OutputActCountFileProcess.getInstance().startProcess();

		// 2.2 AIName_totalActionCountFileを作成
		OutputTotalActCountProcess.getInstance().startProcess();
		
		// check part
		System.out.println("processes completed...");
	}

}
