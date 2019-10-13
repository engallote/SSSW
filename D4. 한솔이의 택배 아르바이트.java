import java.util.*;

public class Main {
	static int N, res;
	static int[] arr;
	static boolean[] chk;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for(int test_case = 1; test_case <= tc; test_case++)
        {
        	N = sc.nextInt();
        	arr = new int[N];
        	chk = new boolean[N];
//        	Random rd = new Random();
        	for(int i = 0; i < N; i++)
        	{
        		arr[i] = sc.nextInt();
//        		arr[i] = rd.nextInt(101);
        	}
        	Arrays.sort(arr);
        	res = 0;
        	
        	solve(0, N-1, 1, arr[N-1], 0);
        	System.out.println("#" + test_case + " " + res);
        }
	}
	private static void solve(int l, int r, int cnt, int num, int dep) {
		if(l >= r)
		{
			if(num * cnt >= 50)
				res = Math.max(res, dep + 1);
			else
				res = Math.max(res, dep);
			return;
		}
		
		if(num * cnt >= 50) solve(l, r - 1, 1, arr[r-1], dep + 1);
		else
			solve(l + 1, r, cnt + 1, num, dep);
	}
}