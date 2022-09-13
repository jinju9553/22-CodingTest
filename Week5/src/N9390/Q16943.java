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
				if(item[i] == 0 && k == 0) //첫 자리로 0을 뽑을 수 없음
					continue; //return 해버리면 추가적인 케이스를 못 보고 끝나니 주의
				
				visited[i] = true; //다음 반복으로 continue하기 전에 체크하면 못 뽑으니 주의
				solution(item, currentSum * 10 + item[i], target, k + 1); 
				
				visited[i] = false;
				//currentSum = (currentSum - item[i] * 10) / 10; 
				//만약 값을 바꿨다면 계산한 값도 원복 
			}
		}
	}
}
