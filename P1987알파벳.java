package BOJ;
import java.io.*;

public class P1987¾ËÆÄºª {
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static int ans = 0;
	static int[][] ch;
	static boolean[] al;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int x = Integer.parseInt(input[0]);
		int y = Integer.parseInt(input[1]);
		ch = new int[x][y];
		al = new boolean[26];

		for(int i=0;i<x;i++){
			String line = br.readLine();
			for(int j=0;j<y;j++){
				ch[i][j] = line.charAt(j)-'A';
			}
		}
		al[ch[0][0]] = true;
		bfs(0,0,x,y,1);
		System.out.println(ans);
	}

	public static void bfs(int x, int y, int input_x, int input_y, int cnt){
		if(cnt > ans)
			ans = cnt;

		for(int i=0;i<4;i++){
			int rx = x + dx[i];
			int ry = y + dy[i];
			if(0<=rx && 0<=ry && rx<input_x && ry<input_y){
				if(!al[ch[rx][ry]]){
					al[ch[rx][ry]] = true;
					bfs(rx,ry,input_x,input_y,cnt+1);
					al[ch[rx][ry]] = false;
				}
			}
		}
	}
}