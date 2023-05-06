package N9370;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q6588 { //�����佺�׳׽� ü(���� �ڵ�)�� 33%���� �ð��ʰ�

	public static boolean[] isPrime;
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int sum; int flag;
		while((sum = Integer.parseInt(br.readLine())) != 0) { //O(n)
			check_prime(sum); //O(nlog(logn)) 
			//��� �Է�(1,000,000)�� ���� �迭�� �̸� �����غ���
			flag = 0;
			for(int a = 3; a < sum; a = a + 2) { 
				if(isPrime[a] == true) //O(1)
					continue;
				
				int b = sum - a;
				
				if(isPrime[b] == true) //O(1)
					continue;
				else {
					sb.append(sum);
					sb.append(" = ");
					sb.append(a);
					sb.append(" + ");
					sb.append(b);
					sb.append('\n');
					flag = 1;
					break;
				}
			}
			if(flag == 0) System.out.println("Goldbach's conjecture is wrong.");
		};
		System.out.println(sb);
	}
	
	public static void check_prime(int N) {

		isPrime = new boolean[N + 1];

		if (N < 2) {
			return;
		}

		isPrime[0] = isPrime[1] = true;

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