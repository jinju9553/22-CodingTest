package N9370;

import java.util.Scanner;

public class Q4375 { //시간초과, 9901에서 오버플로우 
	//@: 큰 수를 만들지 않으면서 답을 내는 방법을 생각해 보세요. (헐...)
	//@: 1로 구성된 수가 맞는지 판별하는 게 아니라, 1로 만들어진 수가 operand로 나눠지는 지를 판별

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int operand; int flag = 0; 
		while(sc.hasNext()) { //입력받은 모든 값을 처리하기 위함
			operand = sc.nextInt();
			int multiplier = 1;
			while(flag == 0) { //입력받은 한 값의 배수를 찾는다
				if(multiplier % 2 == 0 || multiplier % 5 == 0) {
					multiplier++;
					continue;
				}
				
				int rslt = isAllOne(operand * multiplier);			
				if(rslt == -1) {
					multiplier++;
					continue;
				}
				else {
					//System.out.println(operand * multiplier);
					System.out.println(rslt);
					break;
				}
			}
		}
		
		sc.close();
	}
	
	public static int isAllOne(int num) {
		
		int rslt = 0;
		
		while(true) {			
			if(num == 1) {
				rslt++;
				return rslt;
			}
			else if (num % 10 == 1) {
				num = num / 10;
				rslt++;
				continue;
			}
			else
				return -1;
		}
	}
}
