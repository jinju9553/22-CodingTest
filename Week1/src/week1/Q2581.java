package week1;

import java.util.Scanner;

public class Q2581 {
	
	public static int MIN = 999;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		int sum = 0;
		for(int i = M; i <= N; i++) {
			sum += make_prime(i);
		}
		
		if(sum == 0) {
			System.out.println(-1);
		}
		else {
			System.out.println(sum);
			System.out.println(MIN);
		}
		
		sc.close();
	}
	
	//�Ҽ� ���� �޼ҵ�
	public static int make_prime(int number) {

		//0 �� 1 �� �Ҽ��� �ƴϹǷ� ����
		if (number < 2) {
			return 0;
		}

		//2 �� �Ҽ�
		if (number == 2) {
			//System.out.println(number);
			if(number < MIN) //����! 2�� �ּڰ�
				MIN = number;
			return number;
		}

		//������ �Լ� : Math.sqrt() �̿� ==> O(n^2/3)
		for (int i = 2; i <= Math.sqrt(number); i++) {
			// �Ҽ��� �ƴ� ��� ����
			if (number % i == 0) {
				return 0;
			}
		}
		//�� �ݺ������� ����� ���� ���� �ʴ� ��� �Ҽ�
		//System.out.println(number);
		if(number < MIN)
			MIN = number;
		
		return number;
	}
}
