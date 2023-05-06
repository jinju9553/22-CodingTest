package N9370;

import java.io.IOException;
//import java.io.InputStreamReader;
import java.util.Scanner;

public class Q17427_2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		
		long N = sc.nextLong();
		
		long sum = 0; //타입에 주의!: 입력이 1,000,000까지 들어올 수 있음.
		for(int i = 1; i <= N; i++) {
			sum += i * (N / i); // 약수가 i인 수는 항상 (N / i)개 존재한다. (나머지 버림)
		}
		
		System.out.print(sum);	
		
		sc.close();
	}
}