package BOJ;
import java.util.*;

public class P2010 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ans = 0;
		
		for(int i=0;i<n;i++){
			int input = sc.nextInt();
			ans += input;
		}
		
		ans = ans-(n-1);
		System.out.println(ans);
	}
}