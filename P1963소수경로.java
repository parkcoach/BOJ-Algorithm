package BOJ;
import java.util.*;

public class P1963소수경로 {

	public static int prime_next(int position, int index, int digit){
		//		if(index==0 && digit==0)
		//			return -1;

		StringBuilder s = new StringBuilder(Integer.toString(position));
		s.setCharAt(index, (char)(digit+'0'));
		String line = "";
		line = line + s;
		int value = Integer.parseInt(line);
		return value;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test_case = sc.nextInt();
		boolean[] prime = new boolean[10000];

		for(int i=1000;i<10000;i++){
			int value = 0;
			for(int j=2;j<i/2;j++){
				if(i%j==0)
					value++;
			}
			if(value==0)
				prime[i] = true;
		}

		while(test_case-- > 0){
			int start = sc.nextInt();
			int last = sc.nextInt();
			int next = 0;
			int position = start;
			int[] check = new int[10000];
			int[] dest = new int[10000];
			Arrays.fill(check, -1);
			check[position] = 0;

			if(start==last)
				System.out.println(0);

			else{
				Queue<Integer> q = new LinkedList<Integer>();
				q.add(start);
				check[start] = 0;

				while(!q.isEmpty()){
					position = q.remove();
					for(int i=0;i<4;i++){
						for(int j=0;j<10;j++){
							next = prime_next(position,i,j);

							if(prime[next]==true && check[next]==-1){
								q.add(next);
								check[next] = check[position]+1;
							}

						}
					}
				}
				System.out.println(check[last]);
			}
		}

	}

}