package N3986;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Q16953 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		double A = Double.parseDouble(temp[0]);
		double B = Double.parseDouble(temp[1]);
		
		int flag = -1; int count = 0;
		while(A <= B) { //O(n)
			if(A == B)
				flag = count + 1;
			if((B - 1) % 10 == 0)
				B = (B - 1) / 10;
			else
				B = B / 2.0;
			count++;
		}
		
		System.out.println(flag);
	}

}
