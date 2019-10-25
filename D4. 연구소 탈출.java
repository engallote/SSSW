import java.util.*;

public class Main {
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        
        for(int test_case = 1; test_case <= tc; test_case++)
        {
        	String res = "ZOMBIE";
        	int time = 0;
        	int N = sc.nextInt();
        	int M = sc.nextInt();
        	boolean[][] chk = new boolean[N][M];
        	int[][] arr = new int[N][M];
        	Queue<Pair> sam = new LinkedList<>();
        	Queue<Pair> virus = new LinkedList<>();
        	for(int i = 0; i < N; i++)
        		for(int j = 0; j < M; j++)
        		{
        			arr[i][j] = sc.nextInt();
        			if(arr[i][j] == 2)//바이러스
        			{
        				chk[i][j] = true;
        				virus.add(new Pair(i, j, 0));
        			}
        			else if(arr[i][j] == 3)
        			{
        				chk[i][j] = true;
//        				arr[i][j] = 0;
        				sam.add(new Pair(i, j, 0));
        			}
        		}
        	boolean flag = false;
        	while(!sam.isEmpty())
        	{
        		int size = virus.size();
        		
        		for(int i = 0; i < size; i++)
        		{
        			Pair p = virus.poll();
        			for(int j = 0; j < 4; j++)
        			{
        				int nx = p.x + dx[j], ny = p.y + dy[j];
        				if(nx < 0 || ny < 0 || nx >= N || ny >= M || arr[nx][ny] == 1 || arr[nx][ny] == 2)
        					continue;
        				chk[nx][ny] = true;
        				arr[nx][ny] = 2;
        				virus.add(new Pair(nx, ny, p.cnt + 1));
        			}
        		}
        		
        		size = sam.size();
        		
        		for(int i = 0; i < size; i++)
        		{
        			Pair p = sam.poll();
//        			arr[p.x][p.y] = 0;
        			for(int j = 0; j < 4; j++)
        			{
        				int nx = p.x + dx[j], ny = p.y + dy[j];
        				if(nx < 0 || ny < 0 || nx >= N || ny >= M)//탈출 성공
        				{
        					flag = true;
        					time = p.cnt + 1;
        					break;
        				}
        				else if(arr[nx][ny] != 0 || chk[nx][ny])
        					continue;
        				chk[nx][ny] = true;
        				arr[nx][ny] = 3;
        				sam.add(new Pair(nx, ny, p.cnt + 1));
        			}
        			if(flag) break;
        		}
        		if(flag) break;
        		if(!flag && sam.isEmpty())
        		{
        			while(!virus.isEmpty())
        			{
        				size = virus.size();
                		
                		for(int i = 0; i < size; i++)
                		{
                			Pair p = virus.poll();
                			for(int j = 0; j < 4; j++)
                			{
                				int nx = p.x + dx[j], ny = p.y + dy[j];
                				if(nx < 0 || ny < 0 || nx >= N || ny >= M || arr[nx][ny] == 1 || arr[nx][ny] == 2)
                					continue;
                				chk[nx][ny] = true;
                				arr[nx][ny] = 2;
                				virus.add(new Pair(nx, ny, p.cnt + 1));
                			}
                		}
        			}
        			break;
        		}
//        		for(int i = 0; i < N; i++)
//            	{
//        			for(int j = 0; j < M; j++)
//        				System.out.print(arr[i][j] + " ");
//        			System.out.println();
//            	}
//        		System.out.println("----------------");
        	}
        	
        	if(!flag)
        	{
        		for(int i = 0; i < N; i++)
        			for(int j = 0; j < M; j++)
        				if(arr[i][j] == 3)
        				{
        					res = "CANNOT ESCAPE";
        					break;
        				}
        		System.out.println("#" +test_case + " " + res);
        	}
        	else
        		System.out.println("#" +test_case + " " + time);
        }
    }
}
class Pair{
	int x, y, cnt;
	Pair(int x, int y, int cnt)
	{
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
}