import java.util.*;

public class Main {
	static int N, M, cnt = 0;
	static char[][] arr;
	static boolean[][] visit;
	static int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
	static Queue<Pair> q = new LinkedList<>();
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        
        for(int t = 1; t <= tc; t++)
        {
        	N = sc.nextInt();
        	M = sc.nextInt();
        	int Q = sc.nextInt();
        	arr = new char[N][M];
        	
        	for(int i = 0; i < N; i++)
        		arr[i] = sc.next().toCharArray();
        	
        	for(int k = 0; k < Q; k++)
        	{
        		char c = sc.next().charAt(0);
        		switch(c)
        		{
        		case 'D':
        			int max = 0;
        			visit = new boolean[N][M];
        			Queue<Pair> tmp = new LinkedList<>();
        			for(int i = 0; i < N; i++)
        				for(int j = 0; j < M; j++)
        					if(arr[i][j] != '#' && !visit[i][j])
        					{
        						cnt = 0;
        						dfs(i, j);
        						if(cnt > max)
        						{
        							max = cnt;
        							tmp.clear();
        							while(!q.isEmpty())
        								tmp.add(q.poll());
        						}
        						else if(max == cnt)
        							while(!q.isEmpty())
        								tmp.add(q.poll());
        						q.clear();
        					}
        			while(!tmp.isEmpty())
        			{
        				Pair p = tmp.poll();
        				arr[p.x][p.y] = '#';
        			}
        			solve(); //빈 공간 채우기
        			break;
        		case 'L':
        			PriorityQueue<Pair> pq = new PriorityQueue<>(new SortLeft());
        			for(int i = 0; i < N; i++)
        				for(int j = 0; j < M; j++)
        					if(arr[i][j] != '#')
        						pq.add(new Pair(i, j));
        			sort(pq, -1);
        			break;
        		case 'R':
        			PriorityQueue<Pair> pq2 = new PriorityQueue<>(new SortRight());
        			for(int i = 0; i < N; i++)
        				for(int j = 0; j < M; j++)
        					if(arr[i][j] != '#')
        						pq2.add(new Pair(i, j));
        			sort(pq2, 1);
        			break;
        		case 'U':
        			char[] add = sc.next().toCharArray();
        			boolean flag = true;
        			for(int i = 0; i < M; i++)
        			{
        				if(arr[0][i] != '#')
        				{
        					flag = false;
        					break;
        				}
        			}
        			if(!flag) break;
        			for(int i = 1; i < N; i++)
        			{
        				for(int j = 0; j < M; j++)
        				{
        					arr[i-1][j] = arr[i][j];
        					arr[i][j] = '#';
        				}
        			}
        			for(int i = 0; i < M; i++)
        				arr[N-1][i] = add[i];
        			solve();
        			break;
        		}
//        		for(int i = 0; i < N; i++)
//            	{
//            		for(int j = 0; j < M; j++)
//            			System.out.print(arr[i][j]);
//            		System.out.println();
//            	}
//        		System.out.println("-------------------------");
        	}
        	System.out.println("#" + t);
        	for(int i = 0; i < N; i++)
        	{
        		for(int j = 0; j < M; j++)
        			System.out.print(arr[i][j]);
        		System.out.println();
        	}
        	System.out.println();
        }
    }
	private static void sort(PriorityQueue<Pair> pq, int d) {
		if(d == -1)//왼쪽
		{
			while(!pq.isEmpty())
			{
				Pair p = pq.poll();
				int ny = p.y;
				while(ny >= 0)
				{
					if(arr[p.x][ny] == '#')
					{
						arr[p.x][ny] = arr[p.x][ny + 1];
						arr[p.x][ny + 1] = '#';
					}
					ny--;
				}
			}
		}
		else//오른쪽
		{
			while(!pq.isEmpty())
			{
				Pair p = pq.poll();
				int ny = p.y + 1;
				while(ny < M)
				{
					if(arr[p.x][ny] == '#')
					{
						arr[p.x][ny] = arr[p.x][ny - 1];
						arr[p.x][ny - 1] = '#';
					}
					ny++;
				}
			}
		}
	}
	private static void solve() {
		Queue<Pair> tmp = new LinkedList<>();
		for(int i = N - 1; i >= 0; i--)
			for(int j = 0; j < M; j++)
				if(arr[i][j] != '#')
					tmp.add(new Pair(i, j));
		
		while(!tmp.isEmpty())
		{
			Pair p = tmp.poll();
			int nx = p.x + 1;
			while(nx < N)
			{
				if(arr[nx][p.y] == '#')
				{
					arr[nx][p.y] = arr[nx - 1][p.y];
					arr[nx - 1][p.y] = '#';
				}
				nx++;
			}
		}
	}
	private static void dfs(int x, int y) {
		visit[x][y] = true;
		q.add(new Pair(x, y));
		cnt++;
		for(int i = 0; i < 4; i++)
		{
			int nx = x + dx[i], ny = y + dy[i];
			if(nx < 0 || ny < 0 || nx >= N || ny >= M || visit[nx][ny] || arr[x][y] != arr[nx][ny]) continue;
			dfs(nx, ny);
		}
	}
}
class Pair{
	int x, y;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
}
class SortLeft implements Comparator<Pair>{
	@Override
	public int compare(Pair o1, Pair o2) {
		if(o1.y > o2.y) return 1;
		else if(o1.y == o2.y) return 0;
		else return -1;
	}
}
class SortRight implements Comparator<Pair>{
	@Override
	public int compare(Pair o1, Pair o2) {
		if(o1.y > o2.y) return -1;
		else if(o1.y == o2.y) return 0;
		else return 1;
	}
}