package BOJ;
import java.util.*;

public class P9663N_Queen2 {
	static boolean[][] map = new boolean[15][15];
	static int ans = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		back(0, n);
		System.out.println(ans);
	}

	public static void back(int row, int n){
		if(row==n)
			ans+=1;

		for(int col = 0;col<n;col++){
			map[row][col] = true;
			if(check(row, col))
				back(row+1, n);
			map[row][col] = false;
		}
	}

	public static boolean check(int row, int col){
		for(int i=0;i<row;i++){
			if(map[i][col]==true)
				return false;
		}

		for(int i=0;i<col;i++){
			if(map[row][i]==true)
				return false;
		}

		int x = row-1;
		int y = col-1;
		while(x>=0 && y>=0){
			if(map[x][y]==true)
				return false;
			x--;
			y--;
		}

		x = row-1;
		y = col-1;
		while(x>=0 && y>=0){
			if(map[x][y]==true)
				return false;
			x--;
			y++;
		}
		return true;
	}

}
