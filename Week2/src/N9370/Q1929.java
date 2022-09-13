package N9370;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1929 {

	public static boolean[] isPrime;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer s = new StringTokenizer(br.readLine(), " ");
		
		int M = Integer.parseInt(s.nextToken());
		int N = Integer.parseInt(s.nextToken());
		
		check_prime(N); //소수배열을 만들 때 M은 크게 필요 없음
		
		//주의: M과 N이 같을 때에도 출력시켜야 함
		for(int i = M; i < N + 1; i++) {
			if(isPrime[i] == false)
				System.out.println(i);
		}
	}

	//에라토스테네스의 체 이용
	public static void check_prime(int N) {

		isPrime = new boolean[N + 1]; //주의: 배열 인덱스와 해당 소수가 일치해야 하므로 크기는 N으로 잡음

		//N이 2 미만이라면 소수를 판별할 필요 없으므로 바로 종료
		if (N < 2) {
			return;
		}

		isPrime[0] = isPrime[1] = true;

		//주의: i = 2부터 시작하지 않으면 모든 2의 배수를 지울 수 없음 (거름망 X)
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
