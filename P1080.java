package BOJ;
import java.util.*;

public class P1080 {
	static int[][] a = new int[50][50];
	static int[][] b = new int[50][50];
	
	public static void toggle(int x, int y){
		for(int i = x-1; i<=x+1;i++){
			for(int j = y-1;j<=y+1;j++){
				a[i][j] = 1-a[i][j];
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		sc.nextLine();
		for(int i=0;i<n;i++){
			String line = sc.nextLine();
			for(int j=0;j<m;j++){
				a[i][j] = line.charAt(j)-'0';
			}
		}
		
		for(int i=0;i<n;i++){
			String line = sc.nextLine();
			for(int j=0;j<m;j++){
				b[i][j] = line.charAt(j)-'0';
			}
		}
		
		int ans = 0;
		
		for(int i=0;i<n-2;i++){
			for(int j=0;j<m-2;j++){
				if(a[i][j]!=b[i][j]){
					ans+=1;
					toggle(i+1,j+1);
				}
			}
		}
		
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				if(a[i][j]!=b[i][j]){
					ans=-1;
				}
			}
		}

		System.out.println(ans);
	}

}
