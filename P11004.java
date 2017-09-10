package BOJ;
import java.io.*;

public class P11004 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int k = Integer.parseInt(input[1]);
		int[] a = new int[5000001];

		input = br.readLine().split(" ");
		for(int i=0;i<n;i++){
			int value = Integer.parseInt(input[i]);
			a[value]++;
		}

		int index = 0;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i=1;i<a.length;i++){
			if(a[i]==0) continue;
			index++;
			if(index==k){
				bw.write((int)i);
				bw.flush();
				return;
			}
		}
	}
}
