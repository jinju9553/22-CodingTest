package N3958;

import java.io.*;

public class Q11653 {

	private static int max = 10000000;
	private static boolean[] prime;
	private static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		check_prime(max); //O(10,000,000)
		
		int currDiv = 0;
		for(int i = 2; i < max;) { //O(10,000,000) ==> 꼭 max까지 반복하지 않아도 된다
			if(prime[i] == true){ //O(1)
				i++;
				continue;
			}
				
			currDiv = i;
			
			if(N % currDiv != 0) {
				i++;
				continue;
			}
			
			N = N / currDiv;
				
			sb.append(currDiv).append('\n');
			
			if(N == 1) break;
		}
		
		System.out.println(sb); //N이 1인 경우 출력 X
	}

	public static void check_prime(int N) {
		
		prime = new boolean[N + 1];
		
		if(N < 2)
			return;
		
		prime[0] = prime[1] = true; //소수가 아니다
		
		for(int i = 2; i <= Math.sqrt(N); i++) {
			if(prime[i] == true) //소수가 아니라면 다음으로
				continue;
			
			for(int j = i * i; j < N + 1; j = j + i) 
				prime[j] = true; //소수의 모든 배수는 소수가 아님
		}
	}
}
