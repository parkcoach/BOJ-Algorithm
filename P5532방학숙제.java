package BOJ;

import java.util.Scanner;

public class P5532¹æÇÐ¼÷Á¦ {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int l = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();
		int ans = 0;
		
		while(true){
			if(a<=0 && b<=0) break;
			
			ans++;
			
			a-=c;
			b-=d;
		}

		System.out.println(l-ans);
	}

}
