package BOJ;
import java.io.*;

public class P1100 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int ans = 0;

		for(int i=0;i<8;i++){
			String line = br.readLine();
			for(int j=0;j<8;j++){
				if(i%2==0 && j%2==0 && line.charAt(j)=='F') ans++;
				else if(i%2==1 && j%2==1 && line.charAt(j)=='F') ans++;
			}
		}

		System.out.println(ans);
	}
}