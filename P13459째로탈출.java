package BOJ;
import java.util.*;
import java.io.*;

class Marble{
	int rx,ry,bx,by,cnt;
	Marble(int rx, int ry, int bx, int by, int cnt){
		this.rx = rx;
		this.ry = ry;
		this.bx = bx;
		this.by = by;
		this.cnt = cnt;
	}
}

public class P13459簞煎驍轎 {
	static final int WALL=-1, ROAD=0, RED=1, BLUE=2, HOLE=3;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		int[][] map = new int[n][m];
		int redX = 0, redY = 0, blueX = 0, blueY = 0;
		
		for(int i=0;i<n;i++){
			String line = br.readLine();
			for(int j=0;j<m;j++){
				char ch = line.charAt(j);
				
				if(ch=='#') map[i][j] = WALL;
				
				else if(ch=='.') map[i][j] = ROAD;
				
				else if(ch=='R'){
					redX = i; redY = j;
					map[i][j] = RED;
				}
				
				else if(ch=='B'){
					blueX = i; blueY = j;
					map[i][j] = BLUE;
				}
				
				else
					map[i][j] = HOLE;
			}
		}
		
		Queue<Marble> q = new LinkedList<Marble>();
		q.add(new Marble(redX, redY, blueX, blueY, 0));
		int ans = 0;
		
		go:while(!q.isEmpty()){
			Marble b = q.remove();
			int rx = b.rx;
			int ry = b.ry;
			int bx = b.bx;
			int by = b.by;
			int cnt = b.cnt;
			
			if(cnt >= 10) break;
			
			for(int i=0;i<4;i++){
				//說除奢 試盪 除棻
				int next_rx = rx + dx[i];
				int next_ry = ry + dy[i];
				boolean blueOn = false;
				boolean redEnd = false;
				int redGo = 0;
				
				while(map[next_rx][next_ry]!=WALL){
					redGo++;
					
					if(next_rx==bx && next_ry==by) blueOn = true;
					if(map[next_rx][next_ry]==HOLE) redEnd = true;
					
					next_rx += dx[i];
					next_ry += dy[i];
				}
				
				int next_bx = bx + dx[i];
				int next_by = by + dy[i];
				boolean redOn = false;
				boolean blueEnd = false;
				int blueGo = 0;
				
				while(map[next_bx][next_by]!=WALL){
					blueGo++;
					
					if(next_bx==rx && next_by==ry) redOn = true;
					if(map[next_bx][next_by]==HOLE) blueEnd = true;
					
					next_bx += dx[i];
					next_by += dy[i];
				}
				
				if(redGo==0 && blueGo==0) continue;
				
				if(redOn==false && blueOn==false){
					if(blueEnd) continue;
					else if(redEnd){
						ans = 1;
						break go;
					}
					else
						q.add(new Marble((rx+dx[i]*redGo),(ry+dy[i]*redGo),(bx+dx[i]*blueGo),(by+dy[i]*blueGo),cnt+1));
				}
				
				else if(redOn){
					if(blueEnd) continue;
					else{
						blueGo--;
						q.add(new Marble((rx+dx[i]*redGo),(ry+dy[i]*redGo),(bx+dx[i]*blueGo),(by+dy[i]*blueGo),cnt+1));
					}
				}
				
				else{
					if(blueEnd) continue;
					else if(redEnd){
						ans = 1;
						break go;
					}
					else{
						redGo--;
						q.add(new Marble((rx+dx[i]*redGo),(ry+dy[i]*redGo),(bx+dx[i]*blueGo),(by+dy[i]*blueGo),cnt+1));
					}
				}
			}
		}

		System.out.println(ans);
	}

}
