package BOJ;
import java.util.*;

public class P1744 {
	static ArrayList<Integer>[] graph;
	static int[] color;
	
	public static void dfs(int vertax, int c){
		color[vertax] = c;
		
		for(int x : graph[vertax]){
			if(color[x]==0){
				dfs(x,3-c);
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test_case = sc.nextInt();
		
		while(test_case-- > 0){
			int vertax = sc.nextInt();
			int edge = sc.nextInt();
			graph = (ArrayList<Integer>[]) new ArrayList[20001];
			color = new int[20001];
			
			for(int i=1;i<=vertax;i++){
				graph[i] = new ArrayList<Integer>();
			}
			
			for(int i=0;i<edge;i++){
				int start = sc.nextInt();
				int last = sc.nextInt();
				graph[start].add(last);
				graph[last].add(start);
			}
			
			for(int i=1;i<=vertax;i++){
				if(color[i]==0){
					dfs(i,1);
				}
			}
			
			boolean ok = true;
			for(int i=1;i<=vertax;i++){
				for(int j : graph[i]){
					if(color[i]==color[j]){
						ok = false;
					}
				}
			}
			
			if(ok==true)
				System.out.println("YES");
			else
				System.out.println("NO");
			
			
		}

	}

}
