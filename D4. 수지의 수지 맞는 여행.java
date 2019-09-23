import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			int M = sc.nextInt();
			int res = 0;
			
			char[][] arr = new char[N][M];
			for(int i = 0; i < N; i++)
				arr[i] = sc.next().toCharArray();
			
			PriorityQueue<Pair> pq = new PriorityQueue<>();
			pq.add(new Pair(0, 0, 1 << (arr[0][0] - 'A'), 1));
			
			while(!pq.isEmpty())
			{
				Pair p = pq.poll();
				
				res = Math.max(res, p.cnt);
				
				for(int i = 0; i < 4; i++)
				{
					int nx = p.x + dx[i], ny = p.y + dy[i];
					if(nx < 0 || ny < 0 || nx >= N || ny >= M || (p.key&(1<<arr[nx][ny]-'A')) != 0)
						continue;
					pq.add(new Pair(nx, ny, p.key|(1<<arr[nx][ny]-'A'), p.cnt + 1));
				}
			}
			System.out.println("#" + test_case + " " + res);
		}
	}
}
class Pair implements Comparable<Pair>{
	int x, y, key, cnt;
	Pair(int x, int y, int key, int cnt)
	{
		this.x = x;
		this.y = y;
		this.key = key;
		this.cnt = cnt;
	}
	@Override
	public int compareTo(Pair o) {
		return o.cnt > this.cnt ? 1 : -1;
	}
}