package BOJ;
import java.util.*;

public class P1697¼û¹Ù²ÀÁú {
	
	public static int bfs(int start, int last, int[] check){
		Arrays.fill(check, -1);
		Queue<Integer> q = new LinkedList<Integer>();
		check[start] = 0;
		q.add(start);
		int position = 0;
		
		if(start > last){
			return start - last;
		}
		
		while(!q.isEmpty()){
			position = q.remove();
			if(position==last)
				return check[position];
			
			if(position-1 >= 0 && check[position-1]==-1){
				q.add(position-1);
				check[position-1] = check[position]+1;
			}
			if(position+1 <= 100000 && check[position+1]==-1){
				q.add(position+1);
				check[position+1] = check[position]+1;
			}
			if(position*2 <= 100000 && check[position*2]==-1){
				q.add(position*2);
				check[position*2] = check[position]+1;
			}
		}
		return check[position];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int start = sc.nextInt();
		int last = sc.nextInt();
		int[] check = new int[100001];
		int ans = bfs(start, last, check);
		System.out.println(ans);
	}

}
