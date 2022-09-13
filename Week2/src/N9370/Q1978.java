package N9370;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1978 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer s = new StringTokenizer(br.readLine(), " ");
		
		int count = 0;
		
		while(T-- > 0) { //제한 시간이 2초라서 O(T√n) 으로도 풀 수 있음.
			int num = Integer.parseInt(s.nextToken());
			count += is_prime(num);
		}
		
		System.out.print(count);
	}
	 
	public static int is_prime(int num) {
		if (num < 2) {
			return 0;
		}
		
		if(num == 2)
			return 1;

		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				return 0;
			}
		}
		
		return 1;
	}
}
