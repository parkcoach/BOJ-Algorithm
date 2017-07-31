package BOJ;
import java.util.*;

public class P1525∆€¡Ò {
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int start = 0;
		int temp = 0;

		for(int i=0;i<9;i++){
			temp = sc.nextInt();
			if(temp==0)
				temp=9;
			start = start*10+temp;
		}

		int ans = bfs(start);
		System.out.println(ans);

	}

	public static int bfs(int start){
		Queue<Integer> q = new LinkedList<Integer>();
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		q.add(start);
		map.put(start, 0);

		while(!q.isEmpty()){
			int now = q.remove();
			String line = Integer.toString(now);
			int index = line.indexOf('9');
			int x = index/3;
			int y = index%3;

			for(int i=0;i<4;i++){
				int rx = x+dx[i];
				int ry = y+dy[i];
				if(0<=rx && 0<=ry && rx<3 && ry<3){
					StringBuilder sb = new StringBuilder(line);
					char zero = sb.charAt(x*3+y);
					sb.setCharAt(x*3+y, sb.charAt(rx*3+ry));
					sb.setCharAt(rx*3+ry, zero);
					int next = Integer.parseInt(sb.toString());
					if(!map.containsKey(next)){
						q.add(next);
						map.put(next, map.get(now)+1);
					}
				}
			}
		}

		if(map.containsKey(123456789))
			return map.get(123456789);
		else 
			return -1;

	}

}
