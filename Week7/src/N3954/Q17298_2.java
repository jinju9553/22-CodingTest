package N3954;

import java.io.*;
import java.util.*;

public class Q17298_2 { //980ms = 0.98�� (�ΰ���?) (�ٵ� �̰� ���� ���� ����)

	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
		
		int T = Integer.parseInt(br.readLine());
		int[] NGE = new int[T];
		int[] arr = new int[T];
		Stack<Integer> stack = new Stack<>(); //candidate of max
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i < T; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			NGE[i] = -1;
		}
		
		int prev = -1;
		for(int i = T - 1; i >= 0; i--) {
			int curr = arr[i]; //�� �ں��� Ž��
			
			if(prev != -1) {
				if (curr < prev)
					stack.add(prev); // max �ĺ��� �־��
	
				while(NGE[i] == -1 && !stack.isEmpty()) {
					if (curr < stack.peek())
						NGE[i] = stack.peek();
					else
						stack.pop();
				}
			}
			
			prev = curr;
		}
		
		for(int i = 0; i < T; i++)
			sb.append(NGE[i]).append(" ");
		
		System.out.println(sb);
	}

}
