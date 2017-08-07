//package BOJ;
//import java.io.*;
//import java.util.*;
//
//class Pair{
//	int x;
//	int y;
//	Pair(int x, int y){
//		this.x = x;
//		this.y = y;
//	}
//}
//
//public class P1261¾Ë°í½ºÆÌ {
//	static int[][] map = new int[101][101];
//	static int[][] check = new int[101][101];
//	static int[] dx = {0,0,-1,1};
//	static int[] dy = {-1,1,0,0};
//	static int max = 1000000;
//
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		String[] input = br.readLine().split(" ");
//		int m = Integer.parseInt(input[0]);
//		int n = Integer.parseInt(input[1]);
//
//		for(int i=0;i<n;i++){
//			String line = br.readLine();
//			for(int j=0;j<m;j++){
//				map[i][j] = line.charAt(j)-'0';
//				check[i][j] = max;
//			}
//		}
//
//		bfs(0,0,n,m);
//		System.out.println(check[n-1][m-1]);
//
//	}
//
//	public static void bfs(int x, int y, int n, int m){
//		Queue<Pair> q = new LinkedList<Pair>();
//		q.add(new Pair(x,y));
//		check[x][y] = 0;
//
//		while(!q.isEmpty()){
//			Pair p = q.remove();
//			int px = p.x;
//			int py = p.y;
//			for(int i=0;i<4;i++){
//				int rx = px + dx[i];
//				int ry = py + dy[i];
//				if(0<=rx && rx<n && 0<=ry && ry<m){
//					if(check[rx][ry] > check[px][py] + map[rx][ry]){
//						check[rx][ry] = check[px][py] + map[rx][ry];
//						q.add(new Pair(rx,ry));
//					}
//				}
//			}
//		}
//	}
//
//}