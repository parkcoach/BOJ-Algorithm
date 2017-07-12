package BOJ;
import java.io.*;

public class P1783 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		int height = Integer.parseInt(line[0]);
		int width = Integer.parseInt(line[1]);
		int ans = 0;
		
		if(height==1)
			ans = 1;
		else if(height==2){
			ans = Math.min(4, (width+1)/2);
		}
		else if(height>=3){
			if(width<7){
				ans = Math.min(4, width);
			}
			else{
				ans = width-2;
			}
		}
		System.out.println(ans);
	}

}