package N3955;

import java.io.*;
import java.util.*;

public class Q1935 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		String formula = br.readLine();
		
		Stack<Double> stack = new Stack<>();
		
		double[] arr = new double[T]; //����: T�� �ǿ������� ������ 
		for(int i = 0; i < T; i++)
			 arr[i] = Double.parseDouble(br.readLine());
		
		for(int i = 0; i < formula.length(); i++) {
			char nextCh = formula.charAt(i);
			if(nextCh != '+' && nextCh != '-' && nextCh != '*' && nextCh != '/') {
				stack.push(arr[nextCh - 'A']); //nextCh�� ������ ���� �ε����� ������
			}
			else {
				double op2 = stack.pop(); //LIFO ������ ����!!
				double op1 = stack.pop();
				switch(nextCh) {
					case '+': {
						stack.push(op1 + op2);
						break;
					}
					case '-': {
						stack.push(op1 - op2);
						break;
					}
					case '*': {
						stack.push(op1 * op2);
						break;
					}
					case '/': {
						stack.push(op1 / op2);
						break;
					}
				}
			}
		} //for�� ��
		
		System.out.println(String.format("%.2f", stack.pop()));
	}

}
