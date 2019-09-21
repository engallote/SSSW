import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			long M = sc.nextLong();
			long[] arr = new long[N];
			
			for(int i = 0; i < N; i++) 
				arr[i] = sc.nextLong();
			
			Arrays.sort(arr);
			long l = 0, r = Long.MAX_VALUE - 1, mid, sum, res = 0;
			while(l <= r)
			{
				mid = (l + r) / 2;
				sum = 0;
				for(int i = N - 1; i >= 0; i--)
				{
					if(arr[i] > mid) sum += (arr[i] - mid);
					if(sum >= M) break;
				}
				if(sum >= M)
				{
					res = Math.max(res, mid);
					l = mid + 1;
				}
				else r = mid - 1;
			}
			System.out.println("#" + test_case + " " + res);
		}
	}
}