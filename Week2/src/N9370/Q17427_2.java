package N9370;

import java.io.IOException;
//import java.io.InputStreamReader;
import java.util.Scanner;

public class Q17427_2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		
		long N = sc.nextLong();
		
		long sum = 0; //Ÿ�Կ� ����!: �Է��� 1,000,000���� ���� �� ����.
		for(int i = 1; i <= N; i++) {
			sum += i * (N / i); // ����� i�� ���� �׻� (N / i)�� �����Ѵ�. (������ ����)
		}
		
		System.out.print(sum);	
		
		sc.close();
	}
}