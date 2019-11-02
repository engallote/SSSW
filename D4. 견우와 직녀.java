import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
		for(int test_case = 1; test_case <= tc; test_case++)
		{
			int res = 0;
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[][] arr = new int[N][N];
			int[][][] chk = new int[N][N][2];
			for(int i = 0; i < N; i++)
				for(int j = 0; j < N; j++)
				{
					Arrays.fill(chk[i][j], Integer.MAX_VALUE);
					arr[i][j] = sc.nextInt();
				}
					
			PriorityQueue<Pair> pq = new PriorityQueue<>();
			pq.add(new Pair(0, 0, 1, 0));
			chk[0][0][0] = chk[0][0][1] = 0;
			
			while(!pq.isEmpty())
			{
				Pair p = pq.poll();
				if(p.x == N - 1 && p.y == N - 1)
				{
					res = p.cnt;
					break;
				}
				
				for(int i = 0; i < 4; i++)
				{
					int nx = p.x + dx[i], ny = p.y + dy[i];
					if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
					int wait = p.cnt + 1;
					if(arr[nx][ny] == 1 && chk[nx][ny][p.w] > wait)//길
					{
						chk[nx][ny][p.w] = wait;
						pq.add(new Pair(nx, ny, p.w, wait));
					}
					else if(arr[p.x][p.y] == 1 && arr[nx][ny] >= 2)//이미 만들어져있는 다리(현재 땅에 있다)
					{
						while(wait % arr[nx][ny] != 0) wait++;
						if(chk[nx][ny][p.w] > wait)
						{
							chk[nx][ny][p.w] = wait;
							pq.add(new Pair(nx, ny, p.w, wait));
						}
					}
					else if(p.w == 1 && arr[p.x][p.y] == 1 && arr[nx][ny] == 0)//다리를 만들 때(현재 땅에 있을 경우)
					{
						while(wait % M != 0) wait++;
						if(chk[nx][ny][0] > wait)
						{
							chk[nx][ny][0] = wait;
							pq.add(new Pair(nx, ny, 0, wait));
						}
					}
				}
			}
			
			System.out.println("#" + test_case + " " + res);
		}
	}
}
class Pair implements Comparable<Pair>{
	int x, y, w,cnt;
	Pair(int x, int y, int w, int cnt)
	{
		this.x = x;
		this.y = y;
		this.w = w;
		this.cnt = cnt;
	}
	@Override
	public int compareTo(Pair o) {
		return o.cnt > this.cnt ? -1 : 1;
	}
}