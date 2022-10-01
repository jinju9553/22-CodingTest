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
			if(end > meetings[i].start) //직전 회의가 아직 끝나지 않았다면
				continue; //이 회의를 선택하지 않음
			
			end = meetings[i].end;
			count++; //회의를 선택함
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
			else { //end가 서로 같다면
				if(this.start < m.start) //start를 기준으로 정렬한다.
					return -1;
				return 1;
			}
		}
	}
}
