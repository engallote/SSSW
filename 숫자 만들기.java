import java.util.*;

public class Main {
	static int N, res, max, min;
	static int[] arr, op = new int[4];
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        
        for(int test_case = 1; test_case <= tc; test_case++)
        {
        	N = sc.nextInt();
        	arr = new int[N];
        	res = 0;
        	for(int i = 0; i < 4; i++)
        		op[i] = sc.nextInt();
        	
        	for(int i = 0; i < N; i++)
        		arr[i] = sc.nextInt();
        	
        	min = Integer.MAX_VALUE;
        	max = Integer.MIN_VALUE;
        	
        	solve(1, arr[0]);
//        	System.out.println(max + " " + min);
        	res = max - min;
            System.out.println("#" + test_case + " " + res);
        }
	}
	private static void solve(int idx, int sum) {
		if(idx == N)
		{
			max = Math.max(max, sum);
			min = Math.min(min, sum);
			return;
		}
		
		for(int i = 0; i < 4; i++)
		{
			if(op[i] > 0)
			{
				op[i]--;
				if(i == 0) solve(idx + 1, sum + arr[idx]);
				else if(i == 1) solve(idx + 1, sum - arr[idx]);
				else if(i == 2) solve(idx + 1, sum * arr[idx]);
				else solve(idx + 1, sum / arr[idx]);
				op[i]++;
			}
		}
	}
}