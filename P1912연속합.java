package BOJ;
import java.util.*;

public class P1912¿¬¼ÓÇÕ {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		int[] a = new int[n];
		int[] dp = new int[n];
		
		for(int i=0;i<n;i++){
			a[i] = sc.nextInt();
		}
			
		dp[0] = a[0];
		for(int i=1;i<n;i++){
			dp[i] = a[i];
			if(dp[i]<dp[i-1]+a[i]){
				dp[i] = dp[i-1] + a[i];
			}
		}
		
		int max = Integer.MIN_VALUE;
		for(int x : dp){
			if(max < x){
				max = x;
			}
		}
		System.out.println(max);
	}

}
