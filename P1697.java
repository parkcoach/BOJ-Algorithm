package BOJ;
import java.io.*;
import java.util.Queue;
import java.util.Arrays;
import java.util.LinkedList;

public class P1697 {
	static int[] check = new int[100001];
	
	public static int bfs(int start, int last){
		Arrays.fill(check, -1);
		Queue<Integer> q = new LinkedList<Integer>();
		check[start] = 0;
		q.add(start);
		int position = 0;
		
		if(last<start)
			return start-last;
		
		while(!q.isEmpty()){
			position = q.remove();
			if(position==last){
				return check[position];
			}
			if(position-1 >=0 && check[position-1]==-1){
				q.add(position-1);
				check[position-1] = check[position]+1;
			}
			if(position+1 < 100001 && check[position+1]==-1){
				q.add(position+1);
				check[position+1] = check[position]+1;
			}
			if(position*2 < 100001 && check[position*2]==-1){
				q.add(position*2);
				check[position*2] = check[position]+1;
			}
		}
		return 0;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		int start = Integer.parseInt(line[0]);
		int last = Integer.parseInt(line[1]);
		System.out.println(bfs(start, last));
	}
}