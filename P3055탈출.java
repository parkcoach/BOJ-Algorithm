package BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Position{
	int x, y;
	Position(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class P3055≈ª√‚ {
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static int[][] go = new int[51][51];
	static int[][] water = new int[51][51];
	static int[][] visit = new int[51][51];
	static Queue<Position> q_go = new LinkedList<Position>();
	static Queue<Position> q_water = new LinkedList<Position>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		int ansX = 0;
		int ansY = 0;

		for(int i=0;i<n;i++){
			String line = br.readLine();
			for(int j=0;j<m;j++){
				if(line.charAt(j)=='.'){ //∫Û∞˜ 
					continue;
				}
				else if(line.charAt(j)=='*'){ //π∞ ¬˜¿÷¥¬ ∞˜
					water[i][j] = 1;
					q_water.add(new Position(i,j));
				}

				else if(line.charAt(j)=='X'){ //µπ
					go[i][j] = -1;
				}
				else if(line.charAt(j)=='D'){ //∫Òπˆ ±º
					go[i][j] = -2;
					ansX = i;
					ansY = j;
				}
				else if(line.charAt(j)=='S'){ //∞ÌΩøµµƒ° ¿ßƒ°
					go[i][j] = 1;
					visit[i][j] = 1;
					q_go.add(new Position(i,j));
				}
			}
		}

		water_numbering(n,m);
		map_go(n,m);

		if(go[ansX][ansY]==-2)
			System.out.println("KAKTUS");
		else
			System.out.println(go[ansX][ansY]-1);


	}

	public static void water_numbering(int n, int m){
		while(!q_water.isEmpty()){

			Position p = q_water.remove();
			int px = p.x;
			int py = p.y;
			for(int i=0;i<4;i++){
				int rx = px + dx[i];
				int ry = py + dy[i];
				if(0<=rx && 0<=ry && rx<n && ry<m){
					if(water[rx][ry]==0 && go[rx][ry]>-1){
						q_water.add(new Position(rx,ry));
						water[rx][ry] = water[px][py]+1;
					}
				}
			}
		}
	}

	public static void map_go(int n, int m){
		while(!q_go.isEmpty()){
			Position p = q_go.remove();
			int px = p.x;
			int py = p.y;
			for(int i=0;i<4;i++){
				int rx = px + dx[i];
				int ry = py + dy[i];
				if(0<=rx && 0<=ry && rx<n && ry<m){
					if(go[rx][ry]!=-1 && visit[rx][ry]==0){
						if(water[rx][ry]-go[px][py]>=2 || water[rx][ry]==0){
							go[rx][ry] = go[px][py]+1;
							q_go.add(new Position(rx,ry));
							visit[rx][ry] = 1;
						}
					}
				}
			}
		}
	}

}
