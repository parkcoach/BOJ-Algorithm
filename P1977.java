package BOJ;
import java.io.*;
import java.util.*;

public class P1977 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);		
		int start = sc.nextInt();
		int last = sc.nextInt();
		int min = 0;
		int sum = 0;
		boolean state = true;

		for(int i = start; i<=last;i++){
			if(i==((int)Math.sqrt(i)*(int)Math.sqrt(i))){
				sum += i;
				if(state==true){
					min = i;
					state = false;
				}
			}
		}
		if(sum==0)
			System.out.println(-1);
		else{
			System.out.println(sum);
			System.out.println(min);
		}
	}
}