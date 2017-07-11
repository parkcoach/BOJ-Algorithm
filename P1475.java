package BOJ;
import java.io.*;

public class P1475 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int[] num = new int[9];

		for(int i=0;i<line.length();i++){
			int input = (int)line.charAt(i)-48;
			if(input==9 || input==6)
				num[6]++;
			else
				num[input]++;
		}
		
		num[6] = num[6]/2 + num[6]%2;
		
		int max = Integer.MIN_VALUE;
		for(int i=0;i<9;i++){
			if(max<num[i])
				max = num[i];
		}
		System.out.println(max);	
	}
}