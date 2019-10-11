import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        
        for(int t = 1; t <= tc; t++)
        {
        	int N = sc.nextInt();
        	int M = sc.nextInt();
        	ArrayList<Integer>[] arr = new ArrayList[N+1];
        	boolean[] f = new boolean[N+1], chk = new boolean[N+1];
        	chk[1] = true;
        	for(int i = 1; i <= N; i++)
        		arr[i] = new ArrayList<>();
        	
        	for(int i = 0; i < M; i++)
        	{
        		int a = sc.nextInt();
        		int b = sc.nextInt();
        		arr[a].add(b);
        		arr[b].add(a);
        		if(a == 1 || b == 1)
        			f[a] = f[b] = true;
        	}
        	
        	Queue<Integer> q = new LinkedList<>();
        	q.add(1);
        	int cnt = 0;
        	while(!q.isEmpty())
        	{
        		int x = q.poll();
        		if(f[x])
        		{
        			for(int i = 0; i < arr[x].size(); i++)
            		{
            			int next = arr[x].get(i);
            			if(!chk[next])
            			{
            				chk[next] = true;
            				q.add(next);
            				cnt++;
            			}
            		}
        		}
        	}
        	
        	System.out.println("#" + t + " " + cnt);
        }
    }
}