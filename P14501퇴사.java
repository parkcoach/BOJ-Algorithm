package BOJ;

import java.util.Scanner;

public class P14501Επ»η {
	static int[] time = new int[16];
	static int[] money = new int[16];
	static int max, n;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for(int i=1;i<=n;i++){
			time[i] = sc.nextInt();
			money[i] = sc.nextInt();
		}
		
		dfs(1,0);
		System.out.println(max);
	}
	
	public static void dfs(int x, int sum){
		if(x==n+1){
			max = Math.max(max, sum);
			return;
		}
		
		if(x+time[x] <= n+1) dfs(x+time[x], sum+money[x]);
		if(x+1 <= n+1) dfs(x+1, sum);
	}

}
