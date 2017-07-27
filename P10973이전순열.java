package BOJ;
import java.util.*;

public class P10973이전순열 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		
		for(int i=0;i<n;i++){
			a[i] = sc.nextInt();
		}
		
		if(before_permutation(a)){
			for(int i=0;i<n;i++){
				System.out.print(a[i]+" ");
			}
		}
		else{
			System.out.println(-1);
		}

	}
	
	public static boolean before_permutation(int[] a){
		int i = a.length-1;
		while(i>0 && a[i-1]<=a[i]){
			i-=1;
		}
		
		if(i==0) //처음 순열일 때
			return false;
		
		int j = a.length-1;
		while(a[i-1]<=a[j]){
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
