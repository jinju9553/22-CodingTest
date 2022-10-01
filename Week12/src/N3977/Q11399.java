package N3977;

import java.io.*;
import java.util.*;

public class Q11399 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] times = new int[N];
		int[] accumSum = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int prevSum = 0;
		for(int i = 0; i < N; i++) 
			times[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(times);
		
		for(int i = 0; i < N; i++) {
			accumSum[i] = prevSum + times[i];
			prevSum = accumSum[i];
		}
		
		int rslt = 0;
		for(int s : accumSum)
			rslt += s;
		
		System.out.print(rslt);
	}
}