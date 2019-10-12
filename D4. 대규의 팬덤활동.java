import java.util.*;

public class Main {
	static int N;
	static final int mod = 1000000000;
	static long[][][] dp;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        
        for(int test_case = 1; test_case <= tc; test_case++)
        {
        	N = sc.nextInt();
        	dp = new long[N][10][1500];
        	
        	for(int i = 0; i < N; i++)
        		for(int j = 0; j <= 9; j++)
        			Arrays.fill(dp[i][j], -1);
        	
        	System.out.println("#" + test_case + " " + (solve(0, 0, 0) % mod));
        }
	}
	private static long solve(int idx, int chk, int pre) {
		if(idx == N)
		{
			for(int i = 0; i <= 9; i++)//0~9까지 모두 포함되어야 한다
				if((chk&(1<<i)) == 0) return 0;
			return 1;
		}
		
		if(dp[idx][pre][chk] != -1) return dp[idx][pre][chk];
		
		long ret = 0;
		if(idx == 0)
		{
			for(int i = 1; i <= 9; i++)
				ret += solve(idx + 1, chk|(1<<i) , i) % mod;
		}
		else
		{
			for(int i = 0; i <= 9; i++)
			{
				if(Math.abs(pre - i) == 1)
				{
					if((chk&(1<<i)) == 0)
						ret += solve(idx + 1, chk|(1<<i) , i) % mod;
					else
						ret += solve(idx + 1, chk, i) % mod;
				}
			}
		}
		
		return dp[idx][pre][chk] = ret;
	}
}