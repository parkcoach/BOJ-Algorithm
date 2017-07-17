package BOJ;
import java.util.*;

public class P1929 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		boolean[] check = new boolean[b+1];
		
        check[0] = check[1] = true;
		for(int i=2;i<=b;i++){
			if(check[i]==true)
				continue;
			
			for(int j=i+i;j<=b;j+=i){
				check[j] = true;
			}
		}
		
		for(int i=a;i<=b;i++){
			if(check[i]==false)
				System.out.println(i);
		}
		

	}

}
