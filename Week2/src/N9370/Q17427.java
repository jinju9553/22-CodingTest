package N9370;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q17427 { //���� ������ �ð��ʰ� 

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); //�Ǵ� br.read();
		
		int sum = 0;
		while(N > 0) { 
			for(int i = 1; i <= Math.sqrt(N); i++) {
				if(N % i == 0) { //������ �������ٸ�
					sum += i;
					//n �� ����� �� ��n ������ i�� ���ϸ�, ������ ����鵵 n�� i�� ���� ���� �� �ִ�.
					if(N / i != i) sum += N / i; //���� N�� i�� ��������� �ߺ��� ����Ƿ� �ɷ��� ��.
				}
			}
			N--;
		}
		
		System.out.print(sum);
	}
}
