package N3957;

import java.io.*;
import java.util.*;

public class Q17087 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] temp = br.readLine().split(" ");
		int N = Integer.parseInt(temp[0]); 
		int S = Integer.parseInt(temp[1]); 
		
		int gcd = -1; int idx = N;
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		while(idx > 0) {
			int A = Integer.parseInt(st.nextToken());
			A = (S - A < 0) ? (A - S) : (S - A);
			idx--;
			
			if(N == 1) {
				gcd = A;
				break;
			}
			
			if(gcd == -1) {
				int B = Integer.parseInt(st.nextToken());
				B = (S - B < 0) ? (B - S) : (S - B);
				idx--;
				
				gcd = GCD(A, B);
			}
			else 
				gcd = GCD(A, gcd);
		}
		
		System.out.println(gcd);
		
	}
	
	public static int GCD(int A, int B) {
		
		int larger = (A > B) ? A : B; 
		int smaller = (A < B) ? A : B;
		
		if(smaller == 0) //만약 나누는 수가 0이라면
			return larger;
		
		if(larger % smaller == 0) {
			return smaller;
		}

		return GCD(smaller, (larger % smaller));
	}

}