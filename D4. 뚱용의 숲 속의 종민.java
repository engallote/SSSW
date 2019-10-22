import java.util.Scanner;

public class Main {
	static int N, M, sx, sy, ex, ey;
	static long res;
	static int[][] arr, chk;
	static long[][] dp;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int test_case = 1; test_case <= tc; test_case++)
		{
			N = sc.nextInt();
			M = sc.nextInt();
			arr = new int[N][M];
			dp = new long[N][M];
			chk = new int[N][M];
			
			sx = sc.nextInt();
			sy = sc.nextInt();
			ex = sc.nextInt();
			ey = sc.nextInt();
			res = 0;
			
			for(int i = 0; i < N; i++)
				for(int j = 0; j < M; j++)
				{
					dp[i][j] = -1;
					int num = sc.nextInt();
					if(num < 0)
					{
						arr[i][j] = num * -1;
						chk[i][j] = 1;//요리
					}
					else
					{
						arr[i][j] = num;
						chk[i][j] = 0;//음료
					}
				}
			
			if(arr[sx][sy] >= arr[ex][ey])
			{
				System.out.println("#" + test_case + " Sorry, princess XD");
				continue;
			}
			
			res = solve(sx, sy, chk[sx][sy], arr[sx][sy]);
			
//			for(int i = 0; i < N; i++)
//			{
//				for(int j = 0; j < N; j++)
//					System.out.print(dp[i][j] + " ");
//				System.out.println();
//			}
			
			if(res > 0)
				System.out.println("#" + test_case + " " + res);
			else
				System.out.println("#" + test_case + " Sorry, princess XD");
		}
	}
	private static long solve(int x, int y, int what, int taste) {
		if(ex == x && ey == y) return 1;
		if(dp[x][y] != -1) return dp[x][y];
		long ret = 0;
		for(int i = 0; i < 4; i++)
		{
			int nx = x + dx[i], ny = y + dy[i];
			if(nx < 0 || ny < 0 || nx >= N || ny >= M || taste >= arr[nx][ny] || arr[ex][ey] < arr[nx][ny] || (what == 1 && chk[nx][ny] == 1)) continue;
			ret += solve(nx, ny, chk[nx][ny], arr[nx][ny]);
		}
		return dp[x][y] = ret;
	}
}