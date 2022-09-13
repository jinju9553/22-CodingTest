package N9388;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q9251 {

	private static int[][] DP;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String X = br.readLine();
		String Y = br.readLine();
		
		int i = X.length();
		int j = Y.length();
		DP = new int[i + 1][j + 1]; //인덱스 0은 사용하지 않음. 사유: (r - 1), (c - 1)이 0 이하로 떨어지면 안됨
		
		for(int k = 0; k <= i; k++)
			DP[k][0] = 0; //세로 벽 초기화 ==> 사용하지 않는 구역(문자열의 길이가 0일 때)
		
		for(int k = 0; k <= j; k++)
			DP[0][k] = 0; //가로 천장 초기화 ==> 사용하지 않는 구역(문자열의 길이가 0일 때)
		
		for(int r = 1; r <= i; r++) {
			for(int c = 1; c <= j; c++) {
				if(X.charAt(r - 1) == Y.charAt(c - 1))
					DP[r][c] = DP[r - 1][c - 1] + 1; //DP배열 대각선 위의 값에 +1을 더함
				else
					DP[r][c] = Math.max(DP[r][c - 1], DP[r - 1][c]);
			}
		}
		
		System.out.println(DP[i][j]);
	}
}
