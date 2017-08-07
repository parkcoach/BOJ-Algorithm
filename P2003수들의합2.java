package BOJ;
import java.util.*;

public class P2003수들의합2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] a = new int[n];

		for(int i=0;i<a.length;i++){
			a[i] = sc.nextInt();
		}

		int sum = 0;
		int ans = 0;
		for(int i=0;i<a.length;i++){
			sum = 0;
			for(int j=i;j<a.length;j++){
				sum += a[j];
				if(sum==m){
					ans += 1;
					continue;
				}
			}
		}
		System.out.println(ans);
	}

}
