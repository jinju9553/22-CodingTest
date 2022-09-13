package week1;

import java.util.ArrayList;
//import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Q2693 { //주의: 제출 시 클래스명 Main으로 수정할 것

	public static void main(String[] args) {
		//1.배열 T줄을 입력받기
		Scanner sc = new Scanner(System.in);
		int arraySize = 10; //문제 조건: 배열의 개수 고정
		
		//참고: ArrayList나 Array나 시간은 똑같음 
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		int T = sc.nextInt(); //줄의 개수
		for (int i = 0; i < T; i++) { 
			for (int j = 0; j < arraySize; j++) {
				list.add(sc.nextInt());
			}
			//2.정렬하기
			Collections.sort(list);
			
			//3.N번째 큰 값을 찾기
			System.out.println(list.get(7));
			list.clear();
		}
		sc.close();
	}
}
