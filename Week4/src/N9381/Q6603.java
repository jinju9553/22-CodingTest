package N9381;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q6603 {

	public static int target = 6;
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
		
		String lines = br.readLine();
		int[] arr; int size; int[] bucket;
		while(!lines.contentEquals("0")) {
			size = Integer.parseInt(lines.split(" ")[0]);
			arr = new int[size];
			bucket = new int[target];
			
			for(int i = 0; i < size; i++)
				arr[i] = Integer.parseInt(lines.split(" ")[i + 1]);

			pick(arr, bucket, target);
			sb.append('\n');
			
			lines = br.readLine();
		}
		
		System.out.print(sb);
	}
	
	public static void pick(int[] items, int[] bucket, int k) {
		if(k == 0) {
			for(int i = 0; i < bucket.length; i++)
				sb.append(bucket[i]).append(" ");
			sb.append('\n');
			return;
		}
		
		int lastIndex = bucket.length - k - 1;
		
		for(int i = 0; i < items.length; i++) {
			if(bucket.length == k) { 
				bucket[0] = items[i];
				pick(items, bucket, k - 1);
			}
			else if (bucket[lastIndex] < items[i]) { 
				bucket[lastIndex + 1] = items[i]; 
				pick(items, bucket, k - 1);
			}
		}
	}

}
