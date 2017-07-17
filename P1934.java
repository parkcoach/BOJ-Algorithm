package BOJ;
import java.util.Scanner;

public class P1934 {

	public static int gcd(int a, int b){
		if(b==0)
			return a;
		else
			return gcd(b,a%b);
	}

	public static int lcm(int a, int b, int g){
		int l = a*b/g;
		return l;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		for(int i=0;i<t;i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			int g = gcd(a,b);
			int l = lcm(a,b,g);
			System.out.println(l);
		}
	}

}
