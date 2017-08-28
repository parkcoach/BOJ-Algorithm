package BOJ;
import java.util.*;

public class P2979트럭주차 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int[] parking = new int[101];
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		
		for(int i=0;i<3;i++){
			int start = sc.nextInt();
			int end = sc.nextInt();
			for(int j=start;j<end;j++) parking[j]++;
			min = Math.min(min, start);
			max = Math.max(max, end);
		}
		
		int ans = 0;
		for(int i=min;i<max;i++){
			if(parking[i]==1) ans+=a;
			else if(parking[i]==2) ans+=b*2;
			else ans+=c*3;
		}
		
		System.out.println(ans);
		
	}

}