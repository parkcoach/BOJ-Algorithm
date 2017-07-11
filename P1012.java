package BOJ;
import java.util.*;

class Point{
	int x;
	int y;
	
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class P1012 {
	static int[][] map;
	static int[][] check;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static int n,m;
	
	public static void bfs(int x,int y){
		Queue<Point> q = new LinkedList<Point>();
		check[y][x] = 1;
		q.add(new Point(x,y));
		
		while(!q.isEmpty()){
			LinkedList<Point> list = new LinkedList<Point>();
			while(!q.isEmpty()){
				list.add(q.remove());
			}
			
			for(Point p : list){
				int px = p.x;
				int py = p.y;
				
				for(int i=0;i<4;i++){
					int rx = px + dx[i];
					int ry = py + dy[i];
					
					if(0<=rx && rx<n && 0<=ry && ry<m){
						if(map[ry][rx]==1 && check[ry][rx]==0){
							check[ry][rx]=1;
							q.add(new Point(rx,ry));
						}
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test_case = sc.nextInt();
		
		while(test_case-- > 0){
			Queue<Point> q = new LinkedList<Point>();
			n = sc.nextInt();
			m = sc.nextInt();
			int num = sc.nextInt();
			map = new int[m][n];
			check = new int[m][n];
			
			for(int i=0;i<num;i++){
				int x = sc.nextInt();
				int y = sc.nextInt();
				map[y][x] = 1;
				q.add(new Point(x,y));
			}
			
			int count = 0;
			for(Point p : q){
				int px = p.x;
				int py = p.y;
				if(check[py][px]==0){
					bfs(px,py);
					count++;
				}
			}
			System.out.println(count);
		}
	}
}