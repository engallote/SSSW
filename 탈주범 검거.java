import java.util.*;
 
public class Main {
    static int N, M, res;
    static int[][] arr;
    static boolean[][] chk;
    static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for(int test_case = 1; test_case <= tc; test_case++)
        {
            N = sc.nextInt();
            M = sc.nextInt();
            int r = sc.nextInt();
            int c = sc.nextInt();
            int L = sc.nextInt();
            arr = new int[N][M];
            chk = new boolean[N][M];
            for(int i = 0; i < N; i++)
            	for(int j = 0; j < M; j++)
            		arr[i][j] = sc.nextInt();
            
            Queue<Pair> q = new LinkedList<>();
            
            res = 0;
            int nx, ny;
            
            for(int l = 0; l < L; l++)
            {
            	if(l == 0)
            	{
            		q.add(new Pair(r, c));
                    chk[r][c] = true;
            	}
            	else
            	{
            		int size = q.size();
            		for(int k = 0; k < size; k++)
            		{
            			Pair p = q.poll();
                    	switch(arr[p.x][p.y])
                		{
                    	case 1: 
                    		for(int i = 0; i < 4; i++)
                    		{
                    			nx = p.x + dx[i];
                        		ny = p.y + dy[i];
                        		if(range(nx, ny))
                        		{
                        			if((i == 0 && arr[nx][ny] != 3 && arr[nx][ny] != 5 && arr[nx][ny] != 6) || 
                        				(i == 1 && arr[nx][ny] != 2 && arr[nx][ny] != 4 && arr[nx][ny] != 5) ||
                        				(i == 2 && arr[nx][ny] != 3 && arr[nx][ny] != 4 && arr[nx][ny] != 7) ||
                        				(i == 3 && arr[nx][ny] != 2 && arr[nx][ny] != 6 && arr[nx][ny] != 7))
                        			{
                        				chk[nx][ny] = true;
                            			q.add(new Pair(nx, ny));
                        			}
                        		}
                    		}
                    		break;
                    	case 2:
                    		nx = p.x + dx[0];
                    		ny = p.y + dy[0];
                    		if(range(nx, ny) && arr[nx][ny] != 3 && arr[nx][ny] != 5 && arr[nx][ny] != 6)
                    		{
                    			chk[nx][ny] = true;
                    			q.add(new Pair(nx, ny));
                    		}
                    		nx = p.x + dx[2];
                    		ny = p.y + dy[2];
                    		if(range(nx, ny) && arr[nx][ny] != 3 && arr[nx][ny] != 4 && arr[nx][ny] != 7)
                    		{
                    			chk[nx][ny] = true;
                    			q.add(new Pair(nx, ny));
                    		}
                    		break;
                    	case 3:
                    		nx = p.x + dx[1];
                    		ny = p.y + dy[1];
                    		if(range(nx, ny) && arr[nx][ny] != 2 && arr[nx][ny] != 4 && arr[nx][ny] != 5)
                    		{
                    			chk[nx][ny] = true;
                    			q.add(new Pair(nx, ny));
                    		}
                    		nx = p.x + dx[3];
                    		ny = p.y + dy[3];
                    		if(range(nx, ny) && arr[nx][ny] != 2 && arr[nx][ny] != 6 && arr[nx][ny] != 7)
                    		{
                    			chk[nx][ny] = true;
                    			q.add(new Pair(nx, ny));
                    		}
                    		break;
                    	case 4:
                    		nx = p.x + dx[2];
                    		ny = p.y + dy[2];
                    		if(range(nx, ny) && arr[nx][ny] != 3 && arr[nx][ny] != 7 && arr[nx][ny] != 4)
                    		{
                    			chk[nx][ny] = true;
                    			q.add(new Pair(nx, ny));
                    		}
                    		nx = p.x + dx[1];
                    		ny = p.y + dy[1];
                    		if(range(nx, ny) && arr[nx][ny] != 2 && arr[nx][ny] != 5 && arr[nx][ny] != 4)
                    		{
                    			chk[nx][ny] = true;
                    			q.add(new Pair(nx, ny));
                    		}
                    		break;
                    	case 5:
                    		nx = p.x + dx[1];
                    		ny = p.y + dy[1];
                    		if(range(nx, ny) && arr[nx][ny] != 2 && arr[nx][ny] != 4 && arr[nx][ny] != 5)
                    		{
                    			chk[nx][ny] = true;
                    			q.add(new Pair(nx, ny));
                    		}
                    		nx = p.x + dx[0];
                    		ny = p.y + dy[0];
                    		if(range(nx, ny) && arr[nx][ny] != 3 && arr[nx][ny] != 5 && arr[nx][ny] != 6)
                    		{
                    			chk[nx][ny] = true;
                    			q.add(new Pair(nx, ny));
                    		}
                    		break;
                    	case 6:
                    		nx = p.x + dx[0];
                    		ny = p.y + dy[0];
                    		if(range(nx, ny) && arr[nx][ny] != 3 && arr[nx][ny] != 5 && arr[nx][ny] != 6)
                    		{
                    			chk[nx][ny] = true;
                    			q.add(new Pair(nx, ny));
                    		}
                    		nx = p.x + dx[3];
                    		ny = p.y + dy[3];
                    		if(range(nx, ny) && arr[nx][ny] != 2 && arr[nx][ny] != 6 && arr[nx][ny] != 7)
                    		{
                    			chk[nx][ny] = true;
                    			q.add(new Pair(nx, ny));
                    		}
                    		break;
                    	case 7:
                    		nx = p.x + dx[2];
                    		ny = p.y + dy[2];
                    		if(range(nx, ny) && arr[nx][ny] != 3 && arr[nx][ny] != 4 && arr[nx][ny] != 7)
                    		{
                    			chk[nx][ny] = true;
                    			q.add(new Pair(nx, ny));
                    		}
                    		nx = p.x + dx[3];
                    		ny = p.y + dy[3];
                    		if(range(nx, ny) && arr[nx][ny] != 2 && arr[nx][ny] != 6 && arr[nx][ny] != 7)
                    		{
                    			chk[nx][ny] = true;
                    			q.add(new Pair(nx, ny));
                    		}
                    		break;
                		}
            		}
            	}
            }
            
            for(int i = 0; i < N; i++)
            {
            	for(int j = 0; j < M; j++)
            	{
            		if(chk[i][j]) res++;
//            		System.out.print(chk[i][j] ? "1 " : "0 ");
            	}
//            	System.out.println();
            }
            
            System.out.println("#" + test_case + " " + res);
        }
    }
	private static boolean range(int x, int y) {
		if(x < 0 || y < 0 || x >= N || y >= M || chk[x][y] || arr[x][y] == 0) return false;
		else return true;
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