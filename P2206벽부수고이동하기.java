package BOJ;
import java.util.*;
import java.io.*;

class Pair{
	int x;
	int y;
	int z;
	Pair(int x, int y, int z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
}

public class P2206벽부수고이동하기 {
	static int[][] map = new int[1001][1001];
	static int[][][] check = new int[1001][1001][2];
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);

		for(int i=0;i<n;i++){
			String line = br.readLine();
			for(int j=0;j<m;j++){
				map[i][j] = line.charAt(j)-'0';
			}
		}

		bfs(0,0,n,m);
		
		if(check[n-1][m-1][0]!=0 && check[n-1][m-1][1]!=0)
			System.out.println(Math.min(check[n-1][m-1][0],check[n-1][m-1][1]));
		else if(check[n-1][m-1][0]!=0)
			System.out.println(check[n-1][m-1][0]);
		else if(check[n-1][m-1][1]!=0)
			System.out.println(check[n-1][m-1][1]);
		else 
			System.out.println(-1);
		
	}

	public static void bfs(int x, int y, int n, int m){
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(0,0,0));
		check[0][0][0] = 1;

		while(!q.isEmpty()){
			Pair p = q.remove();
			int px = p.x;
			int py = p.y;
			int pz = p.z;
			for(int i=0;i<4;i++){
				int rx = px + dx[i];
				int ry = py + dy[i];
				if(rx<0 || ry<0 || n<=rx || m<=ry) continue;
				if(map[rx][ry]==0 && check[rx][ry][pz]==0){
					check[rx][ry][pz] = check[px][py][pz] + 1;
					q.add(new Pair(rx,ry,pz));
				}
				if(map[rx][ry]==1 && pz==0 && check[rx][ry][pz+1]==0){
					check[rx][ry][pz+1] += check[px][py][pz] + 1;
					q.add(new Pair(rx,ry,pz+1));
				}

			}
		}
	}
}