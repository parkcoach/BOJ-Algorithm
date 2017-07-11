package BOJ;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] value = new String[3];
		long ans = 0;
		
		for(int i=0;i<3;i++){
			value[i] = br.readLine();
		}

		for(int i=0;i<3;i++){
			if(value[i].equalsIgnoreCase("black")){
				continue; 
			}
			else if(value[i].equalsIgnoreCase("brown")){
				if(i==0) ans = 10;
				else if(i==1) ans += 1;
				else ans = ans * 10;
			}
			else if(value[i].equalsIgnoreCase("red")){
				if(i==0) ans = 20;
				else if(i==1) ans += 2;
				else ans = ans * 100;
			}
			else if(value[i].equalsIgnoreCase("orange")){
				if(i==0) ans = 30;
				else if(i==1) ans += 3;
				else ans = ans * 1000;
			}
			else if(value[i].equalsIgnoreCase("yellow")){
				if(i==0) ans = 40;
				else if(i==1) ans += 4;
				else ans = ans * 10000;
			}
			else if(value[i].equalsIgnoreCase("green")){
				if(i==0) ans = 50;
				else if(i==1) ans += 5;
				else ans = ans * 100000;
			}
			else if(value[i].equalsIgnoreCase("blue")){
				if(i==0) ans = 60;
				else if(i==1) ans += 6;
				else ans = ans * 1000000;
			}
			else if(value[i].equalsIgnoreCase("violet")){
				if(i==0) ans = 70;
				else if(i==1) ans += 7;
				else ans = ans * 10000000;
			}
			else if(value[i].equalsIgnoreCase("grey")){
				if(i==0) ans = 80;
				else if(i==1) ans += 8;
				else ans = ans * 100000000;
			}
			else if(value[i].equalsIgnoreCase("white")){
				if(i==0) ans = 90;
				else if(i==1) ans += 9;
				else ans = ans * 1000000000;
			}
		}
		System.out.println(ans);
	}
}