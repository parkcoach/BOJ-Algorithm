package BOJ;
import java.util.*;

class Room{
	int start;
	int end;
	
	Room(int start, int end){
		this.start = start;
		this.end = end;
	}
}

public class P1931회의실배정 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Room[] r = new Room[n];
		
		for(int i=0;i<n;i++){
			int start = sc.nextInt();
			int end = sc.nextInt();
			r[i] = new Room(start, end);
		}
		
		Arrays.sort(r, new Comparator<Room>(){
			@Override
			public int compare(Room r1, Room r2){
				if(r1.end == r2.end)
					return r1.start-r2.start;
				else
					return r1.end-r2.end;
			}
		});
		
		int ans = 0;
		int now = 0;
		for(int i=0;i<n;i++){
			if(now <= r[i].start){
				now = r[i].end;
				ans += 1;
			}
		}
		
		System.out.println(ans);
	}

}