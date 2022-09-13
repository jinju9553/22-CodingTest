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
	
	//�����佺�׳׽��� ü �̿�  
	public static int count_prime(int N) {

		prime = new boolean[N + 1];	
		int qty = N - 2; //0�� 1�� ������ ����

		//2 �̸��� �Ҽ��� �Ǻ��� �ʿ� �����Ƿ� �ٷ� return
		if (N < 2) {
			return 0;
		}

		prime[0] = prime[1] = true;
		
		for (int i = 2; i <= Math.sqrt(N); i++) {

			//�̹� üũ�� ����� ���� �ݺ�����
			if (prime[i] == true) {
				continue;
			}

			//i�� ������� �ɷ��ֱ� ���� �ݺ���
			for (int j = i * i; j < N; j = j + i) {
				if(prime[j] == false) //���Ӱ� üũ�Ǵ� ������ �˻� (�ߺ� ����)
					qty--; //�Ҽ��� �ƴ϶�� qty -= 1;
				
				prime[j] = true;
			}
		}

		return qty;
	}
}
