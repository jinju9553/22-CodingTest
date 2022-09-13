package N9370;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q17427 { //답은 맞지만 시간초과 

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); //또는 br.read();
		
		int sum = 0;
		while(N > 0) { 
			for(int i = 1; i <= Math.sqrt(N); i++) {
				if(N % i == 0) { //나누어 떨어진다면
					sum += i;
					//n 의 약수들 중 √n 이하인 i만 구하면, 나머지 약수들도 n을 i로 나눠 구할 수 있다.
					if(N / i != i) sum += N / i; //만약 N이 i의 제곱수라면 중복이 생기므로 걸러야 함.
				}
			}
			N--;
		}
		
		System.out.print(sum);
	}
}
