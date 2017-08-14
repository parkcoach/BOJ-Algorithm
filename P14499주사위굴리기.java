package BOJ;
import java.util.*;

public class P14499주사위굴리기 {
	static int[][] map = new int[21][21];
	static int[] command = new int[1001];
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		int k = sc.nextInt();
		
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				map[i][j] = sc.nextInt();
			}
		}
		
		for(int i=0;i<k;i++){
			command[i] = sc.nextInt();
		}

		int input = 0; // 명령 함수의 값을 저장할 변수
		int temp = 0; // 주사위 객체의 처음 값을 저장할 변수
		int up=0, down=0, left=0, right=0, front=0, behind=0; //주사위 객체
		for(int i=0;i<k;i++){
			input = command[i] - 1;
			if(x+dx[input]<0 || y+dy[input]<0 || n<=x+dx[input] || m<=y+dy[input])
				continue; //주사위를 지도 밖으로 이동시킬 경우 continue
			
			if(input==0){ // 동쪽으로 갈 경우
				temp = right;
				right = up;
				up = left;
				left = down;
				down = temp;
			}
			
			else if(input==1){ // 서쪽으로 갈 경우
				temp = left;
				left = up;
				up = right;
				right = down;
				down = temp;
			}
			
			else if(input==2){ // 북쪽으로 갈 경우	
				temp = front;
				front = up;
				up = behind;
				behind = down;
				down = temp;
			}
			
			else{ // 남쪽으로 갈 경우
				temp = behind;
				behind = up;
				up = front;
				front = down;
				down = temp;
			}
			
			x = x+dx[input]; //이동할 x값
			y = y+dy[input]; //이동할 y값
			if(map[x][y]!=0){ //이동한 지도의 값이 0이 아니면
				down = map[x][y]; //밑면을 지도의 값으로 저장하고
				map[x][y] = 0; //지도의 값을 0으로 바꾼다
			}
			else
				map[x][y] = down;
			System.out.println(up); //주사위 윗면 출력
		}
	}

}