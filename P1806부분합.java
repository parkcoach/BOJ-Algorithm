package BOJ;
import java.util.*;

public class P1806ºÎºÐÇÕ {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int goal = sc.nextInt();
		int[] a = new int[n];
		
		for(int i=0;i<n;i++){
			a[i] = sc.nextInt();
		}
		
		int ans = Integer.MAX_VALUE;
		for(int i=0;i<n;i++){
			int plus = 0, cnt = 0;
			for(int j=i;j<n;j++){
				plus+=a[j];
				cnt++;
				if(plus > goal) break;
				if(plus==goal){
					ans = Math.min(cnt, ans);
					break;
				}
			}
		}
		System.out.println(ans);
	}

}
