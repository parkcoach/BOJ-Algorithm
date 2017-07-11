package BOJ;
import java.util.*;

public class P1003 {
	static int[] dp;
	
	public static int fibonacci(int n){
		if(n==0){
			dp[0]++;
			return 0;
		}
		else if(n==1){
			dp[1]++;
			return 1;
		}
		else 
			return fibonacci(n-1)+fibonacci(n-2);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test_case = sc.nextInt();
		
		while(test_case-- >0){
			dp = new int[2];
			int n = sc.nextInt();
			fibonacci(n);
			System.out.println(dp[0]+" "+dp[1]);
		}
	}
}