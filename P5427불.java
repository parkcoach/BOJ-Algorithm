package BOJ;
import java.util.*;

class Fire{
	int x,y;
	Fire(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class P5427�� {
	static int test_case, n, m;
	static int[][] map;
	static boolean[][] check;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static Queue<Fire> q; //����� ��ġ
	static Queue<Fire> f; //�� ��ġ

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		test_case = sc.nextInt();

		while(test_case-- > 0){
			m = sc.nextInt(); 
			n = sc.nextInt();
			sc.nextLine();

			q = new LinkedList<Fire>();
			f = new LinkedList<Fire>();
			map = new int[1001][1001];
			check = new boolean[1001][1001];

			for(int i=0;i<n;i++){
				String line = sc.nextLine();
				for(int j=0;j<m;j++){
					char ch = line.charAt(j);
					if(ch=='.') map[i][j] = 0; //.������� �� 0
					else if(ch=='#') map[i][j] = 1; //#���϶� 1
					else if(ch=='@'){ //@������� �� 2
						q.add(new Fire(i,j)); 
						map[i][j] = 2;
						check[i][j] = true;
					}
					else{ //*���� �� -1
						f.add(new Fire(i,j));
						map[i][j] = -1;
						check[i][j] = true;
					}
				}
			}

			int ans = bfs();
			if(ans!=-1) System.out.println(ans);
			else System.out.println("IMPOSSIBLE");

		}

	}

	public static int bfs(){
		int ans = 0;
		while(!q.isEmpty()){
			LinkedList<Fire> list = new LinkedList<Fire>(); //�Ҹ��� �̵���
			while(!f.isEmpty()){ //�ҽϴ� �ھ�
				list.add(f.remove());
			}

			for(Fire p : list){
				int px = p.x;
				int py = p.y;
				for(int i=0;i<4;i++){
					int rx = px + dx[i];
					int ry = py + dy[i];
					if(rx<0 || n<=rx || ry<0 || m<=ry) continue;
					if(map[rx][ry]==1) continue;
					if(check[rx][ry]) continue;
					f.add(new Fire(rx,ry));
					check[rx][ry]=true;
					map[rx][ry] = -1;
				}
			}

			LinkedList<Fire> list2 = new LinkedList<Fire>(); //�Ҹ��� �̵���
			while(!q.isEmpty()){ //�ҽϴ� �ھ�
				list2.add(q.remove());
			}

			for(Fire p : list2){//����� �̵���
				int px = p.x;
				int py = p.y;
				for(int i=0;i<4;i++){
					int rx = px + dx[i];
					int ry = py + dy[i];
					if(rx<0 || n<=rx || ry<0 || m<=ry){
						return ans+1;
					}
					if(map[rx][ry]==1 || map[rx][ry]==-1) continue;
					if(check[rx][ry]) continue;
					q.add(new Fire(rx,ry));
					check[rx][ry] = true;
				}
			}
			ans++;
		}
		return -1;

	}

}