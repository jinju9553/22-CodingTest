package N9378;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Q10866 {

	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());

		Deque<Integer> d = new LinkedList<>();
		
		String line; String command; int num = -999;
		while(T-- > 0) {
			line = br.readLine();
			command = line.split(" ")[0];
			switch(command) {
				case "push_front": {
					num = Integer.parseInt(line.split(" ")[1]);
					d.addFirst(num);

					break;
				}
				case "push_back": {
					num = Integer.parseInt(line.split(" ")[1]);
					d.addLast(num);

					break;
				}
				case "pop_front": {
					Integer p = d.pollFirst();
					p = (p != null) ? p : -1;
					sb.append(p).append('\n');
					
					break;
				}
				case "pop_back": {
					Integer p = d.pollLast();
					p = (p != null) ? p : -1;
					sb.append(p).append('\n');

					break;
				}
				case "size": {
					sb.append(d.size()).append('\n');
					break;
				}
				case "empty": {
					if(d.isEmpty())
						sb.append(1).append('\n');
					else
						sb.append(0).append('\n');
					
					break;
				}
				case "front": {
					Integer p = d.peekFirst(); //또는 getFirst()
					p = (p != null) ? p : -1;
					sb.append(p).append('\n');
					
					break;
				}
				case "back": {
					Integer p = d.peekLast(); //또는 getLast()
					p = (p != null) ? p : -1;
					sb.append(p).append('\n');

					break;
				}
			}
		}
		System.out.println(sb);
	}
}