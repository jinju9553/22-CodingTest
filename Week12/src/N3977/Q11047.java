package N3977;

import java.io.*;

public class Q11047 {

	public static int count = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		int N = Integer.parseInt(temp[0]);
		int target = Integer.parseInt(temp[1]);
		
		int[] coins = new int[N];
		for(int i = 0; i < N; i++)
			coins[i] = Integer.parseInt(br.readLine());
		
		int sum = 0;
		for(int i = N - 1; i >= 0; i--) {
			if(sum > target)
				break;
			
			while(true) {
				if(sum + coins[i] > target)
					break;
				else {
					sum += coins[i];
					count++;
				}
			}
		}
		
		System.out.println(count);
	}

}
