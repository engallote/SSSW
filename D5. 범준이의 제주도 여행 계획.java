import java.util.*;

public class Main {
	static int N, M, res;
	static int[][] dist;
	static boolean[] chk;
	static Pair[] arr;
	static Vector<Integer> ans;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        
        for(int test_case = 1; test_case <= tc; test_case++)
        {
        	res = 0;
        	ans = new Vector<>();
        	int air = 0;
        	N = sc.nextInt();
        	M = sc.nextInt();
        	chk = new boolean[N+1];
        	dist = new int[N+1][N+1];
        	arr = new Pair[N+1];
        	for(int i = 1; i <= N-1; i++)
        		for(int j = i + 1; j <= N; j++)
        			dist[i][j] = dist[j][i] = sc.nextInt();
        	
        	for(int i = 1; i <= N; i++)
        	{
        		char c = sc.next().charAt(0);
        		if(c == 'A')
        		{
        			air = i;
        			arr[i] = new Pair(c, 0, 0);
        		}
        		else if(c == 'P')
        		{
        			int time = sc.nextInt();
        			int sat = sc.nextInt();
        			arr[i] = new Pair(c, time, sat);
        		}
        		else
        			arr[i] = new Pair(c, 0, 0);
        	}
        	ArrayList<Integer> path = new ArrayList<>();
        	solve(air, 1, 0, 0, path);
        	ans.add(air);
        	System.out.print("#" + test_case + " " + res + " ");
        	if(res == 0)
        	{
        		System.out.println();
        		continue;
        	}
        	for(int i : ans)
        		System.out.print(i + " ");
        	System.out.println();
        }
    }
	private static void solve(int cur, int day, int time, int sat, ArrayList<Integer> path) {
		if(time > 540 || day > M) return;
		for(int i = 1; i <= N; i++)
		{
			if(time + arr[i].time + dist[cur][i] <= 540 && arr[i].c == 'P' && !chk[i])
			{
				chk[i] = true;
				path.add(i);
				solve(i, day, time + arr[i].time + dist[cur][i], sat + arr[i].sat, path);
				path.remove(path.size() - 1);
				chk[i] = false;
			}
			if(day == M && time + dist[cur][i] <= 540 && arr[i].c == 'A')
			{
				if(sat > res)
				{
					res = sat;
					ans.clear();
					for(int k : path)
						ans.add(k);
				}
			}
			if(time + dist[cur][i] <= 540 && arr[i].c == 'H')
			{
				path.add(i);
				solve(i, day + 1, 0, sat, path);
				path.remove(path.size() - 1);
			}
		}
	}
}
class Pair{
	char c;
	int time, sat;
	Pair(char c, int time, int sat)
	{
		this.c = c;
		this.time = time;
		this.sat = sat;
	}
}