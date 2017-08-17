package BOJ;
import java.util.*;
import java.io.*;

class Cave{
	int x,y;
	Cave(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class P4485≥Ïªˆø ¿Ã¡©¥Ÿ {
	static int[][] map;
	static int[][] check;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static int ans = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int p = 0;
		while(true){
			p++;
			int n = Integer.parseInt(br.readLine());
			if(n==0) return;

			map = new int[n][n];
			check = new int[n][n];
			for(int i=0;i<n;i++){
				String[] line = br.readLine().split(" ");
				for(int j=0;j<n;j++){
					map[i][j] = Integer.parseInt(line[j]);
					check[i][j] = 1300;
				}
			}
			bfs(0,0,n);
			System.out.println("Problem "+p+": "+check[n-1][n-1]);
		}

	}

	public static void bfs(int x, int y, int n){
		Queue<Cave> q = new LinkedList<Cave>();
		q.add(new Cave(x,y));
		check[x][y] = map[x][y];

		while(!q.isEmpty()){
			Cave c = q.remove();
			int cx = c.x;
			int cy = c.y;
			for(int i=0;i<4;i++){
				int rx = cx + dx[i];
				int ry = cy + dy[i];
				if(0<=rx && rx<n && 0<=ry && ry<n){
					if(check[rx][ry]>check[cx][cy]+map[rx][ry]){
						check[rx][ry] = check[cx][cy]+map[rx][ry];
						q.add(new Cave(rx,ry));
					}
				}
			}
		}
	}
}