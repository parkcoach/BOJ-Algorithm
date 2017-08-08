package BOJ;
import java.util.*;

public class P1890มกวม {
	static int[][] map = new int[101][101];
	static long[][] check = new long[101][101];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				map[i][j] = sc.nextInt();
			}
		}

		check[0][0] = 1;
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				int temp = map[i][j];
				if(map[i][j]==0) continue;
				if(j+temp<n)
					check[i][j+temp] += check[i][j];
				if(i+temp<n)
					check[i+temp][j] += check[i][j];

			}

		}
		System.out.println(check[n-1][n-1]);
	}
}