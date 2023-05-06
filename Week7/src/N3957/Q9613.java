package N3957;

import java.io.*;

public class Q9613 { 

	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		int[] items = new int[100];
		
		String[] temp; long sum = 0;
		while(T-- > 0) { 
			temp = br.readLine().split(" ");
			int n = Integer.parseInt(temp[0]);
			for(int i = 0; i < n; i++) 
				items[i] = Integer.parseInt(temp[i + 1]);
			
			if(n == 1) sum = items[0];
			
			for(int i = 0; i < n; i++) {
				for(int j = i + 1; j < n; j++) {
					sum += gcd(items[i], items[j]);
				}
			}
			
			sb.append(sum).append('\n');
			sum = 0;
		}
		
		System.out.println(sb);
	}
	
	public static int gcd(int A, int B) {
		if(A % B == 0) 
			return B;
		
		return gcd(B, (A % B));
	}

}
