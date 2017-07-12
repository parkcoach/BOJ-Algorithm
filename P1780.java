package BOJ;
import java.util.*;

public class P1780 {

	static int[][] map;
	static int[] cnt;
	
	public static void div(int x, int y, int n){
		if(check(x,y,n)){
			cnt[map[x][y]+1]+=1;
			return;
		}
		
		int m = n/3;
		
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				div(x+i*m, y+j*m,m);
			}
		}
	}
	
	public static boolean check(int x, int y, int n){
		for(int i=x;i<x+n;i++){
			for(int j=y;j<y+n;j++){
				if(map[x][y] != map[i][j])
					return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		map = new int[n][n];
		cnt = new int[3];
		
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				map[i][j] = sc.nextInt();
			}
		}
		
		div(0,0,n);
		
		for(int x : cnt){
			System.out.println(x);
		}

	}

}