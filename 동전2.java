package BOJ;
import java.util.*;

public class µ¿Àü2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int goal = sc.nextInt();
		int[] coin = new int[101];
		int[] dp = new int[10001];
		
		for(int i=0;i<=goal;i++){
			dp[i] = 10001;
		}

		for(int i=0;i<n;i++){
			coin[i] = sc.nextInt();
			if(coin[i]<0 || coin[i]>10000) coin[i] = 0;
			dp[coin[i]] = 1;
		}

		for(int i=1;i<=goal;i++){
			for(int j=0;j<n;j++){
				if((i-coin[j]>=0) && (dp[i]>dp[i-coin[j]]+1)){
					dp[i] = dp[i-coin[j]]+1;
				}
			}
		}
		
		if(dp[goal]!=10001)
			System.out.println(dp[goal]);
		else
			System.out.println(-1);
	}

}
