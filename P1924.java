package BOJ;
import java.util.*;
import java.io.*;

public class P1924 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		
		int[] month = new int[13];
		month[1] = 31;
		month[2] = 28;
		month[3] = 31;
		month[4] = 30;
		month[5] = 31;
		month[6] = 30;
		month[7] = 31;
		month[8] = 31;
		month[9] = 30;
		month[10] = 31;
		month[11] = 30;
		month[12] = 31;
		
		int sum_day=0;
		for(int i=0;i<x;i++){
			sum_day += month[i];
		}
		sum_day+=y;
		
		if(sum_day%7==0)
			System.out.println("SUN");
		else if(sum_day%7==1)
			System.out.println("MON");
		else if(sum_day%7==2)
			System.out.println("TUE");
		else if(sum_day%7==3)
			System.out.println("WED");
		else if(sum_day%7==4)
			System.out.println("THU");
		else if(sum_day%7==5)
			System.out.println("FRI");
		else
			System.out.println("SAT");
		
	}
}