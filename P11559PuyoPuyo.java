package BOJ;
import java.util.*;
import java.io.*;

class Board{
	int x, y;
	Board(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class P11559PuyoPuyo {
	static final int cols = 12, rows = 6;
	static final int BLANK = 0;

	static int[][] map = new int[cols][rows];
	static int[][] check = new int[cols][rows];
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for(int i=0;i<cols;i++){
			String line = br.readLine();
			for(int j=0;j<rows;j++){
				if(line.charAt(j)=='.') map[i][j] = 0;
				else if(line.charAt(j)=='R') map[i][j] = 1;
				else if(line.charAt(j)=='G') map[i][j] = 2;
				else if(line.charAt(j)=='B') map[i][j] = 3;
				else if(line.charAt(j)=='P') map[i][j] = 4;
				else if(line.charAt(j)=='Y') map[i][j] = 5;
			}
		}

		int ans = 0;
		while(true){
			check = new int[cols][rows];
			boolean go = false;
			for(int i=11;i>=0;i--){
				for(int j=0;j<6;j++){
					if(map[i][j]!=BLANK && check[i][j]==BLANK){
						if(bfs(i,j)>=4){ //탐색한 부분이 4 이상일 때만 터뜨린다.
						go = true;
						}
					}
				}
			}

			if(go){ //중력으로 끌어내려라
				ans++;
				gravity();
			}
			else{ //터뜨린게 없으므로 끝내라
				System.out.println(ans);
				return;
			}
		}

	}

	public static int bfs(int x, int y){
		Queue<Board> q = new LinkedList<Board>();
		LinkedList<Board> list = new LinkedList<Board>();
		q.add(new Board(x, y));
		list.add(new Board(x,y));
		check[x][y] = 1;
		int ans = 1;

		while(!q.isEmpty()){ //탐색해라
			Board b = q.remove();
			int bx = b.x;
			int by = b.y;
			int color = map[bx][by];
			for(int i=0;i<4;i++){
				int rx = bx + dx[i];
				int ry = by + dy[i];
				if(0<=rx && rx<cols && 0<=ry && ry<rows) {
					if(map[rx][ry]==color && check[rx][ry]==0){
						q.add(new Board(rx,ry));
						list.add(new Board(rx,ry));
						check[rx][ry] = 1;
						ans++;
					}
				}
			}
		}

		if(ans >= 4){ // 4개 이상인 부분을 터뜨린다.
			for(Board b : list){
				int bx = b.x;
				int by = b.y;
				map[bx][by] = 0;
			}
		}
		return ans;
	}

	public static void gravity(){ //중력으로 끌어내린다
		for(int j=0;j<rows;j++){
			int cnt = 0;
			for(int i=11;i>=0;i--){
				if(map[i][j]==0){ //빈칸인 부분의 수를 샌다
					cnt++;
				}
				else{ //빈칸의 수만큼 끌어내린다
					int color = map[i][j];
					map[i][j] = 0;
					map[i+cnt][j] = color;
				}
			}
		}
	}
}