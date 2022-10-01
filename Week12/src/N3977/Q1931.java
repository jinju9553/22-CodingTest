package N3977;

import java.io.*;
import java.util.*;

public class Q1931 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Meeting[] meetings = new Meeting[N];
		
		String[] temp;
		for(int i = 0; i < N; i++) {
			temp = br.readLine().split(" ");
			int start = Integer.parseInt(temp[0]);
			int end = Integer.parseInt(temp[1]);
			
			meetings[i] = new Meeting(start, end);
		}
		
		Arrays.sort(meetings);
		
		int end = 0; int count = 0;
		for(int i = 0; i < N; i++) {
			if(end > meetings[i].start) //���� ȸ�ǰ� ���� ������ �ʾҴٸ�
				continue; //�� ȸ�Ǹ� �������� ����
			
			end = meetings[i].end;
			count++; //ȸ�Ǹ� ������
		}
		
		System.out.println(count);
	}
	
	public static class Meeting implements Comparable<Meeting> {
		int start;
		int end;
		
		public Meeting(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Meeting m) {
			if(this.end > m.end)
				return 1;
			else if(this.end < m.end)
				return -1;
			else { //end�� ���� ���ٸ�
				if(this.start < m.start) //start�� �������� �����Ѵ�.
					return -1;
				return 1;
			}
		}
	}
}
