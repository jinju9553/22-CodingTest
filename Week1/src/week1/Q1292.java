package week1;

import java.util.Scanner;

public class Q1292 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//아이디어: (큰 범위 - 작은 범위)
		int A = sc.nextInt();
		int B = sc.nextInt();
		
		int sum1 = 0;
		int operand = 1;
		int count = 0;
		while (count < B) {
			for(int j = 0; j < operand; j++) {
				sum1 += operand;
				count++; 
				if(count >= B) //여기서 i가 B를 넘기면 break
					break;
			}
			operand++;
		}
		
		int sum2 = 0;
		operand = 1;
		count = 0;
		while ((count + 1) < A) { //A보다 하나 적은 위치에서 더하기를 멈춰야 함
			for(int j = 0; j < operand; j++) {
				sum2 += operand;
				count++; 
				if((count + 1) >= A) //여기서 i가 A를 넘기면 break
					break;
			}
			operand++;
		}
		
		System.out.print(sum1 - sum2);
		
		sc.close();
	}
}
