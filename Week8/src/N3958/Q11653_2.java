package N3958;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q11653_2 {

	private static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 2; i <= Math.sqrt(N); i++) { //인수 두 개중 하나는 반드시 sqrt(N)보다 작거나 같다.
			while(N % i == 0) { //i로 나눠지기만 한다면 i의 배수로 나눠지는 경우는 고려할 필요 없다!
				sb.append(i).append('\n');
				N = N / i;
			}
		}
		
		if(N != 1)
			sb.append(N);
		
		System.out.println(sb);
	}

}
