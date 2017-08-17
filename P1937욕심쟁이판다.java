package BOJ;
import java.util.*;
import java.io.*;

class Tree{
	int x,y,c;
	Tree(int x, int y, int c){
		this.x = x;
		this.y = y;
		this.c = c;
	}
}

public class P1937øÂΩ…¿Ô¿Ã∆«¥Ÿ {
	static int[][] map = new int[501][501];
	static int[][] check = new int[501][501];
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Queue<Tree> q = new LinkedList<Tree>();
		for(int i=0;i<n;i++){
			String[] line = br.readLine().split(" ");
			for(int j=0;j<n;j++){
				map[i][j] = Integer.parseInt(line[j]);
				q.add(new Tree(i,j,1));
			}
		}
		
		int ans = 0;
		while(!q.isEmpty()){
			Tree t = q.remove();
			int tx = t.x;
			int ty = t.y;
			int tc = t.c;
			if(ans<tc) ans = tc;
			for(int i=0;i<4;i++){
				int rx = tx + dx[i];
				int ry = ty + dy[i];
				if(0<=rx && rx<n && 0<=ry && ry<n){
					if(map[rx][ry]>map[tx][ty]){
						q.add(new Tree(rx,ry,tc+1));
					}
				}
			}
		}
		System.out.println(ans);
	}

}
