package N9378;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Q10845 {

	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Queue<Integer> queue = new LinkedList<>();
		
		int T = Integer.parseInt(br.readLine());
		String line; String command; int num = -999;
		while(T-- > 0) {
			line = br.readLine();
			command = line.split(" ")[0];
			switch(command) {
				case "push": {
					num = Integer.parseInt(line.split(" ")[1]);
					queue.add(num);
					
					break;
				}
				case "pop": {
					Integer p = queue.poll(); //ť�� ����ִٸ� null ��ȯ
					//����: int�� null�� ���� �� �����Ƿ� Integer�� ���
					
					if(p != null) sb.append(p).append('\n'); 
					else sb.append(-1).append('\n');
					
					break;
				}
				case "size": {
					sb.append(queue.size()).append('\n');
					break;
				}
				case "empty": {
					if(queue.isEmpty())
						sb.append(1).append('\n');
					else
						sb.append(0).append('\n');
					break;
				}
				case "front": {
					Integer f = queue.peek(); //ť�� ����ִٸ� null ��ȯ
					
					if(f != null) sb.append(f).append('\n'); 
					else sb.append(-1).append('\n');
					
					break;
				}
				case "back": {
					//*����: ���� �ֱٿ� push�� ���� �� back�� �ȴ�.
					if(queue.isEmpty())
						sb.append(-1).append('\n');
					else
						sb.append(num).append('\n');
					
					break;
				}
			}
		}
		System.out.println(sb);
	}
}
