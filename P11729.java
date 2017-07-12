package BOJ;
import java.util.*;

class Hanoi{
	int x;
	int y;
	Hanoi(int x, int y){
		this.x = x;
		this.y = y;
	}
}
public class P11729 {
	static int count;
	static Queue<Hanoi> q = new LinkedList<Hanoi>();
	
	public static void solve(int n, int x, int y){
		if(n==0)
			return;
		solve(n-1,x,6-x-y);
		q.add(new Hanoi(x,y));
		count++;
		solve(n-1,6-x-y,y);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		count = 0;
		solve(n,1,3);
		System.out.println(count);
		for(Hanoi h : q){
			int x = h.x;
			int y = h.y;
			System.out.println(x+" "+y);
		}

	}

}
