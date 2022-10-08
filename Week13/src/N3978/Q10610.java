package N3978;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.IOException;

public class Q10610 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String target = br.readLine(); //String은 Iterable이 아니다.
		char[] numbers = target.toCharArray();

		int sum = 0;
		for(int i = 0; i < target.length(); i++) {
			int n = numbers[i] - '0';
			sum += n;
		}
		
		StringBuilder sb = new StringBuilder();
		Arrays.sort(numbers);
		for(int i = target.length() - 1; i >= 0; i--)
			sb.append(numbers[i]);
		
		if(sum % 3 == 0 && numbers[0] == '0') {
			System.out.println(sb.toString());
		}
		else
			System.out.println(-1);
	
	}
}
