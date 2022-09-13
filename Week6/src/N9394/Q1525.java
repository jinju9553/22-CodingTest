package N9394;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1525 {

	private static StringBuilder sb = new StringBuilder(); 
	private static String answer = "123456780"; //�� ��Ʈ���� ������ ���� ����
	
	//��Ʈ��(��ǻ� ��Ʈ����)�� ���¿� ���� �̵�Ƚ���� �ٸ��� �����Ѵ�. 
	private static Map<String, Integer> map = new HashMap<>();
	
	private static int[] dx = {-1, 1, 0, 0}; //����, ������, ��, �Ʒ� (�밢�����δ� �� �� ����)
	private static int[] dy = {0, 0, -1, 1};
 	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;

		for(int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < 3; j++)
				sb.append(st.nextToken());
		}
		
		System.out.println(BFS(sb.toString()));
	}
	
	public static int BFS(String start) {
		Queue<String> queue = new LinkedList<>();

		//visited�� ��� �ɱ�?? ==> �� map���� üũ�մϴ� 
		queue.add(start); //���� String�� ���� ==> int������ �ȵſ�????? ==> numOfSearch�� �� ã��.
		map.put(start, 0); //������ �� Ž�� Ƚ���� 0
		
		while(!queue.isEmpty()) {
			String v = queue.poll();
			int zeroIdx = v.indexOf('0'); //�� ĭ�� ����� ã�� 
			int numOfSearch = map.get(v); //���ݱ����� Ž�� Ƚ��
			
			//���� ��Ʈ���� v�� �����ϸ� ���� or ť�� ���� ��Ʈ���� �����Ѵٸ�(contains) ���� 
			if(v.equals(answer))
				return numOfSearch;
						
			//������ �迭�� �ε����� ������ ���ؼ� 2���� �迭(3*3)ó�� ��Ÿ���� ����� �ִ�.
			int x = zeroIdx / 3;
			int y = zeroIdx % 3;
			
			//v�� ��� ���� ������ ã�� ==> ������ �� ���غ��� ���� �ȿ� ��� �͸� ���Ѵ�(�̫��׿�)
			for(int i = 0; i < dx.length; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				//���� ������ �Ѱ�ٸ� ���� �������� ��Ƽ��
				if(nx >= 3 || nx < 0 || ny >= 3 || ny < 0)
					continue;
				
				//���� ������ 0�� ĭ�� ���� �ٲ۴�. 
				int idx = (nx * 3) + ny; //���� ������ ������ �ε��� 
				char newChar = v.charAt(idx); //����ġ
				
				String nextStr = v.replace(newChar, '9'); //'9'�� temp
				nextStr = nextStr.replace('0', newChar);
				nextStr = nextStr.replace('9', '0');
				
				//���� �� �� ���� �ȵǳ�?? ==> �� �ȵ�
				//ť�� �ٲ� ��Ʈ���� ���� ==> �ʿ��� �����鼭 Value�� +1 ����������.
				if(!map.containsKey(nextStr)) {
					queue.add(nextStr);
					map.put(nextStr, numOfSearch + 1);
				}
			}
			//����... �� ���ѵ� �ǳ�? ==> �� ��Ʈ��ŷ�� �ƴ϶�
		}
		return -1;
	}

}
