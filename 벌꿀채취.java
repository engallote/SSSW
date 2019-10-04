import java.util.*;

public class Main {
	static int N, M, C, res, max;
	static int[][] arr;
	static boolean[][] chk;
	static int[] tmp;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        
        for(int test_case = 1; test_case <= tc; test_case++)
        {
        	N = sc.nextInt();
        	M = sc.nextInt();
        	C = sc.nextInt();
        	arr = new int[N][N];
        	chk = new boolean[N][N];
        	tmp = new int[M];
        	res = 0;
        	for(int i = 0; i < N; i++)
        		for(int j = 0; j < N; j++)
        			arr[i][j] = sc.nextInt();
        	
        	solve(0, 0);
            System.out.println("#" + test_case + " " + res);
        }
	}
	private static void solve(int idx, int sum) {
		if(idx == 2)
		{
//			System.out.println("...... " + sum);
			res = Math.max(res, sum);
			return;
		}
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j <= N-M; j++)
			{
				if(chk[i][j]) continue;
				boolean flag = true;
				int id = 0;
				max = 0;
				for(int k = j; k < j + M; k++)
				{
					if(chk[i][k])
					{
						flag = false;
						break;
					}
					chk[i][k] = true;
//					System.out.print(arr[i][k] + " ");
					tmp[id++] = arr[i][k];
				}
//				System.out.println();
				if(!flag) continue;
				findMax(0, 0, 0);
				solve(idx + 1, sum + max);
				for(int k = j; k < j + M; k++)
					chk[i][k] = false;
			}
				
	}
	private static void findMax(int idx, int chk, int sum) {
		if(idx == M)
		{
			int mul = 0;
			for(int i = 0; i < M; i++)
			{
				if((chk&(1<<i)) != 0)
					mul += tmp[i] * tmp[i];
			}
			max = Math.max(max, mul);
			return;
		}
		if(sum + tmp[idx] <= C)
			findMax(idx + 1, chk|(1<<idx), sum + tmp[idx]);
		findMax(idx + 1, chk, sum);
	}
}