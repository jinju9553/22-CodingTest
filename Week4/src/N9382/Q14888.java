package N9382;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14888 {

	public static int [] operand; 
	public static int [] operator;
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in) ); 
		
		int N = Integer.parseInt(br.readLine());
		
		char[] items = {'+', '-', '*', '/'};
		char[] bucket = new char[N - 1];
		operand = new int[N];
		operator = new int[4];
		int[] operatorCount = new int[4];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			operand[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < 4; i++) { // (+ , - , * , /) 순서
			operator[i] = Integer.parseInt(st.nextToken());
			operatorCount[i] = operator[i];
		}
		
		pick(items, bucket, operatorCount, N - 1);
		
		System.out.println(sb);
	}

	public static void pick(char[] items, char[] bucket, int[] operatorCount, int k) {
		if(k == 0) {
			//테스트용 코드
			for(int i = 0; i < bucket.length; i++)
				sb.append(bucket[i]).append(" ");
			sb.append('\n');
			
			//여기서 operator 사본 배열 초기화 
			//근데 java.lang.OutOfMemoryError: Java heap space (왜...)
			for(int i = 0; i < operator.length; i++)
				operatorCount[i] = operator[i];
			
			return;
		}
		
		int lastIndex = bucket.length - k - 1;
		
		for (int i = 0; i < items.length;) { //item이 바뀌었을 때 이전의 operator는 복귀되어야 함
			if(operatorCount[i] <= 0) { //이 items을 더 뽑을 수 없을 때
				i++; //다음 아이템을 확인
				continue;
			}
					
			operatorCount[i] -= 1;
			bucket[lastIndex + 1] = items[i]; 
			pick(items, bucket, operatorCount, k - 1); 
			//버킷에 모두 뽑은 다음에도 i가 items.length보다 작아서 for문을 종료시키지 못함(무한루프)
			
			if(bucket.length == operand.length - 1)
				break; //탐색중인 아이템과 별개로 버킷이 다 찼다면 for문 종료
			//이러면 첫 문자로 *을 뽑을 수 없음 (i가 2부터 시작하는 재귀가 있어야 하는데 그게 막힘...)
		}
		
	}
}
