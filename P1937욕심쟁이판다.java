package BOJ;
import java.io.*;

public class P1937욕심쟁이판다 {
	static int n, max = Integer.MIN_VALUE;
	static int[][] map = new int[501][501];
	static int[][] check = new int[501][501];
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		
		for(int i=0;i<n;i++){
			input = br.readLine().split(" ");
			for(int j=0;j<n;j++){
				map[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(check[i][j]!=0) continue;
				dfs(i, j);
			}
		}
		System.out.println(max);
	}
	
	public static void dfs(int x, int y){
		int nextX, nextY, depth = 0;
		
		for(int i=0;i<4;i++){
			nextX = x + dx[i];
			nextY = y + dy[i];
			if(nextX < 0 || n <= nextX || nextY < 0 || n <= nextY) continue;
			if(map[x][y] > map[nextX][nextY]){ //큰거부터 들어간다
				if(check[nextX][nextY]==0) dfs(nextX, nextY); //0이면 탐색해줘
				if(check[nextX][nextY] > depth) depth = check[nextX][nextY]; //depth에다가 넣어주고 4방향 탐색
			}
		}
		check[x][y] = depth + 1; // 다 돌았으면 depth+1해줘
		max = Math.max(max, check[x][y]); //최대 살 수 있는 일수 구해줘
	}
}
