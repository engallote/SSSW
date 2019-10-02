import java.util.*;

public class Main {
	static int N, M, res;
	static int[][] arr;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        
        for(int test_case = 1; test_case <= tc; test_case++)
        {
        	N = sc.nextInt();
            M = sc.nextInt();
            arr = new int[N][N];
            res = 0;
            for(int i = 0; i < N; i++)
            	for(int j = 0; j < N; j++)
            		arr[i][j] = sc.nextInt();
            
            for(int i = 0; i < N; i++)
            	for(int j = 0; j < N; j++)
            	{
            		solve(i, j);
            	}
            
            System.out.println("#" + test_case + " " + res);
        }
	}
	private static void solve(int x, int y) {
		int max = 0;
		if(arr[x][y] == 1)//K = 1
			max = 1;
		boolean[][] chk = new boolean[N][N];
		int tmp = arr[x][y], cost = 0;
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(x, y));
		chk[x][y] = true;
		for(int k = 2; k <= 25; k++)
		{
			cost = k * k + (k - 1) * (k - 1);
			int size = q.size();
			for(int s = 0; s < size; s++)
			{
				Pair p = q.poll();
				for(int i = 0; i < 4; i++)
				{
					int nx = p.x + dx[i], ny = p.y + dy[i];
					if(nx < 0 || ny < 0 || nx >= N || ny >= N || chk[nx][ny]) continue;
					chk[nx][ny] = true;
					tmp += arr[nx][ny];
					q.add(new Pair(nx, ny));
				}
			}
			
			if(tmp * M - cost > 0 && res < tmp && max < tmp)
			{
//				for(int i = 0; i < N; i++)
//				{
//					for(int j = 0; j < N; j++)
//						System.out.print(chk[i][j] ? "o " : "x ");
//					System.out.println();
//				}
//				System.out.println("............");
				max = tmp; 
			}
		}
		res = Math.max(res, max);
		return;
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