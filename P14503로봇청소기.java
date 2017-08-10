package BOJ;
import java.io.*;
import java.util.*;

public class P14503로봇청소기 {
	static int[][] map = new int[51][51];
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		input = br.readLine().split(" ");
		int r = Integer.parseInt(input[0]);
		int c = Integer.parseInt(input[1]);
		int d = Integer.parseInt(input[2]);

		for(int i=0;i<n;i++){
			String[] line = br.readLine().split(" ");
			for(int j=0;j<m;j++){
				map[i][j] = Integer.parseInt(line[j]);
			}
		}

		System.out.println(clean(n,m,r,c,d));
	}

	public static int clean(int n, int m, int r, int c, int d){
		int cnt = 0;
		int temp = 0;
		while(true){
			if(map[r][c]==0){
				map[r][c] = 2; //1.현재 위치를 청소한다.
				cnt++;
			}

			boolean state = false;
			for(int i=0;i<4;i++){
				temp = d-1 >= 0 ? d-1 : 3;
				if(map[r+dx[temp]][c+dy[temp]]==0){ //2.1왼쪽에 청소를 안했으면 1번으로 돌아간다.
					r = r+dx[temp];
					c = c+dy[temp];
					d = temp;
					state=true;
					break;
				}
				else{
					d = temp;
				}
			}


			if(!state){
				temp = d-2 >= 0 ? d-2 : d+2;

				r = r+dx[temp];
				c = c+dy[temp];
				if(map[r][c]==1)
					return cnt;
			}
		}
	}
}
