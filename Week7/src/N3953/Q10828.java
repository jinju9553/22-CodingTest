package N3953;

import java.io.*;
import java.util.*;

public class Q10828 {

	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int T = Integer.parseInt(br.readLine());

		Stack<Integer> stack = new Stack<>();
		
		while(T-- > 0) {
			String line = br.readLine();
			String command = line.split(" ")[0];
			
			switch(command) {
				case "push": {
					int num = Integer.parseInt(line.split(" ")[1]);
					stack.push(num);
					stack.add(num);
					break;
				}
				case "pop": {
					if(!stack.isEmpty())
						sb.append(stack.pop()).append('\n');
					else
						sb.append(-1).append('\n');
					
					break;
				}
				case "size": {
					sb.append(stack.size()).append('\n');
					break;
				}
				case "empty": {
					sb.append(stack.isEmpty() ? '1' : '0').append('\n');
					break;
				}
				case "top": {
					if(!stack.isEmpty())
						sb.append(stack.peek()).append('\n');
					else
						sb.append(-1).append('\n');
					
					break;
				}
			}
			
		}

		System.out.println(sb);
	}

}
