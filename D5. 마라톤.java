import java.util.*;

public class Main {
	static int N, K;
	static long[][] arr, dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.nextInt();
			K = sc.nextInt();
			arr = new long[N][2];
			dp = new long[N][K+1];
			for(int i = 0; i < N; i++)
			{
				arr[i][0] = sc.nextLong();
				arr[i][1] = sc.nextLong();
				Arrays.fill(dp[i], -1);
			}
			long res = solve(0, K);
			System.out.println("#" + test_case + " " + res);
		}
	}
	private static long solve(int idx, int cnt) {
		if(idx >= N - 1) return 0;
		if(dp[idx][cnt] != -1) return dp[idx][cnt];
		long ret = Integer.MAX_VALUE;
		for(int i = 0; i <= cnt; i++)
			if(idx + i + 1 <= N - 1)
			{
				long sum = Math.abs(arr[idx][0]-arr[idx+i+1][0]) + Math.abs(arr[idx][1]-arr[idx+i+1][1]);
				ret = Math.min(ret, solve(idx + i + 1, cnt - i) + sum);
			}
		
		return dp[idx][cnt] = ret;
	}
}