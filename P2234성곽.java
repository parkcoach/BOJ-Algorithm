package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

class Castel{
	int x, y;
	Castel(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class P2234¼º°û {
	static int n, m, Max_RoomNumber = 0;
	static int[][] map = new int[51][51];
	static int[][] check = new int[51][51];
	static int[] dx = {0, -1, 0, 1};
	static int[] dy = {-1, 0, 1, 0};
	static int[] d = {1, 2, 4, 8};
	static ArrayList<Integer> roomSize = new ArrayList<Integer>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		m = Integer.parseInt(input[0]);
		n = Integer.parseInt(input[1]);

		for(int i=0;i<n;i++){
			input = br.readLine().split(" ");
			for(int j=0;j<m;j++){
				map[i][j] = Integer.parseInt(input[j]);
			}
		}

		int cnt = 1;
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				if(check[i][j]==0){
					roomSize.add(findRoomNumber(i,j,cnt++));
				}
			}
		}
		
		System.out.println(roomSize.size());
		System.out.println(Collections.max(roomSize));
		System.out.println(findMaxRoomNumber());

	}

	public static int findRoomNumber(int x, int y, int cnt){
		Queue<Castel> q = new LinkedList<Castel>();
		q.add(new Castel(x,y));
		check[x][y] = cnt;
		int Max_Room = 0;

		while(!q.isEmpty()){
			Castel c = q.remove();
			int cx = c.x;
			int cy = c.y;

			for(int i = 0; i < 4; i++){
				int rx = cx + dx[i];
				int ry = cy + dy[i];
				if(0<=rx && rx<n && 0<=ry && ry<m){
					if(((~map[cx][cy])&d[i])==d[i] && check[rx][ry]==0){
						check[rx][ry] = cnt;
						q.add(new Castel(rx,ry));
					}
				}
			}
			Max_Room++;
		}
		return Max_Room;
	}

	public static int findMaxRoomNumber(){
		int max = Integer.MIN_VALUE;
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				for(int k=0;k<4;k++){
					int x = i + dx[k];
					int y = j + dy[k];
					if(0<=x && x<n && 0<=y && y<m){
						int currentNum = check[i][j];
						int nextNum = check[x][y];
						if(currentNum != nextNum){
							max = Math.max(max, roomSize.get(currentNum-1) + roomSize.get(nextNum-1));
						}
					}
				}
			}
		}
		return max;
	}
}