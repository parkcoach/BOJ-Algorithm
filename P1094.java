package BOJ;
import java.util.*;

public class P1094 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[8];
		int index=0;
		int count=0;
		int nmg=0;
		int mok=0;

		while(n!=0){
			mok = n/2;
			nmg = n%2;
			n = mok;
			a[index] = nmg;

			if(a[index]==1)
				count++;

			index++;
		}
		System.out.println(count);
	}
}