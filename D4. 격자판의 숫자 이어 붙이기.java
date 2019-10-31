import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
        for(int test_case = 1; test_case <= tc; test_case++)
        {
        	int res = 0;
        	int[][] arr = new int[4][4];
        	HashSet<String> hs = new HashSet<>();
        	
        	for(int i = 0; i < 4; i++)
        		for(int j = 0; j < 4; j++)
        			arr[i][j] = sc.nextInt();
        	
        	for(int i = 0; i < 4; i++)
        		for(int j = 0; j < 4; j++)
        		{
        			Queue<Pair> q = new LinkedList<>();
        			q.add(new Pair(i, j, 1, arr[i][j]+""));
        			
        			while(!q.isEmpty())
        			{
        				Pair p = q.poll();
        				if(p.cnt == 7)
        				{
        					hs.add(p.s);
        					continue;
        				}
        				
        				for(int k = 0; k < 4; k++)
        				{
        					int nx = p.x + dx[k], ny = p.y + dy[k];
        					if(nx < 0 || ny < 0 || nx >= 4 || ny >= 4) continue;
        					q.offer(new Pair(nx, ny, p.cnt + 1, p.s + arr[nx][ny]));
        				}
        			}
        		}
        	System.out.println("#" + test_case + " " + hs.size());
        }
    }
}
class Pair{
	int x, y, cnt;
	String s;
	Pair(int x, int y, int cnt, String s)
	{
		this.x = x;
		this.y = y;
		this.cnt = cnt;
		this.s = s;
	}
}