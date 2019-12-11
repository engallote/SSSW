import java.util.*;

public class Main {
	static int N, K;
	static int[] arr;
	static int[][] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.nextInt();
			K = sc.nextInt();
			arr = new int[N];
			for(int i = 0; i < N; i++)
				arr[i] = sc.nextInt();
			Arrays.sort(arr);
			int res = 0;
			boolean flag = true;
			for(int i = 0; i < N; i++)
			{
				flag = true;
				for(int j = i + 1; j < N; j++)
					if(arr[j] - arr[i] > K)
					{
						flag = false;
						res = Math.max(res, j - i);
						break;
					}
				if(flag) res = Math.max(res, N - i);
			}
			System.out.println("#" + test_case + " " + res);
		}
	}
}