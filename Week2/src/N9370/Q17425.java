package N9370;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q17425 { //답은 맞는데 9%에서 시간초과

	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			long N = Long.parseLong(br.readLine()); //또는 br.read();
			long sum = 0; // 타입에 주의!: 입력이 1,000,000까지 들어올 수 있음.
			for (int i = 1; i <= N; i++) {
				sum += i * (N / i); // 약수가 i인 수는 항상 (N / i)개 존재한다. (나머지 버림)
			}
			sb.append(sum);
			sb.append('\n');
		}
		System.out.println(sb);
	}
}