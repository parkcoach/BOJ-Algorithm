package BOJ;
import java.io.*;
import java.util.*;

public class P1520내리막길 {
	static int n, m, ans = 0;
	static int[][] map = new int[501][501];
	static int[][] check = new int[501][501];
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);
		
		for(int i=0;i<n;i++){
			Arrays.fill(check[i], -1);
		}
		
		for(int i=0;i<n;i++){
			input = br.readLine().split(" ");
			for(int j=0;j<m;j++){
				map[i][j] = Integer.parseInt(input[j]);
			}
		}
		dfs(0,0);
		System.out.println(check[0][0]);
	}
	
	public static int dfs(int x, int y){
		if(x==n-1 && y==m-1){
			return 1;
		}
		
		if(check[x][y] >= 0) return check[x][y];
		
		if(check[x][y]==-1) check[x][y] = 0;
		
		for(int i=0;i<4;i++){
			int rx = x + dx[i];
			int ry = y + dy[i];
			if(rx<0 || n<=rx || ry<0 || m<=ry) continue;
			if(map[rx][ry] < map[x][y]){
				check[x][y] += dfs(rx,ry);
			}
		}
		return check[x][y];
	}
}
