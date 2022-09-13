package N3956;

import java.io.*;

public class Q6588 {
	
	public static boolean[] isPrime;
	public static StringBuilder sb = new StringBuilder();
	public static int N = 1000000;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		check_prime(N); //��� ������ �Է¿� ���� �̸� �迭 ���� //O(Nlog(log N))
		
		int target = Integer.parseInt(br.readLine());
		while(target != 0) { //O(T)
			int flag = -1;
			
			for(int a = 3; a < target; a = a + 2) { //a�� ������ Ȧ��
				if(!isPrime[a]) { //a�� �Ҽ���� (O(1))
					int b = target - a;
					if(b % 2 != 0 && !isPrime[b]) { //b�� Ȧ���̰� �Ҽ���� (O(1))
						sb.append(target).append(" = ").append(a).append(" + ").append(b);
						sb.append('\n');
						flag = 1;
						break;
					}
				}
			}
			
			if(flag == -1) sb.append("Goldbach's conjecture is wrong.");
			
			target = Integer.parseInt(br.readLine());
		}
		
		System.out.println(sb);
	}

	public static void check_prime(int N) {

		/* �Ҽ��� �ƴ� index = true ; �Ҽ��� index = false */
		isPrime = new boolean[N + 1];

		if (N < 2)
			return;

		isPrime[0] = isPrime[1] = true;

		for (int i = 2; i <= Math.sqrt(N); i++) {

			if (isPrime[i] == true)
				continue;

			for (int j = i * i; j < N + 1; j = j + i)
				isPrime[j] = true;
		}
	}
}
