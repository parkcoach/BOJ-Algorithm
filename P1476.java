package BOJ;
import java.util.*;

public class P1476 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int E =sc.nextInt();
		int S = sc.nextInt();
		int M = sc.nextInt();
		
		int e,s,m,cnt=0;
		e=s=m=1;
		while(true){
			cnt++;
			if(E==e && S==s && M==m){
				break;
			}
			e = (e%15)+1;
			s = (s%28)+1;
			m = (m%19)+1;
		}
		System.out.println(cnt);
	}
}