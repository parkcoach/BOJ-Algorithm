package BOJ;
import java.util.*;
import java.io.*;
import java.text.DecimalFormat;

public class P1546 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		ArrayList<Double> score = new ArrayList<Double>();
		String[] s = br.readLine().split(" ");
		for(int i=0;i<n;i++){
			score.add(Double.parseDouble(s[i]));
		}
		
		Collections.sort(score);
		
		ArrayList<Double> real = new ArrayList<Double>();
		
		double max = score.get(n-1);
		for(int i=0;i<n;i++){
			double value = (double)(score.get(i)/max)*100;
			real.add(value);
		}

		double sum=0;
		for(int i=0;i<real.size();i++){
			sum+=real.get(i);
		}
		

		DecimalFormat dformat = new DecimalFormat("#.00");
		double number = (double)(sum/n);
		System.out.println(dformat.format(number));

	}

}