package N9370;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountPrime {

	public static boolean[] prime;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		System.out.print(count_prime(N));
	}
	
	//에라토스테네스의 체 이용  
	public static int count_prime(int N) {

		prime = new boolean[N + 1];	
		int qty = N - 2; //0과 1을 사전에 제거

		//2 미만은 소수를 판별할 필요 없으므로 바로 return
		if (N < 2) {
			return 0;
		}

		prime[0] = prime[1] = true;
		
		for (int i = 2; i <= Math.sqrt(N); i++) {

			//이미 체크된 수라면 다음 반복으로
			if (prime[i] == true) {
				continue;
			}

			//i의 배수들을 걸러주기 위한 반복문
			for (int j = i * i; j < N; j = j + i) {
				if(prime[j] == false) //새롭게 체크되는 수인지 검사 (중복 제거)
					qty--; //소수가 아니라면 qty -= 1;
				
				prime[j] = true;
			}
		}

		return qty;
	}
}
