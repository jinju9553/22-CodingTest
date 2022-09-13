package N9390;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q16943 {

	public static boolean[] visited;
	public static int rslt = -1;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader( System.in ));
		
		String[] temp = br.readLine().split(" ");
		String A = temp[0];
		int B = Integer.parseInt(temp[1]);
		int[] item = new int[A.length()];
		visited = new boolean[A.length()];
		
		for(int i = 0; i < A.length(); i++)
			item[i] = A.charAt(i) - '0';
		
		solution(item, 0, B, 0);
		
		System.out.println(rslt);
	}
	
	public static void solution(int[] item, int currentSum, int target, int k) {
		
		if(k == item.length) {
			if(currentSum < target)
				rslt = (currentSum > rslt) ? currentSum : rslt;
			
			return;
		}
		
		for(int i = 0; i < item.length; i++) {
			if(!visited[i]) {				
				if(item[i] == 0 && k == 0) //ù �ڸ��� 0�� ���� �� ����
					continue; //return �ع����� �߰����� ���̽��� �� ���� ������ ����
				
				visited[i] = true; //���� �ݺ����� continue�ϱ� ���� üũ�ϸ� �� ������ ����
				solution(item, currentSum * 10 + item[i], target, k + 1); 
				
				visited[i] = false;
				//currentSum = (currentSum - item[i] * 10) / 10; 
				//���� ���� �ٲ�ٸ� ����� ���� ���� 
			}
		}
	}
}
