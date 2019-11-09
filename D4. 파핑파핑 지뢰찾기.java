import java.util.*;

public class Main {
	static int N, res;
	static int[] dx = {0, 1, 0, -1, 1, 1, -1, -1}, dy = {1, 0, -1, 0, 1, -1, 1, -1};
	static char[][] map;
	static int[][] arr;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        
        for(int test_case = 1; test_case <= tc; test_case++)
        {
        	res = 0;
        	N = sc.nextInt();
        	map = new char[N][N];
        	arr = new int[N][N];
        	Queue<Pair> q = new LinkedList<>();
        	
        	for(int i = 0; i < N; i++)
        		map[i] = sc.next().toCharArray();
        	
        	for(int i = 0; i < N; i++)
        		for(int j = 0; j < N; j++)
        		{
        			if(map[i][j] == '*')
        			{
        				arr[i][j] = 9;
        				continue;
        			}
        			for(int k = 0; k < 8; k++)
        			{
        				int nx = i + dx[k], ny = j + dy[k];
        				if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
        				if(map[nx][ny] == '*') arr[i][j]++;
        			}
        			if(arr[i][j] == 0)
        				q.add(new Pair(i, j));
        		}
        	
        	for(int i = 0; i < N; i++)
        		for(int j = 0; j < N; j++)
        			if(map[i][j] == '.' && arr[i][j] == 0)
        			{
        				res++;
        				dfs(i, j);
        			}
        	
        	for(int i = 0; i < N; i++)
        		for(int j = 0; j < N; j++)
        			if(map[i][j] == '.') res++;
        	
        	System.out.println("#" + test_case + " " + res);
        }
    }
	private static void dfs(int x, int y) {
		map[x][y] = 'o';
		for(int i = 0; i < 8; i++)
		{
			int nx = x + dx[i], ny = y + dy[i];
			if(nx < 0 || ny < 0 || nx >= N || ny >= N || map[nx][ny] == '*') continue;
			if(arr[nx][ny] == 0 && map[nx][ny] == '.')
				dfs(nx, ny);
			map[nx][ny] = 'o';
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