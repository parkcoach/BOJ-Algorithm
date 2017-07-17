package BOJ;
import java.util.*;

public class P1991{
	public static void preorder(int[][] tree,int x){
		if(x==-1)
			return;
		System.out.print((char)(x+'A'));
		preorder(tree,tree[x][0]);
		preorder(tree,tree[x][1]);
	}
	
	public static void inorder(int[][] tree,int x){
		if(x==-1)
			return;
		inorder(tree,tree[x][0]);
		System.out.print((char)(x+'A'));
		inorder(tree,tree[x][1]);
	}
	
	public static void postorder(int[][] tree,int x){
		if(x==-1)
			return;
		postorder(tree,tree[x][0]);
		postorder(tree,tree[x][1]);
		System.out.print((char)(x+'A'));
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] tree = new int[27][2];
		
		sc.nextLine();
		for(int i=0;i<n;i++){
			String line = sc.nextLine();
			int x = line.charAt(0)-'A';
			char y = line.charAt(2);
			char z = line.charAt(4);
			
			if(y=='.')
				tree[x][0] = -1;
			else
				tree[x][0] = y-'A';
			
			if(z=='.')
				tree[x][1] = -1;
			else
				tree[x][1] = z-'A';
		}
		
		preorder(tree,0);
		System.out.println();
		inorder(tree,0);
		System.out.println();
		postorder(tree,0);
	}

}
