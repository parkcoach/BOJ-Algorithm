package BOJ;
import java.util.*;

public class P9019 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test_case = sc.nextInt();

		while(test_case-- > 0){
			int start = sc.nextInt();
			int last = sc.nextInt();
			boolean[] check = new boolean[10000];
			String[] line = new String[10000];

			String ans = bfs(check, line, start, last);
			System.out.println(ans);
		}

	}

	public static String bfs(boolean[] check, String[] line, int start, int last){
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);
		check[start] = true;
		line[start] = "";
		int position = 0;
		int c = start;

		while(!q.isEmpty()){
			position = q.remove();

			if(position==last){
				return line[position];
			}

			c = (position*2)%10000;
			if(check[c]==false){
				q.add(c);
				check[c] = true;
				line[c] = line[position]+"D";
			}

			c = position-1;
			if(c==-1) c = 9999;
			if(check[c]==false){
				check[c] = true;
				q.add(c);
				line[c] = line[position]+"S";
			}

			c = (position%1000)*10+position/1000;
			if(check[c]==false){
				q.add(c);
				check[c] = true;
				line[c] = line[position]+"L";
			}

			c = (position%10)*1000+position/10;
			if(check[c]==false){
				q.add(c);
				check[c] = true;
				line[c] = line[position]+"R";
			}
		}

		return line[last];
	}
}
