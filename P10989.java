package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P10989 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[10001];
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0;i<n;i++){
			int value = Integer.parseInt(br.readLine());
			arr[value]++;
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i=1;i<10001;i++){
			if(arr[i]>0){
				for(int j=0;j<arr[i];j++){
					bw.write(i+"\n");
				}
			}
		}
		bw.flush();
	}
}
