package N9370;

import java.util.Scanner;

public class Q1037_2 {

	public static void main(String[] args) {
		//주의: Scanner보다 BufferedReader가 더 빠르다
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		//특징: 모든 약수가 주어졌을 때, p * q에서 어느 한 인수 p가 가장 작은 수라면 q는 가장 큰 수이다.
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		for(int i = 0; i < T; i++) {
			int nextNum = sc.nextInt();
			if(nextNum > max) max = nextNum;
			if(nextNum < min) min = nextNum;
		}
		
		System.out.print(max * min);
		
		sc.close();
	}

}
