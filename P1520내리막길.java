package BOJ;
import java.util.Scanner;

public class P1520내리막길 {
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static int[][] map = new int[501][501];
	static int[][] check = new int[501][501];
	static int ans = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				map[i][j] = sc.nextInt();
				check[i][j] = -1;
			}
		}

		System.out.println(back(0,0,n,m));

	}
	
	public static int back(int x, int y, int n, int m){
		if(x==n-1 && y==m-1) return 1;
		
		if(check[x][y]>0) return check[x][y];
		
		for(int i=0;i<4;i++){
			int rx = x + dx[i];
			int ry = y + dy[i];
			if(0<=rx && 0<=ry && rx<n && ry<m){
				if(map[x][y]>map[rx][ry]) check[x][y] += back(rx,ry,n,m);
			}
		}
		return check[x][y];
	}
	
}