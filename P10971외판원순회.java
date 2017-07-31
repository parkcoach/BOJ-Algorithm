package BOJ;
import java.util.*;

public class P10971외판원순회 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] a = new int[n+1][n+1];

		for(int i=1;i<=n;i++){
			for(int j=1;j<=n;j++){
				a[i][j] = sc.nextInt();
			}
		}

		int[] d = new int[n];
		for(int i=0;i<n;i++){
			d[i] = i+1;
		}

		int ans = Integer.MAX_VALUE;
		do{
			int value = 0;
			boolean state = true;
			for(int i=0;i<n-1;i++){
				if(a[d[i]][d[i+1]]==0){
					state = false;
				}
				else{
					value+=a[d[i]][d[i+1]];
				}
			}
			
			if(state && a[d[n-1]][d[0]]!=0){
				value += a[d[n-1]][d[0]];
				ans = Math.min(ans, value);
			}
			
		}while(next_permutation(d));

		System.out.println(ans);
	}
	
	public static boolean next_permutation(int[] a){
		int i = a.length-1;
		while(i>0 && a[i-1]>=a[i]){
			i-=1;
		}
		
		if(i==0){ //마지막 순서일 때
			return false;
		}
		
		int j = a.length-1;
		while(a[i-1]>=a[j]){
			j-=1;
		}
		
		int temp = a[i-1];
		a[i-1] = a[j];
		a[j] = temp;
		
		j = a.length-1;
		while(i<j){
			temp = a[i];
			a[i] = a[j];
			a[j] = temp;
			i+=1;
			j-=1;
		}
		return true;
	}

}
