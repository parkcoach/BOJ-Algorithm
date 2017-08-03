package BOJ;
import java.util.*;

public class P9663N_Queen {
	static boolean[] check_row = new boolean[15];
	static boolean[] check_col = new boolean[15];
	static boolean[] check_c_front = new boolean[30];
	static boolean[] check_c_back = new boolean[30];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ans = back(0,n);
		System.out.println(ans);
	}

	public static int back(int row, int n){
		if(row==n)
			return 1;

		int ans = 0;
		for(int col=0;col<n;col++){
			if(check(row, col,n)){
				check_row[row] = true;
				check_col[col] = true;
				check_c_front[row-col+n] = true;
				check_c_back[row+col] = true;
				ans += back(row+1, n);
				check_row[row] = false;
				check_col[col] = false;
				check_c_front[row-col+n] = false;
				check_c_back[row+col] = false;
			}
		}
		return ans;
	}
	
	public static boolean check(int row, int col, int n){
		if(check_row[row])
			return false;
		
		if(check_col[col])
			return false;
		
		if(check_c_front[row-col+n])
			return false;
		
		if(check_c_back[row+col])
			return false;
		
		return true;
	}

}
