import java.util.*;

public class Main {
	static int N, M, res;
	static int[] arr;
	static int[][] map;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();        
        for(int test_case = 1; test_case <= tc; test_case++)
        {
        	res = 0;
        	N = sc.nextInt();
        	M = sc.nextInt();
        	map = new int[N][M];
        	arr = new int[N];
        	for(int i = 0; i < N; i++)
        	{
        		int max = 0;
        		for(int j = 0; j < M; j++)
        		{
        			map[i][j] = sc.nextInt();
        			if(j - 4 >= 0)
        				map[i][j] = Math.max(map[i][j] + map[i][j-4], Math.max(map[i][j] + map[i][j-3], map[i][j] + map[i][j-2]));
        			else if(j - 3 >= 0)
        				map[i][j] = Math.max(map[i][j] + map[i][j-3], map[i][j] + map[i][j-2]);
        			else if(j - 2 >= 0)
        				map[i][j] = map[i][j] + map[i][j-2];
        			if(max < map[i][j])
        				max = map[i][j];
        		}
        		arr[i] = max;
        	}
        	
        	int[] dp = new int[N];
        	dp[0] = arr[0];
        	res = dp[0];
        	for(int i = 1; i < N; i++)
        	{
        		if(i - 4 >= 0)
        			dp[i] = Math.max(dp[i-4], Math.max(dp[i-2], dp[i-3])) + arr[i];
        		else if(i - 3 >= 0)
        			dp[i] = Math.max(dp[i-2], dp[i-3]) + arr[i];
        		else if(i - 2 >= 0)
        			dp[i] = dp[i-2] + arr[i];
        		else
        			dp[i] = arr[i];
        		res = Math.max(res, dp[i]);
        	}
        	
        	System.out.println("#" + test_case + " " + res);
        }
    }
}