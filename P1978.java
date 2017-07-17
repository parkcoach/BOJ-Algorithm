package BOJ;
import java.util.*;

public class P1978 {
	
	public static boolean sosu(int a){
		if(a<2)
			return false;
		
		for(int i=2;i*i<=a;i++){
			if(a%i==0)
				return false;
		}
		
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		int count=0;
		
		for(int i=0;i<n;i++){
			a[i] = sc.nextInt();
			if(sosu(a[i])==true)
				count++;
		}
		
		System.out.println(count);

	}

}