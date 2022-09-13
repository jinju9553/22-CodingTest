package N9384;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2003 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		
		String[] splited = br.readLine().split(" ");
		int N = Integer.parseInt( splited[0] );
		int M = Integer.parseInt( splited[1] );
		
		StringTokenizer st = new StringTokenizer( br.readLine(), " " );
		int[] arr = new int[N];
		
		for(int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		int i = 0; int j = 0; int count = 0; int sum = 0;
		while(i < N) {
			sum += arr[j];
			if(sum == M) {
				count++;
				sum = 0;
				i++; j = i;
			}
			else if(sum > M || j >= N - 1) {
				sum = 0;
				i++; j = i;
			}
			else { //sum < M
				j++;
			}
		}
		
		System.out.println(count);
	}
}
