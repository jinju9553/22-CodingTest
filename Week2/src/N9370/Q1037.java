package N9370;

import java.util.ArrayList;
import java.util.Scanner;

public class Q1037 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		int T = sc.nextInt();
		
		for(int i = 0; i < T; i++) {
			list.add(sc.nextInt());
		}
		
		int p = 0, q = 1;
		for(int i = 0; i < list.size() - 1; i++) { //p가 마지막 인덱스(길이 - 1)를 가리키는 순간 종료
			int rslt = list.get(p) * list.get(q);
			for (int j = 1; j < list.size(); j++) {
				if(j == q)
					continue;
				
				if(rslt % list.get(j) != 0) {
					//if() 증가?조건을?설정하기에는 너무 복잡한데
					p = p + 1;
					q = p + 1;
					break;
				}
			}
		}
		
		sc.close();
	}
}
