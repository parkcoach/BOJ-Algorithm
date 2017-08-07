package BOJ;
import java.util.*;

public class P1806ºÎºÐÇÕ {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long goal = sc.nextInt();
		int[] a = new int[n];
		
		for(int i=0;i<n;i++){
			a[i] = sc.nextInt();
		}
		
		long sum = 0;
		int ans = 100000;
		for(int i=0;i<a.length;i++){
			sum = 0;
			for(int j=i;j<a.length;j++){
				sum += a[j];
				if(sum >= goal && ans > j-i){
					ans = j-i;
					continue;
				}
			}
		}
		System.out.println(ans+1);
	}

}
