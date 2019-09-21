import java.util.*;

public class Main {
	static int N;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	static int[][] arr;
	static boolean[][] chk;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.nextInt();
			arr = new int[N][N];
			chk = new boolean[N][N];
			int res = 1, cnt = 0, max = 0;
			Queue<Pair>[] q = new LinkedList[101];
			for(int i = 0; i <= 100; i++)
				q[i] = new LinkedList<>();
			
			for(int i = 0; i < N; i++)
				for(int j = 0; j < N; j++)
				{
					arr[i][j] = sc.nextInt();
					max = Math.max(max, arr[i][j]);
					q[arr[i][j]].add(new Pair(i, j));
				}
			
			for(int t = 1; t <= max; t++)
			{
				while(!q[t].isEmpty())
				{
					Pair p = q[t].poll();
					arr[p.x][p.y] = 0;
				}
				for(int i = 0; i < N; i++)
					Arrays.fill(chk[i], false);
				cnt = 0;
				for(int i = 0; i < N; i++)
					for(int j = 0; j < N; j++)
						if(arr[i][j] != 0 && !chk[i][j])
						{
							dfs(i, j);
							cnt++;
						}
				res = Math.max(res, cnt);	
			}
			System.out.println("#" + test_case + " " + res);
		}
	}
	private static void dfs(int x, int y) {
		chk[x][y] = true;
		
		for(int i = 0; i < 4; i++)
		{
			int nx = x + dx[i], ny = y + dy[i];
			if(nx < 0 || ny < 0 || nx >= N || ny >= N || chk[nx][ny] || arr[nx][ny] == 0)
				continue;
			dfs(nx, ny);
		}
		
	}
}
class Pair{
	int x, y;
	Pair(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
}