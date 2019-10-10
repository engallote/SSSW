import java.util.*;

public class Main {
	static int len;
	static long mod = 1000000007;
	static long[][] dp;
	static char[] arr, order = {'S','A','M','S','U','N','G'};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			arr = sc.next().toCharArray();
			len = arr.length;
			dp = new long[len][7];
			for(int i = 0; i < len; i++)
				Arrays.fill(dp[i], -1);
			
			long res = solve(0, 0) % mod;
			System.out.println("#" + test_case + " " + res);
		}
	}
	private static long solve(int idx, int idx2) {
		if(idx2 == 7) return 1;
		if(idx == len) return 0;
		if(dp[idx][idx2] != -1) return dp[idx][idx2] % mod;
		long ret = 0;
		
		if(arr[idx] == order[idx2])
		{
			ret += solve(idx + 1, idx2 + 1);
			ret %= mod;
		}
		ret += solve(idx + 1, idx2);
		ret %= mod;
		
		return dp[idx][idx2] = ret % mod;
	}
}