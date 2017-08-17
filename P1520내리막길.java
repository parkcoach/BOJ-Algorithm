package BOJ;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Road{
	int x,y;
	Road(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class P1520내리막길 {
	static int[][] map = new int[501][501];
	static int[][] check = new int[501][501];
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				map[i][j] = sc.nextInt();
			}
		}
		
		bfs(0,0,n,m);
		System.out.println(check[n-1][m-1]);
	}
	
	public static void bfs(int x, int y, int n, int m){
		Queue<Road> q = new LinkedList<Road>();
		check[x][y] = 1;
		q.add(new Road(x,y));
		
		while(!q.isEmpty()){
			Road r = q.remove();
			int px = r.x;
			int py = r.y;
			
			for(int i=0;i<4;i++){
				int rx = px + dx[i];
				int ry = py + dy[i];
				if(0<=rx && rx<n && 0<=ry && ry<m){
					if(map[px][py]>map[rx][ry]){
						q.add(new Road(rx,ry));
						check[rx][ry] = check[px][py] + 1;
					}
				}
			}
		}
	}
	
}