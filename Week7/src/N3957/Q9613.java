package N3957;

import java.io.*;

public class Q9613 { //66% 틀렸습니다 ==> 테스트 케이스가 1일 때를 못함 & 합을 long 타입으로 

	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		int[] items = new int[100];
		
		String[] temp; long sum = 0;
		while(T-- > 0) { //최대 100회 (총 10^4회)
			temp = br.readLine().split(" ");
			int n = Integer.parseInt(temp[0]);
			for(int i = 0; i < n; i++) //최대 100회
				items[i] = Integer.parseInt(temp[i + 1]); //수의 크기는 최대 1,000,000
			
			if(n == 1) sum = items[0];
			
			for(int i = 0; i < n; i++) { //최대 100회 (총 10^4회)
				for(int j = i + 1; j < n; j++) { //최대 100회
					sum += gcd(items[i], items[j]); //얘 시간을 모르겠음
				}
			}
			
			sb.append(sum).append('\n');
			sum = 0;
		}
		
		System.out.println(sb);
	}
	
	public static int gcd(int A, int B) {
		if(A % B == 0) 
			return B;
		
		return gcd(B, (A % B));
	}

}
