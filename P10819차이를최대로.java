package BOJ;
import java.util.*;

public class P10819차이를최대로 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		
		for(int i=0;i<n;i++){
			a[i] = sc.nextInt();
		}
		
		Arrays.sort(a);
		
		int max = 0;
		
		do{
			max = Math.max(max, cal(a));
		}while(next_permetation(a));
		System.out.println(max);
	}
	
	public static int cal(int[] a){
		int sum = 0;
		for(int i=0;i<a.length-1;i++){
			sum += Math.abs(a[i]-a[i+1]);
		}
		return sum;
	}
	
	public static boolean next_permetation(int[] a){
		int i = a.length-1;
		while(i>0 && a[i-1]>=a[i]){
			i-=1;
		}
		
		if(i==0)
			return false;
		
		int j = a.length-1;
		while(a[i-1]>=a[j]){
			j-=1;
		}
		
		int temp = a[i-1];
		a[i-1] = a[j];
		a[j] = temp;
		
		j = a.length-1;
		while(i<j){
			temp = a[i];
			a[i] = a[j];
			a[j] = temp;
			i+=1;
			j-=1;
		}
		return true;
	}

}
