package N3964;

import java.io.*;
import java.util.StringTokenizer;

public class Q10972 {

	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );

		int N = Integer.parseInt(br.readLine());
		
		int[] target = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) 
			target[i] = Integer.parseInt(st.nextToken());

		if(solution(target) == false)
			sb.append("-1");
		else {
			for(int i = 0; i < target.length; i++)
				sb.append(target[i]).append(" ");
		}
		
		System.out.println(sb);
	}

	public static boolean solution(int[] target) {
		
		int swapIdx = -1;
		for(int i = 1; i < target.length; i++) { //O(N)
			if(target[i - 1] < target[i])
				swapIdx = i - 1; //������ �����ϴ� ���� ū i�� ã�´�.
		}
		
		if(swapIdx == -1)
			return false;
		
		int largerIdx = -1;
		for(int j = 1; j < target.length; j++) { //O(N)
			if(target[swapIdx] < target[j])
				largerIdx = j; //������ �����ϴ� j�� ���� �ڿ� �־�� ��(��������=>target[swapIdx]�� �����)
		}

		swap(target, swapIdx, largerIdx); //O(1)
		
		int j = target.length - 1;
		for(int i = swapIdx + 1; i < j; i++) { //O(N)
			swap(target, i, j);
			j--;
		}
		
		return true;
	}
	
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}