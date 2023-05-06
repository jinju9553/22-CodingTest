package N9370;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q6588 { //에라토스테네스 체(지금 코드)는 33%에서 시간초과

	public static boolean[] isPrime;
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int sum; int flag;
		while((sum = Integer.parseInt(br.readLine())) != 0) { //O(n)
			check_prime(sum); //O(nlog(logn)) 
			//모든 입력(1,000,000)에 대해 배열을 미리 생성해보기
			flag = 0;
			for(int a = 3; a < sum; a = a + 2) { 
				if(isPrime[a] == true) //O(1)
					continue;
				
				int b = sum - a;
				
				if(isPrime[b] == true) //O(1)
					continue;
				else {
					sb.append(sum);
					sb.append(" = ");
					sb.append(a);
					sb.append(" + ");
					sb.append(b);
					sb.append('\n');
					flag = 1;
					break;
				}
			}
			if(flag == 0) System.out.println("Goldbach's conjecture is wrong.");
		};
		System.out.println(sb);
	}
	
	public static void check_prime(int N) {

		isPrime = new boolean[N + 1];

		if (N < 2) {
			return;
		}

		isPrime[0] = isPrime[1] = true;

		for (int i = 2; i <= Math.sqrt(N); i++) {

			if (isPrime[i] == true) {
				continue;
			}

			for (int j = i * i; j < N + 1; j = j + i) {
				isPrime[j] = true;
			}
		}
	}
}