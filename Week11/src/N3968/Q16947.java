package N3968;

import java.io.*;
import java.util.*;

public class Q16947 {
	
	private static ArrayList<Integer> graph[];
	private static boolean[] visited;
	private static boolean[] isCycle;
	private static int[] distance;
	
	private static StringBuilder sb = new StringBuilder();

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		graph = new ArrayList[T + 1]; //������ ������ŭ ũ�� �ʱ�ȭ(0�� ����)
		isCycle = new boolean[T + 1];
		distance = new int[T + 1];
		
		for(int i = 1; i <= T; i++)
			graph[i] = new ArrayList<>();
		
		String[] temp;
		for(int i = 0; i < T; i++) {
			temp = br.readLine().split(" ");
			
			int u = Integer.parseInt(temp[0]);
			int v = Integer.parseInt(temp[1]);
			
			graph[u].add(v);
			graph[v].add(u);
		}
		
		//1.����Ŭ Ž�� - DFS
		int cycleStart = 1;
		for(int i = 1; i <= T; i++) {
			visited = new boolean[T + 1]; 
			
			if(DFS(i, 0, i)) {
				cycleStart = i; //����Ŭ �������� ���
				break;
			}
		}
		
		visited = new boolean[T + 1]; //��Ȱ���� ���� �ʱ�ȭ
		
		//2.�Ÿ� ��� - BFS
		BFS(T, cycleStart); //����Ŭ ���������� Ž��
		
		for(int i = 1; i <= T; i++) //BFS �ȿ��� �ϸ� ������ ���̹Ƿ� ����
			sb.append(distance[i]).append(" ");
		
		System.out.println(sb);
	}

	public static boolean DFS(int current, int prev, int start) {
		visited[current] = true;
		
		for(int w : graph[current]) { //current�� ����� ���� w Ž��
			if(!visited[w]) { //���� �湮�� �� ������
				if(DFS(w, current, start)) { //�� ���� �������� �ٽ� DFS 
					isCycle[w] = true; //�߰� Ž������ ����Ŭ�� �߰��ߴٸ� �� ������ ����Ŭ�� ����
					return true; //��� Ž��
				}
			}
			else if(visited[w] && (w != prev) && (w == start)) {
				//���ʷ� (end == start)�� �߰ߵǴ� ��
				isCycle[w] = true; //�� ���� ����� ����Ŭ�� ��ͷ� ã�´�.
				return true;
			}
		}
		return false;
	}
	
	public static boolean BFS(int vertex, int currentStart) {
		Queue<Integer> queue = new LinkedList<>();
		
		visited[currentStart] = true;
		queue.add(currentStart);
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			while(size-- > 0) {
				int v = queue.poll();
				
				for(int w : graph[v]) {
					if(!visited[w]) {
						visited[w] = true;
						queue.add(w);
						
						if(!isCycle[w]) //����Ŭ ���� �����̸� ���� ���� X
							distance[w] = distance[v] + 1; //���� ����� ������ �ʺ񿡼� + 1
					}
				}
			} //�� ���� ����
		} //ū while�� ����
		return false;
	}
}
