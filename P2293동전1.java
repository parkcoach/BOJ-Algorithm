package BOJ;
import java.util.*;

public class P2293µ¿Àü1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int goal = sc.nextInt();
		int[] coin = new int[n];
		int[] dp = new int[goal+1];
		
		for(int i=0;i<n;i++){
			coin[i] = sc.nextInt();
		}
		
		dp[0] = 1;
		for(int i=0;i<n;i++){
			for(int j=1;j<=goal;j++){
				if(j-coin[i]>=0){
					dp[j] += dp[j-coin[i]];
				}
			}
		}
		
		System.out.println(dp[goal]);

	}

}
