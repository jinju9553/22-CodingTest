package N9393;

import java.io.*;
import java.util.*;

public class Q2056 { //9%

	public static int[] time;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		@SuppressWarnings("unchecked")
		LinkedList<Integer> graph[] = new LinkedList[T + 1];
		int[] indegree = new int[T + 1];
		int[] weight = new int[T + 1]; //���⼭ ����ġ�� �ð�
		time = new int[T + 1];
		
		for(int i = 1; i <= T; i++)
			graph[i] = new LinkedList<Integer>();

		//����: �ܹ��� �׷���, i = 1�� ������ ����
		StringTokenizer st; int n = 0;
		for(int i = 1; i <= T; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			weight[i] = Integer.parseInt(st.nextToken()); //ù ��°: ����ġ
			
			n = Integer.parseInt(st.nextToken()); //�� ��°: ���� ������ ����
			indegree[i] = n;
			
			for(int j = 0; j < n; j++) //�� ��° ����: ����� ������
				graph[Integer.parseInt(st.nextToken())].add(i);
		}
		
		System.out.println(topological(graph, indegree, weight));
	}

	public static int topological(LinkedList<Integer> graph[], int[] indegree, int[] weight) {
		
		Queue<Integer> queue = new LinkedList<>();
		int maxTime = Integer.MIN_VALUE;
		
		//1.ť�� ���� ������ 0�� ��常 ��´�. (1�� ������ ����)
		for(int i = 1; i < indegree.length; i++) { //���̴� �ε����� �������̹Ƿ� ����
			if(indegree[i] == 0)
				queue.add(i);
		}
		
		//2.ť�� �� ������
		while(!queue.isEmpty()) {
			//3.��� �ϳ��� ������
			int v = queue.poll();
			
			if(time[v] == 0) time[v] = weight[v]; //���� ���� �� ���� ���� �ʱ�ȭ
			
			for(int w : graph[v]) { //v�� ����� ��� w�� ����
				indegree[w]--; //���� ������ 1�� ���ҽ�Ų��
			
				//4.���� ���� ������ 0�� �� ��尡 �ִٸ� ť�� �ִ´�.
				if(indegree[w] == 0)
					queue.add(w);
				
				time[w] = Math.max((time[v] + weight[w]), time[w]);
			}
			maxTime = (time[v] > maxTime) ? time[v] : maxTime; 
		}
		return maxTime; //��ü �ɸ��� �ð� �߿� ���� �� �ð��� �� �ҿ�ð��� 
	}
}
