package week1;

import java.util.Scanner;

public class Q1292 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//���̵��: (ū ���� - ���� ����)
		int A = sc.nextInt();
		int B = sc.nextInt();
		
		int sum1 = 0;
		int operand = 1;
		int count = 0;
		while (count < B) {
			for(int j = 0; j < operand; j++) {
				sum1 += operand;
				count++; 
				if(count >= B) //���⼭ i�� B�� �ѱ�� break
					break;
			}
			operand++;
		}
		
		int sum2 = 0;
		operand = 1;
		count = 0;
		while ((count + 1) < A) { //A���� �ϳ� ���� ��ġ���� ���ϱ⸦ ����� ��
			for(int j = 0; j < operand; j++) {
				sum2 += operand;
				count++; 
				if((count + 1) >= A) //���⼭ i�� A�� �ѱ�� break
					break;
			}
			operand++;
		}
		
		System.out.print(sum1 - sum2);
		
		sc.close();
	}
}
