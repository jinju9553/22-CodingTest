package N9382;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14888_2 {

	public static char [] items; 
	public static char [] bucket;
	public static int [] operand; 
	public static int [] numOfOperator;
	public static int max = Integer.MIN_VALUE;
	public static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in) ); 
		
		int N = Integer.parseInt(br.readLine());
		
		items = new char[] {'+', '-', '*', '/'};
		bucket = new char[N - 1]; //연산자가 들어갈 공간만큼 할당
		operand = new int[N]; //피연산자 리스트 
		numOfOperator = new int[4]; //연산자의 수
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++)
			operand[i] = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < 4; i++)
			numOfOperator[i] = Integer.parseInt(st.nextToken());

		pick(4, N - 1, 0);
		
		System.out.println(max);
		System.out.println(min);
	}

	public static void pick(int N, int M, int k) {

		if(k == M) {
			int rslt = operand[0];
			for(int i = 0; i < bucket.length; i++) {
				if(bucket[i] == '+')
					rslt += operand[i + 1];
				else if(bucket[i] == '-')
					rslt -= operand[i + 1];
				else if(bucket[i] == '*')
					rslt *= operand[i + 1];
				else if(bucket[i] == '/')
					rslt /= operand[i + 1];
			}
			max = (rslt > max) ? rslt : max;
			min = (rslt < min) ? rslt : min;
			
			return;
		}

		for(int i = 0; i < N; i++) { //N은 item의 수: M보다 작아도 됨
			if(numOfOperator[i] <= 0)
				continue;
			
			numOfOperator[i] -= 1;
			bucket[k] = items[i];
			pick(N, M, k + 1);
			
			numOfOperator[i] += 1; //다시 참조하는 값을 원복
		}
	}
}