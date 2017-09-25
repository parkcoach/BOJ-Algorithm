package BOJ;
import java.util.*;
import java.io.*;

public class P14500테트로미노 {
	static int n, m;
	static int[][] map = new int[500][500];
	static boolean[][] check = new boolean[500][500];
	static int max = Integer.MIN_VALUE;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);

		for(int i=0;i<n;i++){
			input = br.readLine().split(" ");
			for(int j=0;j<m;j++){
				map[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				check[i][j] = true;
				dfs(i,j,1,map[i][j]); //dfs로 풀 수 있는 경우
				bfs(i,j,1,map[i][j]); //dfs로 풀 수 없는 4가지 경우
				check[i][j] = false;
			}
		}
		System.out.println(max);
	}
	
	public static void dfs(int x, int y, int cnt, int sum){
		if(cnt==4){
			max = Math.max(max, sum);
			return;
		}
		
		for(int i=0;i<4;i++){
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx < 0 || n <= nx || ny < 0 || m <= ny) continue;
			if(check[nx][ny]) continue;
			check[nx][ny] = true;
			dfs(nx,ny,cnt+1,sum+map[nx][ny]);
			check[nx][ny] = false;
		}
	}
	
	public static void bfs(int x, int y, int cnt, int sum){
		int out = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int i=0;i<4;i++){
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx < 0 || n <= nx || ny < 0 || m <= ny){
				out++;
				continue;
			}
			sum+=map[nx][ny];
			list.add(map[nx][ny]);
		}
		
		if(out==2) return;
		if(out==1) max = Math.max(max, sum);
		if(out==0){
			for(int value : list){
				max = Math.max(max, sum-value);
			}
		}
		return;
	}

}