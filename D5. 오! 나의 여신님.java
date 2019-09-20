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
			char[][] arr = new char[N][M];
			Queue<Pair> s = new LinkedList<>(), e = new LinkedList<>();
			for(int i = 0; i < N; i++)
			{
				arr[i] = sc.next().toCharArray();
				for(int j = 0; j < M; j++)
				{
					if(arr[i][j] == 'S') s.add(new Pair(i, j));
					else if(arr[i][j] == '*') e.add(new Pair(i, j));
				}
			}
			
			boolean flag = false;
			int time = 0, size = 0;
			
			while(!s.isEmpty())
			{
				time++;
				size = e.size();
				
				for(int t = 0; t < size; t++)
				{
					Pair p = e.poll();
					for(int i = 0; i < 4; i++)
					{
						int nx = p.x + dx[i], ny = p.y + dy[i];
						if(nx < 0 || ny < 0 || nx >= N || ny >= M || arr[nx][ny] == 'X' || arr[nx][ny] == '*' || arr[nx][ny] == 'D')
							continue;
						arr[nx][ny] = '*';
						e.add(new Pair(nx, ny));
					}
				}
				
				size = s.size();
				for(int t = 0; t < size; t++)
				{
					Pair p = s.poll();
					for(int i = 0; i < 4; i++)
					{
						int nx = p.x + dx[i], ny = p.y + dy[i];
						if(nx < 0 || ny < 0 || nx >= N || ny >= M || arr[nx][ny] == 'X' || arr[nx][ny] == '*' || arr[nx][ny] == 'S')
							continue;
						if(arr[nx][ny] == 'D')
						{
							flag = true;
							break;
						}
						arr[nx][ny] = 'S';
						s.add(new Pair(nx, ny));
					}
					if(flag) break;
				}
				if(flag) break;
			}
			
			System.out.println("#" + test_case + " " + (flag ? time : "GAME OVER"));
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