package BOJ;
import java.util.*;

public class P13458시험감독 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for(int i=0;i<n;i++){
			a[i] = sc.nextInt();
		}
		
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		long ans = 0;
		for(int i=0;i<n;i++){
			int sum = b;
			ans++;
			if(sum<a[i]){
				int temp = a[i] - sum;
				if(temp%c==0) ans += temp/c;
				else ans += temp/c + 1;
			}
		}
		System.out.println(ans);

	}

}
