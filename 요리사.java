import java.util.*;

public class Main {
	static int N, res;
	static int[][] arr;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        
        for(int test_case = 1; test_case <= tc; test_case++)
        {
        	N = sc.nextInt();
        	arr = new int[N][N];
        	res = Integer.MAX_VALUE;
        	for(int i = 0; i < N; i++)
        		for(int j = 0; j < N; j++)
        			arr[i][j] = sc.nextInt();
        	
        	for(int i = 0; i < N / 2; i++)
        		solve(1, i + 1, (1<<i));
            System.out.println("#" + test_case + " " + res);
        }
	}
	private static void solve(int cnt, int idx, int chk) {
		if(cnt == N / 2)
		{
			sum(chk);
			return;
		}
		
		for(int i = idx; i < N; i++)
			if((chk&(1<<i)) == 0)
				solve(cnt + 1, i + 1, chk|(1<<i));
	}
	private static void sum(int chk) {
		int sum1 = 0, sum2 = 0;
		for(int i = 0; i < N; i++)
		{
			if((chk&(1<<i)) == 0)
			{
				for(int j = 0; j < N; j++)
					if((chk&(1<<j)) == 0)
						sum1 += arr[i][j];
			}
			else
			{
				for(int j = 0; j < N; j++)
					if((chk&(1<<j)) != 0)
						sum2 += arr[i][j];
			}
		}
		res = Math.min(res, Math.abs(sum1 - sum2));
	}
}