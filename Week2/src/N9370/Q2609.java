package N9370;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2609 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer s = new StringTokenizer(br.readLine(), " ");
		
		int A = Integer.parseInt(s.nextToken());
		int B = Integer.parseInt(s.nextToken());
		
		int gcd = getGCD(A, B);
		System.out.println(gcd);
		System.out.print(A * B / gcd);
	}
	
	public static int getGCD(int A, int B) { //O(logN)
		if(A % B == 0)
			return B;
		else
			return getGCD(B, (A % B)); //B와 나머지 R을 가지고 다시 반복
	}
}
