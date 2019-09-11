import java.util.*;

public class Main {
	static int X, N;
	static long mod = 1000000007;
	static long[][] dp = new long[101][101];
	static Pair[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			X = sc.nextInt();
			N = sc.nextInt();
			arr = new Pair[N + 1];
			
			Arrays.fill(dp[0], -1);
			
			for(int i = 1; i <= N; i++)
			{
				arr[i] = new Pair(sc.nextInt(), sc.nextInt());
				Arrays.fill(dp[i], -1);
			}
			Arrays.sort(arr, 1, N+1);
			
			long res = solve(0, 0) % mod;
			System.out.println("#" + test_case + " " + res);
		}
	}
	private static long solve(int idx, int e) {
		if(idx > N) 
		{
			if(e >= X) return 1;
			return 0;
		}
		if(dp[idx][e] != -1) return dp[idx][e] % mod;
		long ret = 0;
		
		if(e == 0)
		{
			for(int i = 1; i <= N; i++)
				if(arr[i].s == 1)
					ret += solve(i + 1, arr[i].e) % mod;
		}
		else 
		{
			ret += solve(idx + 1, e);
			if(arr[idx].s <= e + 1)
				ret += solve(idx + 1, Math.max(arr[idx].e, e));
		}
		
		return dp[idx][e] = ret % mod;
	}
}
class Pair implements Comparable<Pair>{
	int s, e;
	Pair(int s, int e){
		this.s = s;
		this.e = e;
	}
	@Override
	public int compareTo(Pair o) {
		if(o.s > this.s) return -1;
		else if(o.s == this.s)
		{
			if(o.e > this.e) return -1;
			else if(o.e == this.e) return 0;
			else return 1;
		}
		else return 1;
	}
}