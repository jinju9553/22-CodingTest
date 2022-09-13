package N3954;

import java.io.*;
import java.util.*;

public class Q17413 {
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String S = br.readLine();
		
		Stack<Character> stack = new Stack<>();

		for(int i = 0; i < S.length();) {
			if(S.charAt(i) == '<') { //��ȣ ����
				while(!stack.isEmpty()) //�������� ���ÿ� �ִ� �͵� �о�ֱ�
					sb.append(stack.pop());
				
				sb.append(S.charAt(i++)); //��ȣ ����
				while(S.charAt(i) != '>') {
					sb.append(S.charAt(i++));
				}
				sb.append(S.charAt(i++)); //��ȣ �ݱ� 
			}
			else if(S.charAt(i) == ' ') {
				while(!stack.isEmpty())
					sb.append(stack.pop());
				sb.append(S.charAt(i++)); //���鹮�� ä���
			}
			else //��ȣ �ۿ� �ִ� �͵��� �������� 
				stack.push(S.charAt(i++));
		}
		
		while(!stack.isEmpty())
			sb.append(stack.pop());
		
		System.out.println(sb);
	}

}
