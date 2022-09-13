package N3958;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q11653_2 {

	private static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 2; i <= Math.sqrt(N); i++) { //�μ� �� ���� �ϳ��� �ݵ�� sqrt(N)���� �۰ų� ����.
			while(N % i == 0) { //i�� �������⸸ �Ѵٸ� i�� ����� �������� ���� ����� �ʿ� ����!
				sb.append(i).append('\n');
				N = N / i;
			}
		}
		
		if(N != 1)
			sb.append(N);
		
		System.out.println(sb);
	}

}
