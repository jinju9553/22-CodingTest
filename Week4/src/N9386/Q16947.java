package N9386;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Q16947 {

	private static ArrayList<Integer> graph[]; //���� ���� ArrayList�� �ް� �ִ� �迭
	private static boolean[] visited; //ó���� ��� false
	private static boolean[] isCycle;
	private static int[] distance;
	
	private static StringBuilder sb = new StringBuilder();
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		
		int T = Integer.parseInt(br.readLine());
		graph = new ArrayList[T + 1]; //������ ������ŭ ũ�� �ʱ�ȭ(0�� ����)
		visited = new boolean[T + 1]; 
		isCycle = new boolean[T + 1];
		distance = new int[T + 1];
		
		for(int i = 1; i <= T; i++) //ũ�⸦ �����ϰ�, �� �ȿ� �� �÷��� ����Ʈ�� �ϳ��ϳ� ������ ��
			graph[i] = new ArrayList<>();
		
		String[] initLine; int u; int v;
		for(int i = 0; i < T; i++) {
			initLine = br.readLine().split(" ");
			u = Integer.parseInt(initLine[0]);
			v = Integer.parseInt(initLine[1]);
			
			graph[u].add(v);
			graph[v].add(u);
		}
		
		//����Ʈ: ���� ������ ���������� �ٸ��� �Ͽ� Ž��. �ֱٿ� �湮�� ������ ������� �Ǻ� �Ұ���
		for(int i = 1; i <= T; i++)
			if(DFS(i, 0, i)) 
				break; //����Ŭ�� �߰��ߴٸ� Ž�� ����
		
		visited = new boolean[T + 1]; //��Ȱ���� ���� �ʱ�ȭ
		
		BFS(T, 1); //����: ���� 1���� ã���� �ȵ�
		
		for(int i = 1; i <= T; i++) //BFS �ȿ��� �ϸ� ������ ���̹Ƿ� ����
			sb.append(distance[i]).append(" ");
		
		System.out.println(sb);
	}

	public static boolean DFS(int current, int prev, int start) { //start: ������ ���� ������ ���
		visited[current] = true;

		//����Ŭ: ���� ������ ���� ������ ����(���ÿ�, ������ �湮�� ������ �ƴѵ��� �̹� visited�� ������ ����)
		for(int w : graph[current]) { //currentStart�� ��� �������� w�� Ž���Ѵ� 
				if (!visited[w]) { //�湮�� �� ���ٸ�
					if(DFS(w, current, start)) { //���� ������ ���������� ��� ���Ӱ� Ž��
						isCycle[w] = true; //���� �߰� Ž������ ����Ŭ�� �ִٰ� �Ͽ�����, ���� ������ ����Ŭ�� ���Ե�!
						return true; //��� Ž��
					}
				}
				else if(visited[w] && (w != prev) && (w == start)) { 
					//�湮�� �� �ִ� ������ �߰��Ͽ��µ� ���������� �ٸ���, ������ ������������ �ǵ��� �Դٸ� ����Ŭ
					isCycle[w] = true; //�� w�� ����� ����Ŭ �������� ��ͷ� ã�´�.
					return true; //��� Ž��
				}
		}
		return false; //�� �������κ��� ������ Ž���� ������. �� �̻� Ž�� ������ ���� ������ ���� 
	}
	
	public static void BFS(int vertex, int currentStart) {
		Queue<Integer> queue = new LinkedList<>();

		visited[currentStart] = true;
		queue.add(currentStart);
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			while(size-- > 0) {
				int v = queue.poll();
				
				for(int w : graph[v]) { //DFS������ ��ͷ� ������ ���� BFS������ �ݺ������� ����
					if(!visited[w]) {
						visited[w] = true;
						queue.add(w);

						if(!isCycle[w]) //����Ŭ ���� �����̸� ���� ���� X
							distance[w] = distance[v] + 1; //���� ����� ������ �ʺ񿡼� + 1
					}
				}
			}
		}
	}
}
