package BOJ;
import java.io.*;

public class P1541 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int[] value = new int[line.length()];
		int[] minus = new int[line.length()];
		int index = 0;

		int temp = 0;
		for(int i=0;i<line.length();i++){
			if(line.charAt(i)=='-' || line.charAt(i)=='+'){
				temp = 0;
				index++;
				if(line.charAt(i)=='-'){
					minus[index] = -1;
				}
			}
			else{
				temp = temp*10 + line.charAt(i)-'0';
				value[index] = temp;
			}
		}

		int ans = 0;
		boolean state = false;
		for(int i=0;i<=index;i++){
			if(minus[i]==-1)
				state = true;
			if(state)
				ans -= value[i];
			else
				ans += value[i];
		}

		System.out.println(ans);
	}

}