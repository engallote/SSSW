import java.util.*;

public class Main {
	static int N;
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.nextInt();
			arr = new int[N];
			int[] dp = new int[N];
			for(int i = 0; i < N; i++)
				arr[i] = sc.nextInt();
			
			dp[0] = arr[0];
			
			for(int i = 1; i < N; i++)
				dp[i] = Math.max(dp[i-1] + arr[i], dp[i-1] * arr[i]);
			
			System.out.println("#" + test_case + " " + dp[N-1]);
		}
	}
}