package BOJ;
import java.util.*;

public class P1182부분집합의합 {
	static int cnt = 0;

	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		int n = sc.nextInt();
		int goal = sc.nextInt();
		int[] a = new int[n];
		for(int i=0;i<n;i++){
			a[i] = sc.nextInt();
		}
		
		int ans = check(goal, 0, a);
		System.out.println(ans);
		System.out.println(go(a,goal,0,0));
	}
	
	public static int check(int goal, int sum, int[] a){
		int ans = 0;
		for(int i=1;i<(1<<a.length);i++){
			sum = 0;
			for(int j = 0;j<a.length;j++){
				if((i&(1<<j))!=0){
					sum += a[j];
				}
			}
			if(sum==goal){
				ans++;
			}
		}
		return ans;
	}
	
	public static int go(int[] a, int goal, int sum, int index){
		if(index==a.length-1){
			if(goal==sum)
				return 1;
			else 
				return 0;
		}
		return go(a, goal, sum, index+1) + go(a, goal, sum+a[index], index+1);
	}
}