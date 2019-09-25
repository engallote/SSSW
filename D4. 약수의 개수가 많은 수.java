import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] dp = new int[100001], num = new int[100001];
		dp[1] = num[1] = 1;
		dp[2] = dp[3] = num[2] = 2;
		num[3] = 3;
		HashSet<Integer> hs = new HashSet<>();
		for(int i = 4; i <= 100000; i++)
		{
			hs.clear();
			for(int j = 2; j <= (int)Math.sqrt(i); j++)
				if(i % j == 0)
				{
					hs.add(j);
					hs.add(i/j);
				}
			hs.add(i);
			if(dp[i-1] > hs.size()) 
			{
				dp[i] = dp[i-1];
				num[i] = num[i-1];
			}
			else
			{
				dp[i] = hs.size();
				num[i] = i;
			}
		}
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			System.out.println("#" + test_case + " " + num[N]);
		}
	}
}