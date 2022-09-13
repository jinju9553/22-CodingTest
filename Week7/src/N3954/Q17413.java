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
			if(S.charAt(i) == '<') { //괄호 시작
				while(!stack.isEmpty()) //이전까지 스택에 있던 것들 털어넣기
					sb.append(stack.pop());
				
				sb.append(S.charAt(i++)); //괄호 열기
				while(S.charAt(i) != '>') {
					sb.append(S.charAt(i++));
				}
				sb.append(S.charAt(i++)); //괄호 닫기 
			}
			else if(S.charAt(i) == ' ') {
				while(!stack.isEmpty())
					sb.append(stack.pop());
				sb.append(S.charAt(i++)); //공백문자 채우기
			}
			else //괄호 밖에 있는 것들은 스택으로 
				stack.push(S.charAt(i++));
		}
		
		while(!stack.isEmpty())
			sb.append(stack.pop());
		
		System.out.println(sb);
	}

}
