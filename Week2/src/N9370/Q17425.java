package N9370;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q17425 { //���� �´µ� 9%���� �ð��ʰ�

	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			long N = Long.parseLong(br.readLine()); //�Ǵ� br.read();
			long sum = 0; // Ÿ�Կ� ����!: �Է��� 1,000,000���� ���� �� ����.
			for (int i = 1; i <= N; i++) {
				sum += i * (N / i); // ����� i�� ���� �׻� (N / i)�� �����Ѵ�. (������ ����)
			}
			sb.append(sum);
			sb.append('\n');
		}
		System.out.println(sb);
	}
}