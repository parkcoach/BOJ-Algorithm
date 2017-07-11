package BOJ;
import java.util.*;

public class P1158 {
	static Queue<Integer> q = new LinkedList<Integer>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		for(int i=1;i<=n;i++){
			q.add(i);
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		for(int i=1;i<n;i++){
			for(int j=1;j<m;j++){
				q.add(q.remove());
			}
			sb.append(q.remove()+", ");
		}
		sb.append(q.remove()+">");
		System.out.println(sb);
		

	}

}
