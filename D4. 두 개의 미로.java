import java.util.*;

public class Main {
	static int N;
	static boolean end;
	static char[] a, b;
	static int[][] dp;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();        
        
        for(int test_case = 1; test_case <= tc; test_case++)
        {
        	N = sc.nextInt();
        	end = false;
        	a = sc.next().toCharArray();
        	b = sc.next().toCharArray();
        	dp = new int[N+1][N+1];
        	System.out.print("#" + test_case + " ");
        	
    		if((a[N - 1] == 'N' && b[N - 1] == 'S') || (a[N - 1] == 'S' && b[N - 1] == 'N') || (a[N - 1] == 'W' && b[N - 1] == 'E') || (a[N - 1] == 'E' && b[N - 1] == 'W'))
    			System.out.println("NO");
    		else
    		{
    			solve(0, 0);
    			if(end)
    				System.out.println("YES");
    			else
    				System.out.println("NO");
    		}
        }
    }
	private static void solve(int idx1, int idx2) {
		if(end || dp[idx1][idx2] > 0) return;
		dp[idx1][idx2] = 1;
//		System.out.println(idx1 + " " + idx2);
		if(idx1 == N - 1 && idx2 == N - 1)
		{
			end = true;
			return;
		}
		if(idx1 < N && idx2 < N)
		{
			if(a[idx1] == b[idx2])
			{
				if(idx1 + 1 < N && idx2 + 1 < N)
					solve(idx1 + 1, idx2 + 1);
				if(idx1 + 1 < N && idx2 == N-1)
					solve(idx1 + 1, idx2);
				if(idx1 == N - 1 && idx2 + 1 < N)
					solve(idx1, idx2 + 1);
			}
			else
			{
				if((a[idx1] == 'W' && b[idx2] == 'E') || (a[idx1] == 'E' && b[idx2] == 'W') || (a[idx1] == 'S' && b[idx2] == 'N') || (a[idx1] == 'N' && b[idx2] == 'S'))
				{
					if(idx2 - 1 >= 0 && idx1 + 1 < N)
						solve(idx1 + 1, idx2 - 1);
					else if(idx2 == 0 && idx1 + 1 < N)
						solve(idx1 + 1, idx2);
					if(idx1 - 1 >= 0 && idx2 + 1 < N)
						solve(idx1 - 1, idx2 + 1);
					else if(idx1 == 0 && idx2 + 1 < N)
						solve(idx1, idx2 + 1);
					
				}
				else
				{
					if(idx1 + 1 < N) solve(idx1 + 1, idx2);
					if(idx2 + 1 < N) solve(idx1, idx2 + 1);
				}
			}
		}
	}
}