package temp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CheckFairness {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader("jaybot100");
	        br = new BufferedReader(fr);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String line;
		String[] temp;
		int count = 0;
		int game = 0;
		int[][] score = new int[3][100];
		int j=0;
		try {
			while((line=br.readLine()) != null) {
					temp = line.split(",");
					int i = 0;
					for(String str:temp){
						System.out.print(str+",");
						if(i>0)score[i][game] += Integer.parseInt(str);
						i++;
					}
					if(Integer.parseInt(temp[1])==500)j++;
					System.out.println();
					if( count++ >= 2 ){
						game++;
						count=0;
					}
				}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*int j=0;
		for( game = 0 ; game < 100 ; game++ ){
			for( count = 0 ; count < 2; count++ ){
				System.out.print(score[count][game]+",");
				if(score[count][game]==1500)j++;
			}
			System.out.println();
		}*/
		System.out.println(j);
	}

}
