import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = 10;
        int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
        for(int test_case = 1; test_case <= tc; test_case++)
        {
        	int res = 0, ex = 0, ey = 0;
        	int N = sc.nextInt();
        	int[][] arr = new int[100][100];
        	boolean[][] chk = new boolean[100][100];
        	Queue<Pair> q = new LinkedList<>();
        	
        	for(int i = 0; i < 100; i++)
        	{
        		char[] c = sc.next().toCharArray();
        		for(int j = 0; j < 100; j++)
        		{
        			arr[i][j] = c[j] - '0';
        			if(arr[i][j] == 2)
        			{
        				chk[i][j] = true;
        				q.add(new Pair(i, j));
        			}
        			else if(arr[i][j] == 3)
        			{
        				ex = i;
        				ey = j;
        			}
        		}
        	}
        	
        	while(!q.isEmpty())
        	{
        		Pair p = q.poll();
        		if(p.x == ex && p.y == ey)
        		{
        			res = 1;
        			break;
        		}
        		for(int i = 0; i < 4; i++)
        		{
        			int nx = p.x + dx[i], ny = p.y + dy[i];
        			if(nx < 0 || ny < 0 || nx >= 100 || ny >= 100 || arr[nx][ny] == 1 || chk[nx][ny]) continue;
        			chk[nx][ny] = true;
        			q.offer(new Pair(nx, ny));
        		}
        	}
        	
        	System.out.println("#" + test_case + " " + res);
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