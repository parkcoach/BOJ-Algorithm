package BOJ;
import java.util.*;

public class P1260 {
	static ArrayList<Integer>[] a;
	static int[] check;
	
	public static void dfs(int start){
		if(check[start]==1)
			return;
		
		check[start] = 1;
		System.out.print(start+" ");
		
		for(int x : a[start]){
			if(check[x]==0)
				dfs(x);
		}
	}
	
	public static void bfs(int start){
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);
		check[start] = 1;
		
		while(!q.isEmpty()){
			int x = q.remove();
			System.out.print(x+" ");
			
			for(int y : a[x]){
				if(check[y]==0){
					check[y] = 1;
					q.add(y);
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int edge = sc.nextInt();
		int line = sc.nextInt();
		int start = sc.nextInt();
		a = (ArrayList<Integer>[]) new ArrayList[edge+1];
		
		for(int i=1;i<=edge;i++){
			a[i] = new ArrayList<Integer>();
		}
		
		for(int i=0;i<line;i++){
			int u = sc.nextInt();
			int v = sc.nextInt();
			a[u].add(v);
			a[v].add(u);
		}
		
		for(int i=1;i<=edge;i++){
			Collections.sort(a[i]);
		}
		
		check = new int[edge+1];
		dfs(start);
		System.out.println();
		
		check = new int[edge+1];
		bfs(start);

	}

}
