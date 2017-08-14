package BOJ;
import java.util.*;

public class P14499�ֻ��������� {
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

		int input = 0; // ��� �Լ��� ���� ������ ����
		int temp = 0; // �ֻ��� ��ü�� ó�� ���� ������ ����
		int up=0, down=0, left=0, right=0, front=0, behind=0; //�ֻ��� ��ü
		for(int i=0;i<k;i++){
			input = command[i] - 1;
			if(x+dx[input]<0 || y+dy[input]<0 || n<=x+dx[input] || m<=y+dy[input])
				continue; //�ֻ����� ���� ������ �̵���ų ��� continue
			
			if(input==0){ // �������� �� ���
				temp = right;
				right = up;
				up = left;
				left = down;
				down = temp;
			}
			
			else if(input==1){ // �������� �� ���
				temp = left;
				left = up;
				up = right;
				right = down;
				down = temp;
			}
			
			else if(input==2){ // �������� �� ���	
				temp = front;
				front = up;
				up = behind;
				behind = down;
				down = temp;
			}
			
			else{ // �������� �� ���
				temp = behind;
				behind = up;
				up = front;
				front = down;
				down = temp;
			}
			
			x = x+dx[input]; //�̵��� x��
			y = y+dy[input]; //�̵��� y��
			if(map[x][y]!=0){ //�̵��� ������ ���� 0�� �ƴϸ�
				down = map[x][y]; //�ظ��� ������ ������ �����ϰ�
				map[x][y] = 0; //������ ���� 0���� �ٲ۴�
			}
			else
				map[x][y] = down;
			System.out.println(up); //�ֻ��� ���� ���
		}
	}

}