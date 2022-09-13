package N3954;

import java.io.*;
import java.util.*;

public class Q17298 {

	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
		
		int T = Integer.parseInt(br.readLine());
		int[] NGE = new int[T];
		Stack<Integer> stack = new Stack<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i < T; i++) {
			stack.add(Integer.parseInt(st.nextToken()));
			NGE[i] = -1;
		}
		
		int currMax = Integer.MIN_VALUE; int prev = -1;
		for(int i = T - 1; i >= 0; i--) {
			int curr = stack.pop();
			currMax = (curr > currMax) ? curr : currMax;
			
			if(prev != -1) {
				if(curr < currMax)
					NGE[i] = currMax;
				
				//만약 스택이 여러개 필요하다면??
				if(curr < prev) //이 prev가 생각보다 길게 살아있어야 한다면??
					NGE[i] = prev;
			}
			prev = curr;
		}
		
		for(int i = 0; i < T; i++)
			sb.append(NGE[i]).append(" ");
		
		System.out.println(sb);
	}

}
