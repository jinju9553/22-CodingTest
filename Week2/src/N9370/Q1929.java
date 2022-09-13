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
		
		check_prime(N); //�Ҽ��迭�� ���� �� M�� ũ�� �ʿ� ����
		
		//����: M�� N�� ���� ������ ��½��Ѿ� ��
		for(int i = M; i < N + 1; i++) {
			if(isPrime[i] == false)
				System.out.println(i);
		}
	}

	//�����佺�׳׽��� ü �̿�
	public static void check_prime(int N) {

		isPrime = new boolean[N + 1]; //����: �迭 �ε����� �ش� �Ҽ��� ��ġ�ؾ� �ϹǷ� ũ��� N���� ����

		//N�� 2 �̸��̶�� �Ҽ��� �Ǻ��� �ʿ� �����Ƿ� �ٷ� ����
		if (N < 2) {
			return;
		}

		isPrime[0] = isPrime[1] = true;

		//����: i = 2���� �������� ������ ��� 2�� ����� ���� �� ���� (�Ÿ��� X)
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
