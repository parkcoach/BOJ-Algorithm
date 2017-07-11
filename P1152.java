package BOJ;
import java.util.*;
import java.io.*;

public class P1152 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] num = br.readLine().trim().split(" ");

		boolean state = true;
		for(int i=0;i<num.length;i++){
			if(num[i].equals(""))
				state = false;
		}


		if(state == true)
			System.out.println(num.length);
		else
			System.out.println(0);
	}
}
