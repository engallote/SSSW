import java.util.*;

public class Main {
	static int N, M, res;
	static boolean[] chk;
	static int[][] arr;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        
        for(int test_case = 1; test_case <= tc; test_case++)
        {
        	res = Integer.MAX_VALUE - 1;
        	int N = sc.nextInt();
        	int M = sc.nextInt();
        	
        	arr = new int[N+1][N+1];
        	chk = new boolean[N+1];
        	
        	for(int i = 0; i < M; i++)
        	{
        		int a = sc.nextInt();
        		int b = sc.nextInt();
        		int c = sc.nextInt();
        		arr[a][b] = c;
        	}
        	
        	for(int i = 1; i <= N; i++)
        	{
        		Arrays.fill(chk, false);
        		Queue<Pair> q = new LinkedList<>();
        		q.add(new Pair(i, 0));
        		
        		while(!q.isEmpty())
        		{
        			Pair p = q.poll();
        			if(p.cost > res) continue;
        			if(p.to == i && p.cost > 0)
        			{
        				res = Math.min(res, p.cost);
        				break;
        			}
        			for(int j = 1; j <= N; j++)
        				if(!chk[j] && arr[p.to][j] > 0)
        				{
        					chk[j] = true;
        					q.add(new Pair(j, p.cost + arr[p.to][j]));
        				}
        		}
        	}
        	
        	System.out.println("#" + test_case + " " + res);
        }
    }
}
class Pair{
	int to, cost;
	Pair(int to, int cost){
		this.to = to;
		this.cost = cost;
	}
}