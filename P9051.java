package BOJ;
import java.util.*;

public class P9051 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int goal = sc.nextInt();
		int sum = 0;
		int ans = plus(sum, goal);
		System.out.println(ans);
	}
	
	public static int plus(int sum, int goal){
		if(sum>goal) return 0;
		if(sum==goal) return 1;
		int now = 0;
		now += plus(sum+1, goal);
		now += plus(sum+2, goal);
		now += plus(sum+3, goal);
		return now;
	}
	
}
