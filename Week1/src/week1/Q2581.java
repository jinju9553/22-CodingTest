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
	
	//소수 생성 메소드
	public static int make_prime(int number) {

		//0 과 1 은 소수가 아니므로 종료
		if (number < 2) {
			return 0;
		}

		//2 는 소수
		if (number == 2) {
			//System.out.println(number);
			if(number < MIN) //주의! 2도 최솟값
				MIN = number;
			return number;
		}

		//제곱근 함수 : Math.sqrt() 이용 ==> O(n^2/3)
		for (int i = 2; i <= Math.sqrt(number); i++) {
			// 소수가 아닐 경우 종료
			if (number % i == 0) {
				return 0;
			}
		}
		//위 반복문에서 약수를 갖고 있지 않는 경우 소수
		//System.out.println(number);
		if(number < MIN)
			MIN = number;
		
		return number;
	}
}
