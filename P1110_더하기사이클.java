package BOJ;
import java.util.*;
import java.io.*;
import java.text.DecimalFormat;

public class P1110_더하기사이클 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int real = Integer.parseInt(br.readLine());
		int count = 1;
		int num = real;
		int last = 0;
		boolean state = true;

		last = num/10+num%10;
		num = num%10*10+last%10;

		while(real!=num){
			last = num/10+num%10;
			num = num%10*10+last%10;
			count++;
		}
		System.out.println(count);

	}
}

