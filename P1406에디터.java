package BOJ;
import java.util.*;
import java.io.*;

public class P1406¿¡µðÅÍ {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();

		Stack<Character> left = new Stack<Character>();
		Stack<Character> right = new Stack<Character>();

		for(int i=0;i<s.length();i++){
			left.push(s.charAt(i));
		}

		int num = Integer.parseInt(br.readLine());

		while(num-- > 0){
			String[] Line = br.readLine().split(" ");
			char command = Line[0].charAt(0);

			if(command=='P'){
				char value = Line[1].charAt(0);
				left.push(value);
			}
			else if(command=='L'){
				if(!left.isEmpty()){
					char value = left.pop();
					right.push(value);
				}
			}
			else if(command=='D'){
				if(!right.isEmpty()){
					char value = right.pop();
					left.push(value);
				}
			}
			else if(command=='B'){
				if(!left.isEmpty()){
					left.pop();
				}
			}
			else
				continue;
		}
		
		while(!left.isEmpty()){
			right.push(left.pop());
		}
		
		StringBuilder sb = new StringBuilder();
		while(!right.isEmpty()){
			sb.append(right.pop());
		}
		
		System.out.println(sb);
	}

}