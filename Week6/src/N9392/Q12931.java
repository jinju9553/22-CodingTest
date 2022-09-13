package N9392;

import java.io.*;
import java.util.*;

public class Q12931 {

	public static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		int[] target = new int[T];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i < T; i++)
			target[i] = Integer.parseInt(st.nextToken());
		
		System.out.println(solution(target));
	}
	
	public static boolean isAllZero(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] != 0)
				return false;
		}
		
		return true;
	}
	
	public static boolean isAllEven(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] % 2 != 0) //2�� ���� �������� 0�� �ƴ϶��
				return false;
		}
		
		return true;
	}
	
	public static int solution(int[] arr) {
		
		int k = 0;
		
		while(!isAllZero(arr)) {
			//(1)2�� ���� �� ���� �� 
			if(isAllEven(arr)) {
				for(int i = 0; i < arr.length; i++)
					arr[i] /= 2; //2�� ������ 
				
				k++;
			}
			else { //(2)2�� ���� �� ���� ��
				for(int i = 0; i < arr.length; i++) {
					if(arr[i] % 2 != 0) {
						arr[i] -= 1;
						k++; //�ϳ� �� ������ ���� Ƚ�� +1
					}
				}
			}
		}
		
		return k;
	}
}
