package BOJ;
import java.util.*;

class Ball{
	int rx, ry, bx, by, cnt;
	Ball(int rx, int ry, int bx, int by, int cnt){
		this.rx = rx;
		this.ry = ry;
		this.bx = bx;
		this.by = by;
		this.cnt = cnt;
	}
}

public class P13460Â°·ÎÅ»Ãâ2 {
	static final int WALL=-1, ROAD=0, RED=1, BLUE=2, HOLE=3;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), m = sc.nextInt();
		int[][] map = new int[10][10];
		int rx = 0, ry = 0, bx = 0, by = 0, gx = 0, gy = 0;

		sc.nextLine();
		for(int i=0;i<n;i++){
			String line = sc.nextLine();
			for(int j=0;j<m;j++){
				char c = line.charAt(j);
				if(c=='#') map[i][j] = WALL;
				else if(c=='.') map[i][j] = ROAD;
				else if(c=='R'){
					rx = i; ry = j;
					map[i][j] = RED;
				}
				else if(c=='B'){
					bx = i; by = j;
					map[i][j] = BLUE;
				}
				else{
					gx = i; gy = j;
					map[i][j] = HOLE;
				}
			}
		}
		
		Queue<Ball> q = new LinkedList<Ball>();
		q.add(new Ball(rx,ry,bx,by,0));
		int ans = -1;

		end:while(!q.isEmpty()){
			Ball b = q.remove();
			int redx = b.rx;
			int redy = b.ry;
			int bluex = b.bx;
			int bluey = b.by;
			int cnt = b.cnt;
			
			if(cnt >= 10) break;
			
			for(int i=0;i<4;i++){
				int next_rx = redx + dx[i];
				int next_ry = redy + dy[i];
				int blueOn = 0;
				int redEnd = 0;
				int redGo = 0;
				
				while(map[next_rx][next_ry]!=WALL){
					redGo++;
					
					if(next_rx==bluex && next_ry==bluey)
						blueOn = redGo;
					
					if(map[next_rx][next_ry]==HOLE)
						redEnd = redGo;
					
					next_rx += dx[i];
					next_ry += dy[i];
				}
				
				int next_bx = bluex + dx[i];
				int next_by = bluey + dy[i];
				boolean redOn = false;
				boolean blueEnd = false;
				int blueGo = 0;
				
				while(map[next_bx][next_by]!=WALL){
					blueGo++;
					
					if(next_bx==redx && next_by==redy)
						redOn = true;
					
					if(map[next_bx][next_by]==HOLE)
						blueEnd = true;
					
					next_bx += dx[i];
					next_by += dy[i];
				}
				
				if(redGo==0 && blueGo==0) continue;
				
				if(redOn==false && blueOn==0){
					if(blueEnd) continue;
					else if(redEnd > 0){
						ans = cnt + 1;
						break end;
					}
					else
						q.add(new Ball((redx + dx[i]*redGo),(redy + dy[i]*redGo),(bluex + dx[i]*blueGo),(bluey + dy[i]*blueGo),cnt+1));
				}
				else if(redOn){
					if(redEnd > 0) continue;
					else{
						blueGo-=1;
						q.add(new Ball((redx + dx[i]*redGo),(redy + dy[i]*redGo),(bluex + dx[i]*blueGo),(bluey + dy[i]*blueGo),cnt+1));
					}
				}
				else if(blueOn > 0){
					if(redEnd > 0){
						if(blueOn > redEnd){
							ans = cnt + 1;
							break end;
						}
						continue;
					}
					else{
						redGo-=1;
						q.add(new Ball((redx + dx[i]*redGo),(redy + dy[i]*redGo),(bluex + dx[i]*blueGo),(bluey + dy[i]*blueGo),cnt+1));
					}
		
				}
				
			}
			
		}

		System.out.println(ans);

	}

}