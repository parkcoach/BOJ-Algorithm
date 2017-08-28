package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Dev{
	int x;
	int y;
	Dev(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class P14502¿¬±¸¼Ò {
	static int n, m, ans = Integer.MIN_VALUE;
	static int[][] map;
	static boolean[][] check;
	static Queue<Dev> virusq = new LinkedList<Dev>(); 
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	
	static final int BLANK = 0;
	static final int WALL = 1;
	static final int VIRUS = 2;
	static final int MAX_WALL = 3;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);
		map = new int[n][m];
		
		for(int i = 0; i < n; i++){
			input = br.readLine().split(" ");
			for(int j = 0; j < m; j++){
				map[i][j] = Integer.parseInt(input[j]);
				if(map[i][j] == VIRUS) virusq.add(new Dev(i, j));
			}
		}
		
		dfs(0, 0, 0);
		System.out.println(ans);
	}
	
	public static void dfs(int x, int y, int cnt){
		if(cnt == MAX_WALL){
			bfs();
			return;
		}
		
		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++){
				if(map[i][j] == BLANK){
					map[i][j] = WALL;
					dfs(i, j, cnt + 1);
					map[i][j] = BLANK;
				}
			}
		}
	}
	
	public static void bfs(){
		Queue<Dev> q = new LinkedList<Dev>();
		q.addAll(virusq);
		check = new boolean[n][m];
		
		while(!q.isEmpty()){
			Dev p = q.remove();
			int px = p.x;
			int py = p.y;
			
			for(int i = 0; i < 4; i++){
				int rx = px + dx[i];
				int ry = py + dy[i];
				if(0 <= rx && rx < n && 0 <= ry && ry < m){
					if(map[rx][ry] == 0 && check[rx][ry] == false){
						check[rx][ry] = true;
						q.add(new Dev(rx, ry));
					}
				}
			}
		}
		
		findSafetyArea();
	}
	
	public static void findSafetyArea(){
		int cnt = 0;
		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++){
				if(map[i][j] == 0 && check[i][j] == false) cnt++;
			}
		}
		
		ans = Math.max(ans, cnt);
	}

}
