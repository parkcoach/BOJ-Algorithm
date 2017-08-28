package BOJ;
import java.util.*;

class Robot{
	int x, y, d;
	Robot(int x, int y, int d){
		this.x = x;
		this.y = y;
		this.d = d;
	}
}

public class P1726·Îº¿ {
	static int n,m;
	static int[][] map = new int[101][101];
	static boolean[][][] check = new boolean[101][101][5];
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static int startX, startY, startD, endX, endY, endD;
	
	static final int EAST = 0;
	static final int SOUTH = 1;
	static final int WEST = 2;
	static final int NORTH = 3;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); m = sc.nextInt();

		for(int i=1;i<=n;i++){
			for(int j=1;j<=m;j++){
				map[i][j] = sc.nextInt();
			}
		}

		startX = sc.nextInt();
		startY = sc.nextInt();
		startD = sc.nextInt();
		startD = startD ==1 ? EAST : startD ==3 ? SOUTH : startD ==2 ? WEST : NORTH;
		endX = sc.nextInt();
		endY = sc.nextInt();
		endD = sc.nextInt();
		endD = endD ==1 ? EAST : endD ==3 ? SOUTH : endD ==2 ? WEST : NORTH;

		bfs();

	}

	public static void bfs(){
		Queue<Robot> q = new LinkedList<Robot>();
		q.add(new Robot(startX,startY,startD));
		check[startX][startY][startD] = true;
		int go = 0;

		while(!q.isEmpty()){
			LinkedList<Robot> list = new LinkedList<Robot>();
			
			while(!q.isEmpty()){
				list.add(q.remove());
			}
			for(Robot r : list){
				int rx = r.x;
				int ry = r.y;
				int rd = r.d;

				if(rx==endX && ry==endY && rd==endD){
					System.out.println(go);
					return;
				}

				for(int i=1;i<=3;i++){
					int nextX = rx + dx[rd] * i;
					int nextY = ry + dy[rd] * i;

					if(nextX < 1 || n < nextX || nextY < 1 || m < nextY) continue;
					if(check[nextX][nextY][rd]) continue;
					if(map[nextX][nextY]==1) break;
					check[nextX][nextY][rd]=true;
					q.add(new Robot(nextX, nextY, rd));


				}

				int nextD = rd-1 < 0 ? 3 : rd-1;
				if(check[rx][ry][nextD]==false){
					check[rx][ry][nextD] = true;
					q.add(new Robot(rx, ry, nextD));
				}

				nextD = rd+1 > 3 ? 0 : rd+1;
				if(check[rx][ry][nextD]==false){
					check[rx][ry][nextD] = true;
					q.add(new Robot(rx, ry, nextD));
				}
			}
			go++;
		}
	}
}